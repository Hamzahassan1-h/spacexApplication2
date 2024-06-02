package com.example.spacexapplication1.di.Usecase.Launches

import com.example.domain.repo.LaunchesRepository
import com.example.domain.usecase.Launches.GetLaunchesByNumberUseCase
import com.example.domain.usecase.Launches.GetLaunchesUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LaunchesUseCaseModule {

    @Provides
    fun provideGetLaunchesUseCase(
        configuration: UseCase.Configuration,
        repository: LaunchesRepository
    ): GetLaunchesUseCase = GetLaunchesUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetLaunchByNumberUseCase(
        configuration: UseCase.Configuration,
        repository: LaunchesRepository
    ) : GetLaunchesByNumberUseCase = GetLaunchesByNumberUseCase(
        configuration,
        repository
    )
}