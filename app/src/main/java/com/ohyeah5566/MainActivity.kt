package com.ohyeah5566

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ohyeah5566.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel> { MainViewModelFactory() }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.meme.observe(this, {
            binding.recyclerView.adapter = PostAdapter(it)
            it.forEach { post ->
                Log.d("MainActivity", "title:${post.title}")
            }
        })

        viewModel.loadPost("memes")
    }
}