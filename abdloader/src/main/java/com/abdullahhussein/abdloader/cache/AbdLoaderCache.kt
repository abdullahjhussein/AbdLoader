package com.abdullahhussein.abdloader.cache

import android.graphics.Bitmap

interface AbdLoaderCache {

    fun cacheBitmap(url: String, bitmap: Bitmap)
    fun cacheData(url: String, data: String)
    fun getBitmap(url: String): Bitmap?
    fun getData(url: String): String?
    fun clearCache()

}