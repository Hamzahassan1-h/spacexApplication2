package com.example.spacexapplication1.ui.compose.list.Rockets

import com.example.common.state.UiAction

sealed class RocketsListUiAction : UiAction {

    data object Load : RocketsListUiAction()

    data class OnRocketItemClick(
        val company: String?,
        val description: String?,
        val costPerLaunch: Int?,
        val rocketType: String?,
        val country: String?
    ) : RocketsListUiAction()
}