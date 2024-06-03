package com.example.data.source.Ships

import com.example.data.Remote.Network.Ships.shipsItemModel
import com.example.data.Repo.Ships.RemoteShipsDataSource
import com.example.data.service.SpacexService
import com.example.domain.entity.Ships
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject



class RemoteShipsDataSourceImpl @Inject constructor(
    private val service: SpacexService
) : RemoteShipsDataSource {

    override fun getShips(): Flow<List<Ships>> = flow {
        val ships = service.getShips()
        emit(ships)
    }.map { shipList ->
        shipList.map { ships -> convert(ships) }
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    override fun getShip(id: String?): Flow<Ships> = flow {
        emit(service.getShip(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.SpacexException(it)
    }

    private fun convert(model: shipsItemModel): Ships {
        return Ships(
            image = model.image,
            shipId = model.shipId,
            shipName = model.shipName,
            shipType = model.shipType,
            status = model.status,
            yearBuilt = model.yearBuilt,
            active = model.active
        )
    }
}