package com.example.domain.usecase.Ships

import com.example.domain.entity.Ships
import com.example.domain.repo.ShipsRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetShipsByIdUseCase(
    configuration: Configuration,
    private val repo: ShipsRepository
) : UseCase<GetShipsByIdUseCase.Request, GetShipsByIdUseCase.Response>(configuration){


    override fun process(request: Request): Flow<Response> =
        repo.getShip(request.id)
            .map {
                Response(it)
            }
    data class Request(val id: String?) : UseCase.Request
    data class Response(val ship: Ships?) : UseCase.Response
}