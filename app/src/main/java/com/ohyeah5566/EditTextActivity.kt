package com.ohyeah5566

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ohyeah5566.databinding.ActivityEditTextBinding

class EditTextActivity : AppCompatActivity(){
    lateinit var binding : ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            button.setOnClickListener {
                textView.text = editText.text.toString()
            }
        }

    }

}