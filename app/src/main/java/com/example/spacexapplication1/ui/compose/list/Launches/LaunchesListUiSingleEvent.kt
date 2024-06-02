package com.example.spacexapplication1.ui.compose.list.Launches

import com.example.common.state.UiSingleEvent

sealed class LaunchesListUiSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): LaunchesListUiSingleEvent()
}