package com.example.data.Remote.Network.History


import com.google.gson.annotations.SerializedName

data class LinksModel(
    @SerializedName("article")
    val article: String? = "",
    @SerializedName("reddit")
    val reddit: String? = "",
    @SerializedName("wikipedia")
    val wikipedia: String? = ""
)