package com.example.domain.usecase.Ships

import com.example.domain.entity.Ships
import com.example.domain.repo.ShipsRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetShipsUseCase(
    configuration: Configuration,
    private val repo: ShipsRepository
) : UseCase<GetShipsUseCase.Request, GetShipsUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> =
        repo.getShips()
            .map {
                Response(it)
            }


    data object Request : UseCase.Request
    data class Response(val ships: List<Ships>) : UseCase.Response
}