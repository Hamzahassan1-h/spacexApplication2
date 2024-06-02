package com.example.domain.usecase.Missions

import com.example.domain.entity.Missions
import com.example.domain.repo.MissionsRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetMissionsByIdUseCase(
    configuration: Configuration,
    private val repo: MissionsRepository
): UseCase<GetMissionsByIdUseCase.Request, GetMissionsByIdUseCase.Response>(configuration) {


    override fun process(request: Request): Flow<Response> =
        repo.getMission(request.id)
            .map {
                Response(it)
            }

    data class Request(val id: String?) : UseCase.Request
    data class Response(val mission: Missions?) : UseCase.Response


}

