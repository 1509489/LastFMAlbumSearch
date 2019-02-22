package com.pixelart.lastfmalbumsearch.app

import android.app.Application
import com.pixelart.lastfmalbumsearch.di.application.ApplicationComponent
import com.pixelart.lastfmalbumsearch.di.application.ApplicationModule
import com.pixelart.lastfmalbumsearch.di.application.DaggerApplicationComponent

class AlbumApp: Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}