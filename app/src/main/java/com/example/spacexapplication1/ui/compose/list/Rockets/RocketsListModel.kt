package com.example.spacexapplication1.ui.compose.list.Rockets

data class RocketsListModel(
    val items: List<Rockets>
)

data class Rockets(
    val company: String? = "",
    val costPerLaunch: Int? = 0,
    val country: String? = "",
    val description: String? = "",
    val id: Int? = 0,
    val rocketId: String? = "",
    val rocketName: String? = "",
    val rocketType: String? = "",
)
