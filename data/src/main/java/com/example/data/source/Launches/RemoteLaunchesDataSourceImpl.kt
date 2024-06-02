package com.example.data.source.Launches

import com.example.data.Remote.Network.launches.LaunchesItemModel
import com.example.data.Repo.Launches.RemoteLaunchesDataSource
import com.example.data.service.SpacexService
import com.example.domain.entity.Launches
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

//class RemoteLaunchesDataSourceImpl {
//}

class RemoteLaunchesDataSourceImpl @Inject constructor(
    private val service: SpacexService
): RemoteLaunchesDataSource {

    override fun getLaunches(): Flow<List<Launches>> = flow {
        val launches = service.getLaunches()
        emit(launches)
    }.map { launchList ->
        launchList.map { launches -> convert(launches) }
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    override fun getLaunch(number: Int?): Flow<Launches> = flow {
        emit(service.getLaunch(number))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.SpacexException(it)
    }


    private fun convert(model: LaunchesItemModel): Launches {
        return Launches(
            details = model.details,
            flightNumber = model.flightNumber,
            launchSuccess = model.launchSuccess,
            lastWikiUpdate = model.lastWikiUpdate,
            lastDateUpdate = model.lastDateUpdate,
            launchYear = model.launchYear,
            missionId = model.missionId,
            missionName = model.missionName,

        )
    }
}