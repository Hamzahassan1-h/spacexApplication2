package com.example.spacexapplication1.ui.compose.list.Missions

import com.example.common.state.UiAction

sealed class MissionsListUiAction: UiAction {

    data object Load: MissionsListUiAction()

    data class OnMissionItemClick(
        val description: String?
    ): MissionsListUiAction()
}