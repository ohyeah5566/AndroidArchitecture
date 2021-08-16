package com.ohyeah5566

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ohyeah5566.adapters.PostAdapter
import com.ohyeah5566.databinding.FragmentPostListBinding

class PostListFragment : Fragment() {
    val viewModel by viewModels<MainViewModel> { MainViewModelFactory(requireContext()) }

    lateinit var binding: FragmentPostListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostListBinding.inflate(layoutInflater)

        viewModel.meme.observe(viewLifecycleOwner, {
            val adapter = PostAdapter(it)
            binding.recyclerView.adapter = adapter
            adapter.favoriteClickEvent = { post ->
                viewModel.postFavoriteClick(post)
            }
            it.forEach { post ->
                Log.d("fragmentPostList", "title:${post.title}")
            }
        })


        viewModel.loadPost(arguments?.getString("subReddit") ?: "")

        return binding.root
    }

    companion object {
        fun newInstance(subReddit: String) =
            PostListFragment().apply {
                arguments = Bundle(1).apply {
                    putString("subReddit", subReddit)
                }
            }
    }
}