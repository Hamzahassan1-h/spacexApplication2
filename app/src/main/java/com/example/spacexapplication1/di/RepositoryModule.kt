package com.example.spacexapplication1.di

import com.example.data.Repo.Capsule.CapsuleRepositoryImplementation
import com.example.data.Repo.Capsule.RemoteCapsuleDataSource
import com.example.data.Repo.History.HistoryRepositoryImpl
import com.example.data.Repo.History.RemoteHistoryDataSource
import com.example.data.Repo.Launches.LaunchesRepositoryImpl
import com.example.data.Repo.Launches.RemoteLaunchesDataSource
import com.example.data.Repo.Missions.MissionsRepositoryImpl
import com.example.data.Repo.Missions.RemoteMissionDataSource
import com.example.data.Repo.Rockets.RemoteRocketDataSource
import com.example.data.Repo.Rockets.RocketsRepositoryImpl
import com.example.data.Repo.Ships.RemoteShipsDataSource
import com.example.data.Repo.Ships.ShipsRepositoryImpl
import com.example.domain.repo.HistoryRepository
import com.example.domain.repo.LaunchesRepository
import com.example.domain.repo.MissionsRepository
import com.example.domain.repo.RocketsRepository
import com.example.domain.repo.ShipsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesCapsuleRepository(
        remoteSource: RemoteCapsuleDataSource,
      ): CapsuleRepositoryImplementation = CapsuleRepositoryImplementation(
          remoteSource
      )

    @Provides
    fun providesHistoryRepository(
        remoteSource: RemoteHistoryDataSource
    ): HistoryRepository = HistoryRepositoryImpl(
        remoteSource
    )

    @Provides
    fun providesMissionRepository(
        remoteSource: RemoteMissionDataSource
    ): MissionsRepository = MissionsRepositoryImpl(
        remoteSource
    )

    @Provides
    fun providesRocketRepository(
        remoteSource: RemoteRocketDataSource
    ) : RocketsRepository = RocketsRepositoryImpl(
        remoteSource
    )

    @Provides
    fun providesLaunchesRepository(
        remoteSource: RemoteLaunchesDataSource
    ) : LaunchesRepository = LaunchesRepositoryImpl(
        remoteSource
    )

    @Provides
    fun providesShipsRepository(
        remoteSource: RemoteShipsDataSource
    ) : ShipsRepository = ShipsRepositoryImpl (
        remoteSource
    )



}