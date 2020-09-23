package com.ohyeah5566

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ohyeah5566.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            titleTextView.text = intent.getStringExtra("title")
            contentTextView.text = intent.getStringExtra("content")
        }
    }
}