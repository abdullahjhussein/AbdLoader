/*
 * Copyright (c) Abdullah Hussein Dce
 * a.hussein@dce.sa
 */

package com.abdullahhussein.abdloadertest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdullahhussein.abdloadertest.databinding.ItemImageBinding
import com.abdullahhussein.abdloadertest.model.ImageItem
import java.util.*

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    private val items: ArrayList<ImageItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemImageBinding = ItemImageBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(getItem(position))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(items: List<ImageItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun appendData(items: List<ImageItem>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun getItems(): ArrayList<ImageItem> {
        return items
    }

    fun getItem(position: Int): ImageItem {
        return items[position]
    }

    fun removeItem(i: Int) {
        items.removeAt(i)
        notifyItemRemoved(i)
    }

    inner class ViewHolder internal constructor(private val mItemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(mItemImageBinding.root) {

        fun bind(mImageItem: ImageItem) {

            val mImageViewModel = ImageViewModel()
            mImageViewModel.setImageItem(mImageItem)

            mItemImageBinding.viewModel = mImageViewModel
            mItemImageBinding.executePendingBindings()
        }
    }
}
