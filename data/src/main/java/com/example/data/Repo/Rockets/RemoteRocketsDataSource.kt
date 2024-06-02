package com.example.data.Repo.Rockets


import com.example.domain.entity.Rockets
import kotlinx.coroutines.flow.Flow

interface RemoteRocketDataSource {

    fun getRockets(): Flow<List<Rockets>>

    fun getRocket(id: Int?): Flow<Rockets>
}