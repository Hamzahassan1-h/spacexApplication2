package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class IspModel(
    @SerializedName("sea_level")
    val seaLevel: Int? = 0,
    @SerializedName("vacuum")
    val vacuum: Int? = 0
)