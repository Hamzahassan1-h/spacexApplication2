package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class CompositeFairingModel(
    @SerializedName("diameter")
    val diameter: DiameterModel? = DiameterModel(),
    @SerializedName("height")
    val height: HeightModelX? = HeightModelX()
)