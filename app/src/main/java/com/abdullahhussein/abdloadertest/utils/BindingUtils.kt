package com.abdullahhussein.abdloadertest.utils

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdullahhussein.abdloader.AbdLoader


@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    recyclerView.setHasFixedSize(true)
    recyclerView.adapter = adapter
}

@BindingAdapter("loadImage")
fun textChange(imageView: ImageView, url: String) {
    Log.e("Error", url)
    AbdLoader.loadImage(url, imageView)
}