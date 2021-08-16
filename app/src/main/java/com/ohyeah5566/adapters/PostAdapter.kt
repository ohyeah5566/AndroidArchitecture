package com.ohyeah5566.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.ohyeah5566.R
import com.ohyeah5566.databinding.ItemPostBinding
import com.ohyeah5566.data.Post

class PostAdapter(val list: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var favoriteClickEvent: (Post) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            with(binding) {
                subRedditName.text = "r/${post.subreddit}"
                userName.text = "Posted by u/${post.author}"
                title.text = post.title

                image.load(post.url) {
                    scale(Scale.FILL)
                }
                subRedditIcon.load(post.getSubRedditIcon()) {
                    transformations(CircleCropTransformation())
                }
                favorite.setOnClickListener {
                    post.favorite = !post.favorite
                    favoriteClickEvent.invoke(post)
                    favorite.setImageResource(if (post.favorite) R.drawable.favorite_fill_black_24dp else R.drawable.favorite_border_black_24dp)
                }
                favorite.setImageResource(if (post.favorite) R.drawable.favorite_fill_black_24dp else R.drawable.favorite_border_black_24dp)
            }
        }

    }
}