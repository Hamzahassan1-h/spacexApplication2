package com.example.domain.repo

import com.example.domain.entity.Rockets
import kotlinx.coroutines.flow.Flow

interface RocketsRepository {

    fun getRockets(): Flow<List<Rockets>>

    fun getRocket(id: Int?): Flow<Rockets>
}