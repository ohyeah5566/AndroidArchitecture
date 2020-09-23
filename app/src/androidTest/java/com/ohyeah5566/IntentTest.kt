package com.ohyeah5566

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class IntentTest {
    private val title = "yahaha"
    private val content = "content"

    /**
     *  測試 有intent傳給Activity的時候的狀況
     */
    @Test
    fun testIntentToActivity() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            IntentActivity::class.java
        )
        intent.putExtra("title", title)
        intent.putExtra("content", content)
        ActivityScenario.launch<IntentActivity>(intent)

        onView(withId(R.id.titleTextView)).check(matches(withText(title)))
        onView(withId(R.id.contentTextView)).check(matches(withText(content)))
    }
}