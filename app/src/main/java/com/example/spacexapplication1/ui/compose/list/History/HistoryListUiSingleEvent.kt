package com.example.spacexapplication1.ui.compose.list.History

import com.example.common.state.UiSingleEvent

open class HistoryListUiSingleEvent : UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String) : HistoryListUiSingleEvent()
}