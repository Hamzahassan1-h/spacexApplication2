package com.example.data.Repo.Missions


import com.example.domain.entity.Missions
import kotlinx.coroutines.flow.Flow

interface RemoteMissionsDataSource {

    fun getMissions(): Flow<List<Missions>>

    fun getMission(id: String?): Flow<Missions>
}