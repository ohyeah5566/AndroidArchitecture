package com.ohyeah5566

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AmiiboAdapter(private val list: List<Amiibo>) : RecyclerView.Adapter<AmiiboViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmiiboViewHolder {
        return AmiiboViewHolder.create(parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: AmiiboViewHolder, position: Int) {
        holder.bind(list[position])
    }
}