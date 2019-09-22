package com.abdullahhussein.abdloader.cache

import android.graphics.Bitmap
import android.util.LruCache

open class AbdLoaderMemoryCache : AbdLoaderCache {

    private var maxCache: Int = 0

    private lateinit var imageCache: LruCache<String, Bitmap>
    private lateinit var dataCache: LruCache<String, String>

    constructor() {
        maxCache = 0
        init()
    }

    constructor(maxCache: Int) {
        this.maxCache = maxCache
        init()
    }

    private fun init() {
        if (maxCache == 0) {
            val maxMemory: Long = Runtime.getRuntime().maxMemory() / 1024
            maxCache = (maxMemory / 8).toInt()
        }

        imageCache = object : LruCache<String, Bitmap>(maxCache) {
            override fun sizeOf(key: String?, bitmap: Bitmap?): Int {
                return (bitmap?.byteCount ?: 0) / 1024
            }
        }

        dataCache = object : LruCache<String, String>(maxCache) {}
    }

    override fun cacheBitmap(url: String, bitmap: Bitmap) {
        imageCache.put(url, bitmap)
    }

    override fun cacheData(url: String, data: String) {
        dataCache.put(url, data)
    }

    override fun getBitmap(url: String): Bitmap? {
        return imageCache.get(url)
    }

    override fun getData(url: String): String? {
        return dataCache.get(url)
    }

    override fun clearCache() {
        imageCache.evictAll()
        dataCache.evictAll()
    }
}