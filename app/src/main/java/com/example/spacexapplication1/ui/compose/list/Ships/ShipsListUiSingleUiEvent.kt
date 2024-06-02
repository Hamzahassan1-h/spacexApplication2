package com.example.spacexapplication1.ui.compose.list.Ships

import com.example.common.state.UiSingleEvent

sealed class ShipsListUiSingleUiEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): ShipsListUiSingleUiEvent()
}