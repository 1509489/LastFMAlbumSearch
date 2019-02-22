package com.pixelart.lastfmalbumsearch.data.net

import com.pixelart.lastfmalbumsearch.data.model.AlbumResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("2.0/?method=album.search&format=json")
    fun getAlbums(
        @Query("album") album: String,
        @Query("api_key") apiKey: String
    ):Single<AlbumResponse>
}