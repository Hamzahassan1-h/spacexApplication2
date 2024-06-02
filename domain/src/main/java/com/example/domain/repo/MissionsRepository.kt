package com.example.domain.repo

import com.example.domain.entity.Missions
import kotlinx.coroutines.flow.Flow

interface MissionsRepository {
    fun getMissions(): Flow<List<Missions>>

    fun getMission(id: String?): Flow<Missions>
}