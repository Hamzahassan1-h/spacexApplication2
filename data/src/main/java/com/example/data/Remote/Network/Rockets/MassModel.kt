package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class MassModel(
    @SerializedName("kg")
    val kg: Int? = 0,
    @SerializedName("lb")
    val lb: Int? = 0
)