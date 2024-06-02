package com.example.domain.usecase.Launches

import com.example.domain.entity.Launches
import com.example.domain.repo.LaunchesRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLaunchesByNumberUseCase(
    configuration: Configuration,
    private val repo: LaunchesRepository
) : UseCase<GetLaunchesByNumberUseCase.Request, GetLaunchesByNumberUseCase.Response>(configuration) {


    data class Request(val number: Int?) : UseCase.Request
    data class Response(val launchItem: Launches) : UseCase.Response

    override fun process(request: Request): Flow<Response> =
        repo.getLaunchItem(request.number)
            .map {
                Response(it)
            }


}