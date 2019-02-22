package com.pixelart.lastfmalbumsearch.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pixelart.lastfmalbumsearch.data.model.AlbumMatches
import com.pixelart.lastfmalbumsearch.data.repository.RepositoryImpl

class HomeViewModel(private val repositoryImpl: RepositoryImpl): ViewModel() {

    fun getAlbums(album: String):LiveData<AlbumMatches> = repositoryImpl.getAlbums(album)
}