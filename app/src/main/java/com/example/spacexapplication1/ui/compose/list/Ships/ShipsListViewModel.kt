package com.example.spacexapplication1.ui.compose.list.Ships

import androidx.lifecycle.viewModelScope
import com.example.common.Routes.ShipsNavRoutes
import com.example.common.nav.ShipsInput
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.Ships.GetShipsUseCase
import com.example.spacexapplication1.converter.ShipsListConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsListViewModel @Inject constructor(
    private val useCase: GetShipsUseCase,
    private val converter: ShipsListConverter
) : MviViewModel<ShipListModel, UiState<ShipListModel>, ShipsListUiAction, ShipsListUiSingleUiEvent>(){

    override fun initState(): UiState<ShipListModel> = UiState.Loading


    override fun handleAction(action: ShipsListUiAction) {
        when (action) {
            is ShipsListUiAction.Load -> {
                loadShips()
            }
            is ShipsListUiAction.OnShipItemClick -> {
                submitSingleEvent(
                    ShipsListUiSingleUiEvent.OpenDetailsScreen(
                        ShipsNavRoutes.Details.routeForShip(
                            ShipsInput(
                                action.model,
                                action.shipName,
                                action.status,
                                action.shipType,
                                action.image,
                                action.weight,
                                action.yearBuilt
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadShips(){
        viewModelScope.launch {
            useCase.execute(GetShipsUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }
}