package com.example.data.Repo.History


import com.example.domain.entity.History
import com.example.domain.repo.HistoryRepository
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl(
    private val remoteSource: RemoteHistoryDataSource
): HistoryRepository {

    override fun getHistory(): Flow<List<History?>?> {
        return remoteSource.getHistory()
    }

    override fun getHistoryItem(id: Int?): Flow<History> {
        return remoteSource.getHistoryItem(id)
    }
}