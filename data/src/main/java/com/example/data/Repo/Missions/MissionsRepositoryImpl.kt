package com.example.data.Repo.Missions


import com.example.domain.entity.Missions
import com.example.domain.repo.MissionsRepository
import kotlinx.coroutines.flow.Flow



class MissionsRepositoryImpl(
    private val remoteSource: RemoteMissionsDataSource
): MissionsRepository {

    override fun getMissions(): Flow<List<Missions>> {
        return remoteSource.getMissions()
    }

    override fun getMission(id: String?): Flow<Missions> {
        return remoteSource.getMission(id)
    }

}