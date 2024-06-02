package com.example.domain.usecase.Missions

import com.example.domain.entity.Missions
import com.example.domain.repo.MissionsRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMissionsUseCase(
    configuration: Configuration,
    private val repo: MissionsRepository
): UseCase<GetMissionsUseCase.Request, GetMissionsUseCase.Response>(configuration){
    override fun process(request: Request): Flow<Response> =
        repo.getMissions()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val missions: List<Missions?>?) : UseCase.Response


}