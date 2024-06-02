package com.example.data.Repo.Launches

import com.example.domain.entity.Launches
import kotlinx.coroutines.flow.Flow

interface RemoteLaunchesDataSource {

    fun getLaunches(): Flow<List<Launches>>

    fun getLaunch(number: Int?): Flow<Launches>
}