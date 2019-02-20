package com.pixelart.lastfmalbumsearch.data.model

import com.google.gson.annotations.SerializedName

data class OpenSearchQuery(
    @SerializedName("#text")
    val text: String,
    val role: String,
    val searchTerms: String,
    val startPage: String
)