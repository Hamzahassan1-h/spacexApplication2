package com.example.spacexapplication1.ui.compose.list.Launches

import androidx.lifecycle.viewModelScope
import com.example.common.Routes.LaunchesNavRoutes
import com.example.common.nav.LaunchesInput
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.Launches.GetLaunchesUseCase
import com.example.spacexapplication1.converter.LaunchesListConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchesListViewModel @Inject constructor(
    private val useCase: GetLaunchesUseCase,
    private val converter: LaunchesListConverter
) : MviViewModel<LaunchesListModel, UiState<LaunchesListModel>, LaunchesListUiAction, LaunchesListUiSingleEvent>() {

    override fun initState(): UiState<LaunchesListModel> = UiState.Loading


    override fun handleAction(action: LaunchesListUiAction) {
        when (action) {
            is LaunchesListUiAction.Load -> {
                loadLaunches()
            }
            is LaunchesListUiAction.OnLaunchItemClick -> {
                submitSingleEvent(
                    LaunchesListUiSingleEvent.OpenDetailsScreen(
                        LaunchesNavRoutes.Details.routeForLaunch(
                            LaunchesInput(
                                action.details,
                                action.success,
                                action.missionName,
                                action.launchYear
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadLaunches() {
        viewModelScope.launch {
            useCase.execute(GetLaunchesUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }

        }
    }


}