package com.example.spacexapplication1.ui.compose.list.capsule

import com.example.common.state.UiSingleEvent

open class CapsuleListUiSingleEvent : UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String) : CapsuleListUiSingleEvent()
}