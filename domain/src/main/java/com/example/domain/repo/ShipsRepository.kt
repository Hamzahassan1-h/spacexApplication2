package com.example.domain.repo

import com.example.domain.entity.Ships
import kotlinx.coroutines.flow.Flow

interface ShipsRepository {
    fun getShips(): Flow<List<Ships>>

    fun getShip(id: String?): Flow<Ships>
}