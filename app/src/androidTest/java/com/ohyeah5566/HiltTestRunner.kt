package com.ohyeah5566

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * Codelab上關於Custom TestRunner
 * Instrumented tests using Hilt need to be executed in an Application that supports Hilt.
 * The library already comes with HiltTestApplication that we can use to run our UI tests.
 * Specifying the Application to use in tests is done by creating a new test runner in the project.
 */

/** 想在Instrumented test使用Hilt, 需要在支援Hilt的Application上執行
 *  Hilt這個library已經包含了HiltTestApplication
 *  只需要創一個TestRunner指定HiltTestApplication要用在測試上即可
 */
class HiltTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}