package com.example.spacexapplication1.ui.compose.list.Missions

data class MissionsListModel (
    val items: List<Mission>
)


data class Mission(
    val description: String? = "",
    val missionId: String? = "",
    val missionName: String? = "",
)