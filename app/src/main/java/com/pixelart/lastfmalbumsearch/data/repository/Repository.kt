package com.pixelart.lastfmalbumsearch.data.repository

import androidx.lifecycle.LiveData
import com.pixelart.lastfmalbumsearch.data.model.AlbumMatches

interface Repository {
    fun getAlbums(album: String): LiveData<AlbumMatches>
}