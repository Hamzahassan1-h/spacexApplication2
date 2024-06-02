package com.example.data.Repo.Launches

import com.example.domain.entity.Launches
import com.example.domain.repo.LaunchesRepository
import kotlinx.coroutines.flow.Flow


class LaunchesRepositoryImpl(
    private val remoteSource: RemoteLaunchesDataSource
) : LaunchesRepository{

    override fun getLaunches(): Flow<List<Launches>> {
        return remoteSource.getLaunches()
    }

    override fun getLaunchItem(number: Int?): Flow<Launches> {
        return remoteSource.getLaunch(number)
    }


}