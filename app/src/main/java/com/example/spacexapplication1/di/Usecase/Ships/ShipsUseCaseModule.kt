package com.example.spacexapplication1.di.Usecase.Ships

import com.example.domain.repo.ShipsRepository
import com.example.domain.usecase.Ships.GetShipsByIdUseCase
import com.example.domain.usecase.Ships.GetShipsUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ShipsUseCaseModule {

    @Provides
    fun provideGetShipsUseCase(
        configuration: UseCase.Configuration,
        repository: ShipsRepository
    ) : GetShipsUseCase = GetShipsUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetShipByIdUseCase(
        configuration: UseCase.Configuration,
        repository: ShipsRepository
    ) : GetShipsByIdUseCase = GetShipsByIdUseCase(
        configuration,
        repository
    )
}

