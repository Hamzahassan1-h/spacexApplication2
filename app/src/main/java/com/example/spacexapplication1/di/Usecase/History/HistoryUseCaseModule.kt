package com.example.spacexapplication1.di.Usecase.History

import com.example.domain.repo.HistoryRepository
import com.example.domain.usecase.History.GetHistoryByIdUseCase
import com.example.domain.usecase.History.GetHistoryUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HistoryUseCaseModule {


    @Provides
    fun provideGetHistoryUseCase(
        configuration: UseCase.Configuration,
        repository: HistoryRepository
    ): GetHistoryUseCase = GetHistoryUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetHistoryByIdUseCase(
        configuration: UseCase.Configuration,
        repository: HistoryRepository
    ): GetHistoryByIdUseCase = GetHistoryByIdUseCase(
        configuration,
        repository
    )
}