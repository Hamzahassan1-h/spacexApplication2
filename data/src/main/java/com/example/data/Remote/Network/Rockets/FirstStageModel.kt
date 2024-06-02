package com.example.data.Remote.Network.Rockets


import com.google.gson.annotations.SerializedName

data class FirstStageModel(
    @SerializedName("burn_time_sec")
    val burnTimeSec: Int? = 0,
    @SerializedName("cores")
    val cores: Int? = 0,
    @SerializedName("engines")
    val engines: Int? = 0,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double? = 0.0,
    @SerializedName("reusable")
    val reusable: Boolean? = false,
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevelModelX? = ThrustSeaLevelModelX(),
    @SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuumModelX? = ThrustVacuumModelX()
)