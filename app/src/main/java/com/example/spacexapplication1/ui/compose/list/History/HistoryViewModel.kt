package com.example.spacexapplication1.ui.compose.list.History

import androidx.lifecycle.viewModelScope
import com.example.common.Routes.HistoryNavRoutes
import com.example.common.nav.HistoryInput
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.History.GetHistoryUseCase
import com.example.spacexapplication1.converter.HistoryListConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val useCase: GetHistoryUseCase,
    private val converter: HistoryListConverter
): MviViewModel<HistoryListModel, UiState<HistoryListModel>, HistoryListUiAction, HistoryListUiSingleEvent>() {
    override fun initState(): UiState<HistoryListModel> = UiState.Loading

    override fun handleAction(action: HistoryListUiAction) {
        when (action) {
            is HistoryListUiAction.Load -> {
                loadHistory()
            }
            is HistoryListUiAction.OnHistoryItemClick -> {
                submitSingleEvent(
                    HistoryListUiSingleEvent.OpenDetailsScreen(
                        HistoryNavRoutes.Details.routeForHistory(
                            HistoryInput(
                                action.title,
                                action.details,
                                action.flightNumber,
                                action.date
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadHistory() {
        viewModelScope.launch {
            useCase.execute(GetHistoryUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }


}