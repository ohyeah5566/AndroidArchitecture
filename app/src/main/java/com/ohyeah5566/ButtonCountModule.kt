package com.ohyeah5566

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@InstallIn(ActivityComponent::class) //綁定這個Module跟Activity的生命週期
@Module  //@Module 標記這個class是一個module
object ButtonCountModule {


    @Qualifier //供Hilt辨識 該提供哪一個實體 給同樣需要inject ButtonCount
    annotation class ButtonCount10

    @Qualifier
    annotation class ButtonCount20

    /**
     *  實作 提供物件實體的方法
     *  用@Provides Hilt就會自動將有標有@Inject的ButtonCount
     *  透過此function 提供物件實體
     *
     *  標有@Inject的ButtonCount
     *  如果有標@ButtonCount10
     *  表示由此fun提供實體
     */
    @ButtonCount10
    @Provides
    fun provideButtonCount10() : ButtonCount {
        val buttonCount = ButtonCount()
        buttonCount.count = 10
        return buttonCount
    }

    /**
     * 提供ButtonCount物件 但是是從20開始
     */
    @ButtonCount20
    @Provides
    fun provideButtonCount20() : ButtonCount {
        val buttonCount = ButtonCount()
        buttonCount.count = 20
        return buttonCount
    }

}