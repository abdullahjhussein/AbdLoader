# AbdLoader
Network Loading Library [Image , JSON]


# Setup AbdLoader Library

Import package folder [abdloader] to you project.
Add this line to your gradle file in app module: implementation project(path: ':abdloader')

1. In Application File:

Initialize the AbdLoader with max cache size.
        
        AbdLoader.initialize(this)
""OR"" 

Initialize the AbdLoader with specific cache size.     
        
        val maxCache = 4 * 1024
        val mAbdLoaderConfig = AbdLoaderConfig()
        mAbdLoaderConfig.memoryCache = AbdLoaderMemoryCache(maxCache)
        AbdLoader.initialize(this, mAbdLoaderConfig)
       
2. Load File : 

          GlobalScope.launch {
              getData()
          }
        
         private suspend fun getData() {
            val result = AbdLoader.load(" https://pastebin.com/raw/wgkJgazE")

            val type = object : TypeToken<ArrayList<ImageItem>>() {}.type

            val data: ArrayList<ImageItem> = Gson().fromJson(result, type)

            uiHandler.post {
                mImagesAdapter.setData(data)
            }
        }


3.Load Image:
        
        AbdLoader.loadImage(url, imageView)
