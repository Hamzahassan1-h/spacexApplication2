package com.example.data.Repo.Missions


import com.example.domain.entity.Missions
import kotlinx.coroutines.flow.Flow

interface RemoteMissionDataSource {

    fun getMissions(): Flow<List<Missions>>

    fun getMission(id: String?): Flow<Missions>
}