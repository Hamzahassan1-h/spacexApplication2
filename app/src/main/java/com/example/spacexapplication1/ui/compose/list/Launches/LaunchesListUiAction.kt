package com.example.spacexapplication1.ui.compose.list.Launches

import com.example.common.state.UiAction

sealed class LaunchesListUiAction: UiAction {

    data object Load: LaunchesListUiAction()

    data class OnLaunchItemClick(
        val details: String?,
        val success: Boolean?,
        val missionName: String?,
        val launchYear: String?
    ) : LaunchesListUiAction()

}