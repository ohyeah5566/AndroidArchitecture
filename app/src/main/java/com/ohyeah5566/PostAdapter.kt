package com.ohyeah5566

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.ohyeah5566.databinding.ItemPostBinding
import com.ohyeah5566.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

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

    inner class ViewHolder(itemView: ItemPostBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(post: Post) {
            with(itemView) {
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