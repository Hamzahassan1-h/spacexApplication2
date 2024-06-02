package com.example.data.Remote.Network.Ships


import com.google.gson.annotations.SerializedName

data class shipsItemModel(
    @SerializedName("abs")
    val abs: Int? = 0,
    @SerializedName("active")
    val active: Boolean? = false,
    @SerializedName("attempted_catches")
    val attemptedCatches: Int? = 0,
    @SerializedName("attempted_landings")
    val attemptedLandings: Int? = 0,
    @SerializedName("class")
    val classX: Int? = 0,
    @SerializedName("home_port")
    val homePort: String? = "",
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("imo")
    val imo: Int? = 0,
    @SerializedName("missions")
    val missions: List<MissionModel?>? = listOf(),
    @SerializedName("mmsi")
    val mmsi: Int? = 0,
    @SerializedName("position")
    val position: PositionModel? = PositionModel(),
    @SerializedName("roles")
    val roles: List<String?>? = listOf(),
    @SerializedName("ship_id")
    val shipId: String? = "",
    @SerializedName("ship_model")
    val shipModel: String? = "",
    @SerializedName("ship_name")
    val shipName: String? = "",
    @SerializedName("ship_type")
    val shipType: String? = "",
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("successful_catches")
    val successfulCatches: Int? = 0,
    @SerializedName("successful_landings")
    val successfulLandings: Int? = 0,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("weight_kg")
    val weightKg: Int? = 0,
    @SerializedName("weight_lbs")
    val weightLbs: Int? = 0,
    @SerializedName("year_built")
    val yearBuilt: Int? = 0
)