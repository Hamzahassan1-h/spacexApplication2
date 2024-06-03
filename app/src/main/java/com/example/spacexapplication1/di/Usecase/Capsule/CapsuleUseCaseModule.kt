package com.example.spacexapplication1.di.Usecase.Capsule

import com.example.domain.repo.CapsuleRepository
import com.example.domain.usecase.Capsule.GetCapsuleBySerialUseCase
import com.example.domain.usecase.Capsule.GetCapsulesUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CapsuleUseCaseModule {

    @Provides
    fun provideGetCapsulesUseCase(
        configuration: UseCase.Configuration,
        repository: CapsuleRepository
    ): GetCapsulesUseCase = GetCapsulesUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetCapsuleBySerialUseCase(
        configuration: UseCase.Configuration,
        repository: CapsuleRepository
    ): GetCapsuleBySerialUseCase = GetCapsuleBySerialUseCase(
        configuration,
        repository
    )


}