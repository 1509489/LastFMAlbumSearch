package com.pixelart.lastfmalbumsearch.di.activity

import com.pixelart.lastfmalbumsearch.factories.HomeViewModelFactory
import com.pixelart.lastfmalbumsearch.ui.home.HomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun getHomeViewModelFactory():HomeViewModelFactory
    fun injectHomeActivity(homeActivity: HomeActivity)
}