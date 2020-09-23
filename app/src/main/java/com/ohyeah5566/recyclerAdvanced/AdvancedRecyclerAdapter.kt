package com.ohyeah5566.recyclerAdvanced

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ohyeah5566.databinding.ItemViewAdvancedBinding

class AdvancedRecyclerAdapter(val list: MutableList<Msg>) :
    RecyclerView.Adapter<AdvancedRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemViewAdvancedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemViewAdvancedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            recyclerTextView.text = list[position].content
            recyclerEditText.setText(list[position].editText)

            recyclerButton.setOnClickListener {
                recyclerTextView.text = recyclerEditText.text.toString()
                list[position].content = recyclerEditText.text.toString()
            }
        }
    }

    override fun getItemCount() = list.size
}