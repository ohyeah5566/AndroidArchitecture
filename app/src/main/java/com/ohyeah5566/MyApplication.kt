package com.ohyeah5566

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * 透過 annotate 讓 Hilt 自己產生一些程式碼
 * 提供 component 管理生命週期, 也讓其他component可以依賴application's component
 */
@HiltAndroidApp
class MyApplication : Application()