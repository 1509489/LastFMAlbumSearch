package com.pixelart.lastfmalbumsearch.di.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.pixelart.lastfmalbumsearch.factories.HomeViewModelFactory
import com.pixelart.lastfmalbumsearch.ui.homescreen.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideHomeViewModel(homeViewModelFactory: HomeViewModelFactory) =
        ViewModelProviders.of(activity, homeViewModelFactory).get(HomeViewModel::class.java)
}