package com.pixelart.lastfmalbumsearch.di.application

import android.app.Application
import android.content.Context
import com.pixelart.lastfmalbumsearch.data.net.NetworkService
import com.pixelart.lastfmalbumsearch.data.repository.RepositoryImpl
import com.pixelart.lastfmalbumsearch.di.network.NetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationScope
    fun providesContext(): Context = application

    @Provides
    @ApplicationScope
    fun providesRepository(networkService: NetworkService): RepositoryImpl = RepositoryImpl(networkService)

}