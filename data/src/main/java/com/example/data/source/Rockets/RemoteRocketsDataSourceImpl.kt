package com.example.data.source.Rockets


import com.example.data.Remote.Network.Rockets.RocketsItemModel
import com.example.data.Repo.Rockets.RemoteRocketDataSource
import com.example.data.service.SpacexService
import com.example.domain.entity.Rockets
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRocketsDataSourceImpl @Inject constructor(
    private val service: SpacexService
) : RemoteRocketDataSource {


    override fun getRockets(): Flow<List<Rockets>> = flow {
        val rockets = service.getRockets()
        emit(rockets)
    }.map { rocketList ->
        rocketList.map { rocket -> convert(rocket) }
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    override fun getRocket(id: Int?): Flow<Rockets> = flow {
        emit(service.getRocket(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    private fun convert(model: RocketsItemModel): Rockets {
        return Rockets(
            active = model.active,
            company = model.company,
            description = model.description,
            country = model.country,
            id = model.id,
            rocketId = model.rocketId,
            rocketName = model.rocketName,
            costPerLaunch = model.costPerLaunch
        )
    }
}