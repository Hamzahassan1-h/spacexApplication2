package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class LandingLegsModel(
    @SerializedName("material")
    val material: String? = "",
    @SerializedName("number")
    val number: Int? = 0
)