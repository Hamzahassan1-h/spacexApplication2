package com.example.spacexapplication1.converter

import android.content.Context
import com.example.common.state.CommonResultConverter

import com.example.domain.usecase.History.GetHistoryUseCase
import com.example.spacexapplication1.ui.compose.list.History.History
import com.example.spacexapplication1.ui.compose.list.History.HistoryListModel

import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HistoryListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetHistoryUseCase.Response, HistoryListModel>() {

    override fun convertSuccess(
        data: GetHistoryUseCase.Response
    ): HistoryListModel {
        return HistoryListModel(
            items = data.history?.map {
                History(
                    details = it?.details,
                    eventDateUtc = it?.eventDateUtc,
                    flightNumber = it?.flightNumber,
                    id = it?.id,
                    title = it?.title,
                )
            } ?: listOf()

        )

    }


}