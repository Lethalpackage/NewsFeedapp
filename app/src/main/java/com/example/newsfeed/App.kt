package com.example.newsfeed

import android.app.Application
import com.example.newsfeed.di.appModule
import com.example.newsfeed.features.main_screen.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule,mainScreenModule)
        }
    }
}