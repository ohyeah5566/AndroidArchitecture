package com.ohyeah5566

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ohyeah5566.databinding.ItemPostBinding
import com.ohyeah5566.model.Post

class PostAdapter(val list: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class ViewHolder(itemView: ItemPostBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(post: Post) {

        }

        companion object {
            fun create(parent: ViewGroup) = ViewHolder(
                ItemPostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}