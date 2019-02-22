package com.pixelart.lastfmalbumsearch.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pixelart.lastfmalbumsearch.common.API_KEY
import com.pixelart.lastfmalbumsearch.data.model.AlbumMatches
import com.pixelart.lastfmalbumsearch.data.model.AlbumResponse
import com.pixelart.lastfmalbumsearch.data.net.NetworkService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val networkService: NetworkService): Repository {
    private val response = MutableLiveData<AlbumMatches>()

    //Get data from the network and return it as a live data object
    override fun getAlbums(album: String):LiveData<AlbumMatches> {
        networkService.getAlbums(album, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (object : SingleObserver<AlbumResponse>{
                override fun onSuccess(t: AlbumResponse) {
                    response.value = t.results.albumMatches
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })

        return response
    }
}