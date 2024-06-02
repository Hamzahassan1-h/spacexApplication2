package com.example.data.Remote.Network.Missions


import com.google.gson.annotations.SerializedName

data class MissionsItemModel(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("manufacturers")
    val manufacturers: List<String?>? = listOf(),
    @SerializedName("mission_id")
    val missionId: String? = "",
    @SerializedName("mission_name")
    val missionName: String? = "",
    @SerializedName("payload_ids")
    val payloadIds: List<String?>? = listOf(),
    @SerializedName("twitter")
    val twitter: String? = "",
    @SerializedName("website")
    val website: String? = "",
    @SerializedName("wikipedia")
    val wikipedia: String? = ""
)