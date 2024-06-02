package com.example.spacexapplication1.ui.compose.list.Rockets

import androidx.lifecycle.viewModelScope
import com.example.common.Routes.RocketsNavRoutes
import com.example.common.nav.RocketsInputs
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.Rockets.GetRocketsUseCase
import com.example.spacexapplication1.converter.RocketsListConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketsListViewModel @Inject constructor(
    private val useCase: GetRocketsUseCase,
    private val converter: RocketsListConverter
) : MviViewModel<RocketsListModel, UiState<RocketsListModel>, RocketsListUiAction, RocketsListUiSingleEvent>(){


    override fun initState(): UiState<RocketsListModel> = UiState.Loading


    override fun handleAction(action: RocketsListUiAction) {
        when (action) {
            is RocketsListUiAction.Load -> {
                loadRockets()
            }
            is RocketsListUiAction.OnRocketItemClick -> {
                submitSingleEvent(
                    RocketsListUiSingleEvent.OpenDetailsScreen(
                        RocketsNavRoutes.Details.routeForRocket(
                            RocketsInputs(
                                action.company,
                                action.description,
                                action.costPerLaunch,
                                action.rocketType,
                                action.country,
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadRockets() {
        viewModelScope.launch {
            useCase.execute(GetRocketsUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }


}