package com.example.spacexapplication1.ui.compose.list.capsule

import androidx.lifecycle.viewModelScope
import com.example.common.Routes.CapsuleNavRoutes
import com.example.common.nav.CapsuleInput
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.Capsule.GetCapsulesUseCase
import com.example.spacexapplication1.converter.CapsuleListConverter

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsuleListViewModel @Inject constructor(
    private val useCase: GetCapsulesUseCase,
    private val converter: CapsuleListConverter
): MviViewModel<CapsuleListModel, UiState<CapsuleListModel>, CapsuleListAction, CapsuleListUiSingleEvent>() {
    override fun initState(): UiState<CapsuleListModel> = UiState.Loading


    override fun handleAction(action: CapsuleListAction) {
        when (action) {
            is CapsuleListAction.Load -> {
                loadCapsules()
            }

            is CapsuleListAction.OnCapsuleItemClick -> {
                submitSingleEvent(
                    CapsuleListUiSingleEvent.OpenDetailsScreen(
                        CapsuleNavRoutes.Details.routeForCapsule(
                            CapsuleInput(
                                action.serial,
                                action.details,
                                action.status,
                                action.landings,
                                action.type,
                                action.launch
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadCapsules() {
        viewModelScope.launch {
            useCase.execute(GetCapsulesUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }
}