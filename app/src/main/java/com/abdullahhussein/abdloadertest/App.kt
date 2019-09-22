package com.abdullahhussein.abdloadertest

import android.app.Application
import com.abdullahhussein.abdloader.AbdLoader

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //If you want to configure cache size
        //
        //val maxCache = 4 * 1024
        //val mAbdLoaderConfig = AbdLoaderConfig()
        //mAbdLoaderConfig.memoryCache = AbdLoaderMemoryCache(maxCache)
        //AbdLoader.initialize(this, mAbdLoaderConfig)

        AbdLoader.initialize(this)
    }
}