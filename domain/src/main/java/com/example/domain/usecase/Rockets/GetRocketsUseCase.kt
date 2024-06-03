package com.example.domain.usecase.Rockets

import com.example.domain.entity.Rockets
import com.example.domain.repo.RocketsRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetRocketsUseCase(
    configuration: Configuration,
    private val repo: RocketsRepository
) : UseCase<GetRocketsUseCase.Request, GetRocketsUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getRockets()
            .map {
                Response(it)
            }
    data object Request : UseCase.Request
    data class Response(val rockets: List<Rockets?>?) : UseCase.Response
}