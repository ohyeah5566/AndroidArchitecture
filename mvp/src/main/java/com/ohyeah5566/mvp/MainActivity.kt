package com.ohyeah5566.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohyeah5566.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contract.View {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val presenter: Contract.Presenter = Presenter(this)

        binding.processAB.setOnClickListener {
            presenter.processA()
            presenter.processB()
        }
        binding.finishActivity.setOnClickListener {
            presenter.cleanUp()
            finish()
        }
    }


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