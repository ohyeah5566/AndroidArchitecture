package com.ohyeah5566

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUrl")
fun amiiboImage(imageView: ImageView, url: String) {
    Glide.with(imageView)
        .load(url)
        .into(imageView)
}


@BindingAdapter(value = ["app:adapter", "app:amiiboList"], requireAll = true)
fun updateAmiiboList(view: RecyclerView, adapter: AmiiboAdapter?, amiiboList: List<Amiibo>?) {
    if (view.adapter == null)
        view.adapter = adapter
    adapter?.updateList(amiiboList?: emptyList())
}