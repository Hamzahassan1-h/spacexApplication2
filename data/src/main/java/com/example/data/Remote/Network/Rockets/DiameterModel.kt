package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class DiameterModel(
    @SerializedName("feet")
    val feet: Double? = 0.0,
    @SerializedName("meters")
    val meters: Double? = 0.0
)