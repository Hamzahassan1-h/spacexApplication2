package com.example.domain.entity

data class Missions(
    val description: String? = "",
    val manufacturers: List<String?>? = listOf(),
    val missionId: String? = "",
    val missionName: String? = "",
    val payloadIds: List<String?>? = listOf(),
    val twitter: String? = "",
    val website: String? = "",
    val wikipedia: String? = ""
)
