package com.abdullahhussein.abdloader.cache

import android.os.Build
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class AbdLoaderMemoryCacheTest {

    @Test
    fun testMemoryCacheWithFixedCacheSize() {
        val cacheSize = 1024
        val cache = Mockito.spy(AbdLoaderMemoryCache(cacheSize))

        val url = "https://www.google.ps/"
        val data = "json data"
        Mockito.doReturn(null).`when`(cache).getData(url)
        cache.cacheData(url, data)
        Mockito.doReturn(data).`when`(cache).getData(url)
    }

    @Test
    fun testMemoryCacheWithoutFixedCacheSize() {
        val cache = Mockito.spy(AbdLoaderMemoryCache())

        val url = "https://www.google.ps/"
        val data = "json data"
        Mockito.doReturn(null).`when`(cache).getData(url)
        cache.cacheData(url, data)
        Mockito.doReturn(data).`when`(cache).getData(url)
    }
}