package com.abdullahhussein.abdloadertest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdullahhussein.abdloadertest.model.ImageItem

class ImageViewModel : ViewModel() {

    var url = MutableLiveData<String>()

    fun setImageItem(mImageItem: ImageItem) {
        url.value = mImageItem.urls.thumb
    }
}