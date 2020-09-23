package com.ohyeah5566.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ohyeah5566.databinding.ItemViewBinding

class RecyclerAdapter(private val list: List<com.ohyeah5566.recycler.Color>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            imageView.setBackgroundColor(Color.parseColor(list[position].colorCode))
            titleTextView.text = list[position].name
        }
    }

    override fun getItemCount() = list.size
}