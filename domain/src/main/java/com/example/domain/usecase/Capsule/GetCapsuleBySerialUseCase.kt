package com.example.domain.usecase.Capsule

import com.example.domain.entity.Capsule
import com.example.domain.repo.CapsuleRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCapsuleBySerialUseCase (
    configuration: Configuration,
    private val repo: CapsuleRepository
) : UseCase<GetCapsuleBySerialUseCase.Request, GetCapsuleBySerialUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getCapsule(request.serial)
            .map {
                Response(it)
            }
    data class Request(val serial: String?) : UseCase.Request
    data class Response(val capsule: Capsule?) : UseCase.Response
}