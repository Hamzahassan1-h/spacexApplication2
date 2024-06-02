package com.example.domain.usecase.Launches

import com.example.domain.entity.Launches
import com.example.domain.repo.LaunchesRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLaunchesUseCase(
    configuration: Configuration,
    private val repo: LaunchesRepository
) : UseCase<GetLaunchesUseCase.Request, GetLaunchesUseCase.Response>(configuration) {



    override fun process(request: Request): Flow<Response> =
        repo.getLaunches()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val launches: List<Launches?>?) : UseCase.Response




}