package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class EnginesModel(
    @SerializedName("engine_loss_max")
    val engineLossMax: Int? = 0,
    @SerializedName("isp")
    val isp: IspModel? = IspModel(),
    @SerializedName("layout")
    val layout: String? = "",
    @SerializedName("number")
    val number: Int? = 0,
    @SerializedName("propellant_1")
    val propellant1: String? = "",
    @SerializedName("propellant_2")
    val propellant2: String? = "",
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevelModel? = ThrustSeaLevelModel(),
    @SerializedName("thrust_to_weight")
    val thrustToWeight: Double? = 0.0,
    @SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuumModel? = ThrustVacuumModel(),
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("version")
    val version: String? = ""
)