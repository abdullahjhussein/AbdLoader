package com.abdullahhussein.abdloader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import androidx.annotation.Nullable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object AbdLoader {

    private var executorService: ExecutorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    private val uiHandler: Handler = Handler(Looper.getMainLooper())

    private var mAbdLoaderConfig = AbdLoaderConfig.getDefaultConfig()

    fun initialize(context: Context) {
        initialize(context, null)
    }

    fun initialize(context: Context, @Nullable abdLoaderConfig: AbdLoaderConfig?) {
        if (abdLoaderConfig != null) {
            mAbdLoaderConfig = abdLoaderConfig
        }
    }

    suspend fun load(url: String): String {
        val request = GlobalScope.async { URL(url).readText() }
        return request.await()
    }

    fun loadImage(url: String, imageView: ImageView) {
        val cached = mAbdLoaderConfig.memoryCache.getBitmap(url)
        if (cached != null) {
            updateImageView(imageView, cached)
            return
        }

        imageView.tag = url

        executorService.submit {
            val bitmap: Bitmap? = downloadImage(url)
            if (bitmap != null) {
                if (imageView.tag == url) {
                    updateImageView(imageView, bitmap)
                }
                mAbdLoaderConfig.memoryCache.cacheBitmap(url, bitmap)
            }
        }
    }

    private fun updateImageView(imageView: ImageView, bitmap: Bitmap) {
        uiHandler.post {
            imageView.setImageBitmap(bitmap)
        }
    }

    private fun downloadImage(url: String): Bitmap? {
        Log.e("Error", "URL : $url")
        var bitmap: Bitmap? = null
        try {
            val mHttpURLConnection = URL(url).openConnection() as HttpURLConnection
            mHttpURLConnection.useCaches = true
            bitmap = BitmapFactory.decodeStream(mHttpURLConnection.inputStream)
            mHttpURLConnection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return bitmap
    }
}