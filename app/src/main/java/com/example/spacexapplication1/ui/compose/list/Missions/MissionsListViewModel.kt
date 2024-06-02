package com.example.spacexapplication1.ui.compose.list.Missions

import androidx.lifecycle.viewModelScope
import com.example.common.Routes.MissionsNavRoutes
import com.example.common.nav.MissionsInput
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.Missions.GetMissionsUseCase
import com.example.spacexapplication1.converter.MissionListConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MissionsListViewModel @Inject constructor(
    private val useCase: GetMissionsUseCase,
    private val converter: MissionListConverter
) : MviViewModel<MissionsListModel, UiState<MissionsListModel>, MissionsListUiAction, MissionsListUiSingleEvent>() {
    override fun initState(): UiState<MissionsListModel> = UiState.Loading

    override fun handleAction(action: MissionsListUiAction) {
        when (action) {
            is MissionsListUiAction.Load -> {
                loadMissions()
            }
            is MissionsListUiAction.OnMissionItemClick -> {
                submitSingleEvent(
                    MissionsListUiSingleEvent.OpenDetailsScreen(
                        MissionsNavRoutes.Details.routeForMission(
                            MissionsInput(
                                action.description
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadMissions() {
        viewModelScope.launch {
            useCase.execute(GetMissionsUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }


}