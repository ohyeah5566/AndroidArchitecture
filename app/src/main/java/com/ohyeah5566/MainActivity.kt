package com.ohyeah5566

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.ohyeah5566.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subRedditList = listOf("memes", "aww", "oddlysatisfying", "Hololive") //, "liked"
        binding.pager.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount() = subRedditList.size

            override fun createFragment(position: Int): Fragment {
                return PostListFragment.newInstance(subRedditList[position])
            }
        }
        TabLayoutMediator(binding.tabview, binding.pager) { tab, position ->
            tab.text = subRedditList[position]
        }.attach()
    }
}