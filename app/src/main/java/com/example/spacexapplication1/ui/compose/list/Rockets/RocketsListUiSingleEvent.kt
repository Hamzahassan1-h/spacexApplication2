package com.example.spacexapplication1.ui.compose.list.Rockets

import com.example.common.state.UiSingleEvent

sealed class RocketsListUiSingleEvent: UiSingleEvent {


    data class OpenDetailsScreen(val navRoute: String): RocketsListUiSingleEvent()
}