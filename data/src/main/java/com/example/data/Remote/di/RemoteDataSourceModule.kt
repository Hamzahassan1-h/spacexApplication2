package com.example.data.Remote.di

import com.example.data.Repo.Capsule.RemoteCapsuleDataSource
import com.example.data.Repo.History.RemoteHistoryDataSource
import com.example.data.Repo.Launches.RemoteLaunchesDataSource
import com.example.data.Repo.Missions.RemoteMissionDataSource
import com.example.data.Repo.Rockets.RemoteRocketDataSource
import com.example.data.Repo.Ships.RemoteShipsDataSource
import com.example.data.source.History.RemoteHistoryDataSourceImpl
import com.example.data.source.Launches.RemoteLaunchesDataSourceImpl
import com.example.data.source.Missions.RemoteMissionsDataSourceImpl
import com.example.data.source.Rockets.RemoteRocketsDataSourceImpl
import com.example.data.source.Ships.RemoteShipsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindCapsuleInfoDataSource(dataSource: RemoteCapsuleDataSource): RemoteCapsuleDataSource

    @Binds
    abstract fun bindHistoryInfoDataSource(datasource: RemoteHistoryDataSourceImpl): RemoteHistoryDataSource

    @Binds
    abstract fun bindMissionInfoDataSource(dataSource: RemoteMissionsDataSourceImpl): RemoteMissionDataSource

    @Binds
    abstract fun bindRocketInfoDataSource(dataSource: RemoteRocketsDataSourceImpl): RemoteRocketDataSource

    @Binds
    abstract fun bindLaunchInfoDataSource(dataSource: RemoteLaunchesDataSourceImpl): RemoteLaunchesDataSource

    @Binds
    abstract fun bindShipInfoDataSource(dataSource: RemoteShipsDataSourceImpl): RemoteShipsDataSource




}