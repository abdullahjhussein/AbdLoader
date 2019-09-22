package com.abdullahhussein.abdloader

import com.abdullahhussein.abdloader.cache.AbdLoaderCache
import com.abdullahhussein.abdloader.cache.AbdLoaderMemoryCache

class AbdLoaderConfig {

    companion object {
        fun getDefaultConfig(): AbdLoaderConfig {

            val mAbdLoaderConfig = AbdLoaderConfig()

            mAbdLoaderConfig.memoryCache = AbdLoaderMemoryCache()

            return mAbdLoaderConfig
        }
    }

    var memoryCache: AbdLoaderCache = AbdLoaderMemoryCache()
}