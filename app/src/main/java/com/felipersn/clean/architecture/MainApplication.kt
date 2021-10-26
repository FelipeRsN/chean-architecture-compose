package com.felipersn.clean.architecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//val applicationModules = listOf(remoteModule)

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDependencyInjection()
    }

    private fun setupDependencyInjection() {
//        startKoin {
//            androidLogger(Level.ERROR)
//            androidContext(this@MainApplication)
//            modules(applicationModules)
//        }


    }
}