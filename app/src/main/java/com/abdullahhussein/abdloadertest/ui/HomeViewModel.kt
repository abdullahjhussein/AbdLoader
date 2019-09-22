package com.abdullahhussein.abdloadertest.ui

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.abdullahhussein.abdloader.AbdLoader
import com.abdullahhussein.abdloadertest.model.ImageItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val mImagesAdapter: ImagesAdapter = ImagesAdapter()

    private val uiHandler: Handler = Handler(Looper.getMainLooper())


    fun getImagesData() {
        GlobalScope.launch {
            getData()
        }
    }

    private suspend fun getData() {
        val result = AbdLoader.load(" https://pastebin.com/raw/wgkJgazE")

        val type = object : TypeToken<ArrayList<ImageItem>>() {}.type

        val data: ArrayList<ImageItem> = Gson().fromJson(result, type)

        uiHandler.post {
            mImagesAdapter.setData(data)
        }
    }
}