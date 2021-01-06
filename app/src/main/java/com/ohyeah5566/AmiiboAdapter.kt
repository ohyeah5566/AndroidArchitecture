package com.ohyeah5566

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AmiiboAdapter(
    var list: List<Amiibo>,
    val imageClick: (url:String) -> Unit
) : RecyclerView.Adapter<AmiiboViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmiiboViewHolder {
        return AmiiboViewHolder.create(parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: AmiiboViewHolder, position: Int) {
        holder.bind(list[position],imageClick)
    }

    fun updateList(newList: List<Amiibo>) {
        list = newList
        notifyDataSetChanged()
    }
}