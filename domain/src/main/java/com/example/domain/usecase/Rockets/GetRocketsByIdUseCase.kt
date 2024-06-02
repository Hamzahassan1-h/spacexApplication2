package com.example.domain.usecase.Rockets

import com.example.domain.entity.Rockets
import com.example.domain.repo.RocketsRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetRocketsByIdUseCase(
    configuration: Configuration,
    private val repo: RocketsRepository
) : UseCase<GetRocketsByIdUseCase.Request, GetRocketsByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getRocket(request.id)
            .map {
                Response(it)
            }


    data class Request(val id: Int?) : UseCase.Request
    data class Response(val rocket: Rockets?) : UseCase.Response
}