package com.pixelart.lastfmalbumsearch.di.application

import android.app.Application
import com.pixelart.lastfmalbumsearch.di.network.NetworkModule
import dagger.Module

@Module(includes = [NetworkModule::class])
class ApplicationModule(private val application: Application) {

}