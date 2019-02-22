package com.pixelart.lastfmalbumsearch.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pixelart.lastfmalbumsearch.data.model.AlbumMatches
import com.pixelart.lastfmalbumsearch.data.net.NetworkService

class RepositoryImpl(private val networkService: NetworkService): Repository {
    private val response = MutableLiveData<AlbumMatches>()

    override fun getAlbums(album: String):LiveData<AlbumMatches> {
        return response
    }
}