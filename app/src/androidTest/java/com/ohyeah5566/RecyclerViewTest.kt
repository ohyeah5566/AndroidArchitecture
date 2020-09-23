package com.ohyeah5566

import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ohyeah5566.recycler.RecyclerAdapter
import com.ohyeah5566.recycler.RecyclerViewActivity
import com.ohyeah5566.recyclerAdvanced.AdvancedRecyclerAdapter
import com.ohyeah5566.recyclerAdvanced.RecyclerViewActivity2
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith


/**
 *  espresso 有關recyclerView的測試
 */
@RunWith(AndroidJUnit4::class)
class RecyclerViewTest {

    /**
     *  執行recyclerView的Activity
     *  然後檢查 "Amaranth" 有沒有顯示出來
     */
    @Test
    fun testRecyclerView() {
        ActivityScenario.launch(RecyclerViewActivity::class.java)

        onView(withText("Amaranth"))
            .check(matches(isDisplayed()))
    }

    /**
     *  執行recyclerView的Activity
     *  然後滑動到 第8個item 檢查White有沒有顯示
     *  在初始沒有滑動的狀態下White並不會顯示 一定要有scroll才會顯示出來通過測試
     **/
    @Test
    fun testRecyclerViewScroll() {
        ActivityScenario.launch(RecyclerViewActivity::class.java)

        onView(withId(R.id.recyclerView))
            .perform(scrollToPosition<RecyclerAdapter.ViewHolder>(9))

        onView(withText("White"))
            .check(matches(isDisplayed()))
    }


    /**
     *  測試稍微複雜一點的RecyclerView item有 textView,editView,button
     *  點了button會讓editText的text顯示在textView上
     *  原生的RecyclerViewActions無法支援到這麼細的功能
     *  因此只能自訂ViewAction ,ViewAssertion
     *  盡量符合onView,perform,check的操作
     **/
    @Test
    fun testAdvancedRecyclerView() {
        ActivityScenario.launch(RecyclerViewActivity2::class.java)

        //移動到position[10] 的item , 在editTextView上輸入Text
        onView(withId(R.id.recyclerView)).perform(
            actionOnItemAtPosition<AdvancedRecyclerAdapter.ViewHolder>(
                10,
                typeTextAction("切嚕")
            )
        )

        //移動到position[10] 的item ,點擊按鈕
        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<AdvancedRecyclerAdapter.ViewHolder>(10, clickButton()))

        //確定TextView上的文字是否為輸入的文字
        //用isDisplayed會因為一個畫面有EditText跟TextView都符合而出錯
        onView(withId(R.id.recyclerView))
            .check(checkTextViewText("切嚕", 10))

    }

    //自訂輸入文字的ViewAction
    private fun typeTextAction(inputText: String): ViewAction {
        return object : ViewAction {
            //規範哪一個view的type可以操作 ?
            override fun getConstraints() = null

            //描述這個viewAction的行為 ?
            override fun getDescription() = "des."

            //找到item中的editText再setText
            //UiController提供一些基本的操作,不過這邊可以setText所以就不用了
            override fun perform(uiController: UiController?, view: View?) {
                val editText = view?.findViewById<EditText>(R.id.recyclerEditText)
                editText?.setText(inputText)
            }
        }
    }

    //自訂點擊item的按鈕
    private fun clickButton(): ViewAction {
        return object : ViewAction {
            override fun getConstraints() = null

            override fun getDescription() = "des."

            override fun perform(uiController: UiController?, view: View?) {
                val button = view?.findViewById<Button>(R.id.recyclerButton)
                button?.performClick()
            }
        }
    }

    // check內需要的是ViewAssertion 所以自訂一個ViewAssertion
    // 這邊原本打算拿到viewHolder的textView 再拿text出來比對
    // 不過再不動原本寫法的狀況下好像拿不到viewHolder 所以只能拿adapter的list裡的資料去判斷了
    private fun checkTextViewText(assertText: String, position: Int): ViewAssertion {
        return object : ViewAssertion {
            override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
                if (view is RecyclerView) {
                    val adapter = view.adapter
                    if (adapter is AdvancedRecyclerAdapter) {
                        ViewMatchers.assertThat(
                            adapter.list[position].content,
                            CoreMatchers.equalTo(assertText)
                        )
                    }
                }
            }
        }
    }
}

