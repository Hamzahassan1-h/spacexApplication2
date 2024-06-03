package com.example.data.source.Missions


import com.example.data.Remote.Network.Missions.MissionsItemModel
import com.example.data.Repo.Missions.RemoteMissionsDataSource
import com.example.data.service.SpacexService
import com.example.domain.entity.Missions
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteMissionsDataSourceImpl @Inject constructor(
    private val service: SpacexService
): RemoteMissionsDataSource {

    override fun getMissions(): Flow<List<Missions>> = flow {
        val missions = service.getMissions()
        emit(missions)
    }.map { missionList ->
        missionList.map { mission -> convert(mission) }
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    override fun getMission(id: String?): Flow<Missions> = flow {
        emit(service.getMission(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    private fun convert(model: MissionsItemModel): Missions {
        return Missions(
            description = model.description,
            missionId = model.missionId,
            missionName = model.missionName,
            twitter = model.twitter,
            website = model.website,
            wikipedia = model.wikipedia
        )
    }
}