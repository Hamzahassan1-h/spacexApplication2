package com.example.spacexapplication1.di.Usecase.Missions

import com.example.domain.repo.MissionsRepository
import com.example.domain.usecase.Missions.GetMissionsByIdUseCase
import com.example.domain.usecase.Missions.GetMissionsUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MissionsUseCaseModule {

    @Provides
    fun provideGetMissionUseCase(
        configuration: UseCase.Configuration,
        repository: MissionsRepository
    ): GetMissionsUseCase = GetMissionsUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetMissionByIdUseCase(
        configuration: UseCase.Configuration,
        repository: MissionsRepository
    ): GetMissionsByIdUseCase = GetMissionsByIdUseCase(
        configuration,
        repository
    )

}