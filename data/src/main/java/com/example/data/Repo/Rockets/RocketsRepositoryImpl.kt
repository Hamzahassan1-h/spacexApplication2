package com.example.data.Repo.Rockets


import com.example.domain.entity.Rockets
import com.example.domain.repo.RocketsRepository
import kotlinx.coroutines.flow.Flow

class RocketsRepositoryImpl(
    private val remoteSource: RemoteRocketDataSource
) : RocketsRepository {
    override fun getRockets(): Flow<List<Rockets>> {
        return remoteSource.getRockets()
    }

    override fun getRocket(id: Int?): Flow<Rockets> {
        return remoteSource.getRocket(id)
    }
}