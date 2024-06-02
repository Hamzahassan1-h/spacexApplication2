package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class ThrustModel(
    @SerializedName("kN")
    val kN: Int? = 0,
    @SerializedName("lbf")
    val lbf: Int? = 0
)