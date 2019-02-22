package com.pixelart.lastfmalbumsearch.ui.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pixelart.lastfmalbumsearch.data.model.AlbumMatches
import com.pixelart.lastfmalbumsearch.data.repository.RepositoryImpl

class HomeViewModel(private val repositoryImpl: RepositoryImpl): ViewModel() {

    //Get the albums from the repository as live data
    fun getAlbums(album: String):LiveData<AlbumMatches> = repositoryImpl.getAlbums(album)
}