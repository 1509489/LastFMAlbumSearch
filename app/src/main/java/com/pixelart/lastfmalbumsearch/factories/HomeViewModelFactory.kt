package com.pixelart.lastfmalbumsearch.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pixelart.lastfmalbumsearch.data.repository.RepositoryImpl
import com.pixelart.lastfmalbumsearch.ui.home.HomeViewModel

class HomeViewModelFactory(private val repositoryImpl: RepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(HomeViewModel::class.java)) HomeViewModel(repositoryImpl) as T
        else throw IllegalArgumentException("ViewModel not found")
    }
}