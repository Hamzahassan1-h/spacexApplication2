package com.example.spacexapplication1.ui.compose.list.Ships

import com.example.common.state.UiAction

sealed class ShipsListUiAction: UiAction {

    data object Load: ShipsListUiAction()

    data class OnShipItemClick(
        val model: String?,
        val shipName: String?,
        val status: String?,
        val shipType: String?,
        val image: String?,
        val weight: Int?,
        val yearBuilt: Int?
    ) : ShipsListUiAction()
}