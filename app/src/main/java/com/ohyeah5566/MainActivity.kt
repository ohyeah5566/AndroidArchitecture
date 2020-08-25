package com.ohyeah5566

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohyeah5566.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 *  @AndroidEntryPoint
 *  讓這個Activity 可以使用Hilt
 *  主要功能是產生一個dependencies container (依賴的容器)
 *  這個容器會依賴著Activity的生命週期, 並且提供這個Activity所需要的物件實體
 *
 *  除了Activity 以下幾個也可以使用 Fragment, View, Service and BroadcastReceiver
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    /**
     * @Inject
     * 表示這個buttonCount 將會被hilt給依賴注入
     */
    @Inject
    @ButtonCountModule.ButtonCount20 //這個ButtonCount需要的實體是由provideButtonCount20提供
    lateinit var buttonCount: ButtonCount

    /**
     *  表示這個ResultInterface的實作方式 會透過hilt依賴注入
     *
     *  @SnackbarResultModule.SnackbarResult
     *  選擇用snackbar的方式 顯示result
     */
    @Inject
    @SnackbarResultModule.SnackbarResult
    lateinit var printer: ResultInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            printer.showResult("切嚕")
        }
    }
}