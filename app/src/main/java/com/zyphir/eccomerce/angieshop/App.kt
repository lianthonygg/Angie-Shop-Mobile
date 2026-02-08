package com.zyphir.eccomerce.angieshop

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.memory.MemoryCache
import coil3.request.crossfade
import com.zyphir.eccomerce.angieshop.shared.modules.appModule
import com.zyphir.eccomerce.angieshop.shared.modules.productMapperModule
import com.zyphir.eccomerce.angieshop.shared.modules.storeRepositoryModule
import com.zyphir.eccomerce.angieshop.shared.modules.storeUseCaseModule
import com.zyphir.eccomerce.angieshop.shared.modules.supabaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(), SingletonImageLoader.Factory {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                supabaseModule,
                storeRepositoryModule,
                storeUseCaseModule,
                productMapperModule
            )
        }
    }

    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve("coil_images"))
                    .maxSizePercent(0.02)
                    .build()
            }
            .crossfade(true)
            .build()
    }
}