package com.example.newsApp

import android.app.Application
import com.example.newsApp.di.appModule
import com.example.newsApp.di.databaseModule
import com.example.newsApp.feature.bookmarks.di.bookmarkModule
import com.example.newsApp.feature.main.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            androidLogger()
            // declare used Android context
            androidContext(this@App)
            // declare modules
            modules(appModule, databaseModule, mainScreenModule, bookmarkModule)
        }

        // log
        Timber.plant(Timber.DebugTree())
    }
}