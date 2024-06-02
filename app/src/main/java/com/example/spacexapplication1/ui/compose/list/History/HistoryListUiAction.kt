package com.example.spacexapplication1.ui.compose.list.History

import com.example.common.state.UiAction

sealed class HistoryListUiAction: UiAction {

    data object Load: HistoryListUiAction()

    data class OnHistoryItemClick(
        val title: String?,
        val details: String?,
        val flightNumber: Int?,
        val date: String?
    ) : HistoryListUiAction()
}