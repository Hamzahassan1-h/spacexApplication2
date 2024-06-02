package com.example.spacexapplication1.ui.compose.list.Missions

import com.example.common.state.UiSingleEvent

sealed class MissionsListUiSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): MissionsListUiSingleEvent()
}