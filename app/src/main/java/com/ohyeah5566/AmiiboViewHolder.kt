package com.ohyeah5566

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ohyeah5566.databinding.ItemViewAmiiboBinding

class AmiiboViewHolder(private val binding: ItemViewAmiiboBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(amiibo: Amiibo, imageClick: (url: String) -> Unit) {
        binding.amiibo = amiibo
        binding.imageClickEvent = imageClick
        binding.executePendingBindings() //立即更新UI
    }

    companion object {
        fun create(parent: ViewGroup): AmiiboViewHolder {
            val view = ItemViewAmiiboBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return AmiiboViewHolder(view)
        }
    }
}