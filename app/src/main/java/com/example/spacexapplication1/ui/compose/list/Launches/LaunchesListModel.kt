package com.example.spacexapplication1.ui.compose.list.Launches

data class LaunchesListModel(
    val items: List<Launches> = listOf()
)

data class Launches(
    val details: String? = "",
    val flightNumber: Int? = 0,
    val launchSuccess: Boolean? = false,
    val launchYear: String? = "",
    val missionName: String? = "",
)
