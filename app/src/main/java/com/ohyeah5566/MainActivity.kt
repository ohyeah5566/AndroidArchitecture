package com.ohyeah5566

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohyeah5566.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View {
    lateinit var binding: ActivityMainBinding
    lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this, lifecycle)
        binding.processAB.setOnClickListener {
            presenter.processA()
            presenter.processB()
        }
        binding.finishActivity.setOnClickListener {
            finish()
        }
    }

//    目前只有一個presenter要處理 所以會覺得沒什麼
//    但之後如果有很多東西要在destroy處理 就會變得很雜亂
//    override fun onDestroy() {
//        presenter.cleanUp()
//        super.onDestroy()
//    }


    override fun Afinish() {
        runOnUiThread {
            binding.textView.text = "aFinish";
        }
    }

    override fun Bfinish() {
        val dialog = MyDialog(this)
        dialog.show()
    }
}