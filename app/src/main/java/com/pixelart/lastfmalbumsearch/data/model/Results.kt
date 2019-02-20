package com.pixelart.lastfmalbumsearch.data.model

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("opensearch:Query")
    val openSearchQuery: OpenSearchQuery,

    @SerializedName("opensearch:totalResults")
    val openSearchTotalResults: String,

    @SerializedName("opensearch:startIndex")
    val openSearchStartIndex: String,

    @SerializedName("opensearch:itemsPerPage")
    val openSearchItemsPerPage: String,

    @SerializedName("albummatches")
    val albumMatches: AlbumMatches,

    @SerializedName("@attr")
    val attr: Attr
)