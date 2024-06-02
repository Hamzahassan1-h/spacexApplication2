package com.example.data.source.History

import com.example.data.Remote.Network.History.HistoryItemModel
import com.example.data.Repo.History.RemoteHistoryDataSource
import com.example.data.service.SpacexService
import com.example.domain.entity.History
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class RemoteHistoryDataSourceImpl @Inject constructor(
    private val service: SpacexService
): RemoteHistoryDataSource {
    override fun getHistory(): Flow<List<History?>?> = flow {
        val history = service.getHistory()
        emit(history)
    }.map { historyList ->
        historyList.map { history -> convert(history) }
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    override fun getHistoryItem(id: Int?): Flow<History> = flow {
        emit(service.getHistoryItem(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    private fun convert(model: HistoryItemModel): History {
        return History(
            details = model.details,
            eventDateUnix = model.eventDateUnix,
            flightNumber = model.flightNumber,
            id = model.id,
            title = model.title
        )
    }


}
