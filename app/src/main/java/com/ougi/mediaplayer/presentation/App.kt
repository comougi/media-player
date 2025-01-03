package com.ougi.mediaplayer.presentation

import android.app.Application
import com.ougi.mediaplayer.di.app.DaggerAppComponent

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }

}