package com.ohyeah5566

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ohyeah5566.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel> { MainViewModelFactory(this) }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.meme.observe(this, {
            val adapter = PostAdapter(it)
            binding.recyclerView.adapter = adapter
            adapter.favoriteClickEvent = { post ->
                viewModel.postFavoriteClick(post)
            }
            it.forEach { post ->
                Log.d("MainActivity", "title:${post.title}")
            }
        })

        viewModel.loadPost("memes")
    }
}