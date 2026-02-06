package com.zyphir.eccomerce.angieshop

import android.app.Application
import com.zyphir.eccomerce.angieshop.shared.modules.appModule
import com.zyphir.eccomerce.angieshop.shared.modules.supabaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, supabaseModule)
        }
    }
}