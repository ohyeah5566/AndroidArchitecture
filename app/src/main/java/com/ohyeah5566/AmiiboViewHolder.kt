package com.ohyeah5566

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ohyeah5566.databinding.ItemViewAmiiboBinding

class AmiiboViewHolder(private val binding: ItemViewAmiiboBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(amiibo: Amiibo) {
        val context = binding.root.context
        Glide.with(context)
            .load(amiibo.image)
            .into(binding.image)

        binding.nameTextView.text = context.getString(R.string.name, amiibo.name)
        binding.charTextView.text = context.getString(R.string.character, amiibo.character)
        binding.gsTextView.text = context.getString(R.string.gameSeries, amiibo.gameSeries)
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