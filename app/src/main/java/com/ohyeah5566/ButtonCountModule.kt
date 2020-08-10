package com.ohyeah5566

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class) //綁定這個Module跟Activity的生命週期
@Module  //@Module 標記這個class是一個module
object ButtonCountModule {

    /**
     *  實作 提供物件實體的方法
     *  用@Provides Hilt就會自動將有標有@Inject的ButtonCount
     *  透過此function 提供物件實體
     */
    @Provides
    fun provideButtonCount() : ButtonCount {
        val buttonCount = ButtonCount()
        buttonCount.count = 10
        return buttonCount
    }

}