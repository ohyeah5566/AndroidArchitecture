/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ohyeah5566

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not


//@HiltAndroidTest管理每一個Hilt components的生命週期,和執行injection
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class AppTest {

    //為每一個測試產生Hilt components
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    //點了按鈕後 看snackbar跳出的文字是不是=切嚕
    @Test
    fun testSnackBarIsShowing() {
        ActivityScenario.launch(MainActivity::class.java)

        // Tap on Button
        onView(withId(R.id.resultButton)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("切嚕")))
    }


    //點switch 切換到toast顯示模式 再按顯示的button 判斷toast有沒有跳出
    @Test
    fun switchPrinterToToast() {
        lateinit var decorView: View
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            decorView = it.window.decorView
        }

        onView(withId(R.id.resultSwitch)).perform(click())
        onView(withId(R.id.resultButton)).perform(click())
        onView(withText("切嚕")).inRoot(withDecorView(not(`is`(decorView))))
            .check(matches(isDisplayed()))

        //inRoot 要找的元件不在layout上 像是toast 或是 autoComplete,
        //TODO withDecorView(not(`is`(decorView)))
    }


    //點了按鈕後 看textView最後是不是顯示22
    @Test
    fun testAddOneButton() {
        ActivityScenario.launch(MainActivity::class.java)
        // Tap on Button
        onView(withId(R.id.addOneButton)).perform(click()) //20
        onView(withId(R.id.addOneButton)).perform(click()) //21
        onView(withId(R.id.addOneButton)).perform(click()) //22
        onView(withId(R.id.textView)).check(matches(withText("22")))
    }
}
