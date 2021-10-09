package com.felipersn.clean.architecture

import android.app.Application
import com.felipersn.clean.core.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

val applicationModules = listOf(remoteModule)

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDependencyInjection()
    }

    private fun setupDependencyInjection() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(applicationModules)
        }
    }
}