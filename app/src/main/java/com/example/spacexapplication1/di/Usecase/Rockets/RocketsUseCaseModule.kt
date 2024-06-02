package com.example.spacexapplication1.di.Usecase.Rockets

import com.example.domain.repo.RocketsRepository
import com.example.domain.usecase.Rockets.GetRocketsByIdUseCase
import com.example.domain.usecase.Rockets.GetRocketsUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RocketsUseCaseModule {

    @Provides
    fun provideGetRocketsUseCase(
        configuration: UseCase.Configuration,
        repository: RocketsRepository
    ) : GetRocketsUseCase = GetRocketsUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetRocketByIdUseCase(
        configuration: UseCase.Configuration,
        repository: RocketsRepository
    ) : GetRocketsByIdUseCase = GetRocketsByIdUseCase(
        configuration,
        repository
    )
}