package com.pixelart.lastfmalbumsearch.di.application

import com.pixelart.lastfmalbumsearch.di.activity.ActivityComponent
import com.pixelart.lastfmalbumsearch.di.activity.ActivityModule
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun newActivityComponent(activityModule: ActivityModule):ActivityComponent
}