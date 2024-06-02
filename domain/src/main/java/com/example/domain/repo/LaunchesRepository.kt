package com.example.domain.repo

import com.example.domain.entity.Launches
import kotlinx.coroutines.flow.Flow

interface LaunchesRepository {
    fun getLaunches(): Flow<List<Launches>>

    fun getLaunchItem(number: Int?): Flow<Launches>
}