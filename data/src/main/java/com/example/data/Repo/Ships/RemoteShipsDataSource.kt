package com.example.data.Repo.Ships

import com.example.domain.entity.Ships
import kotlinx.coroutines.flow.Flow


interface RemoteShipsDataSource {

    fun getShips(): Flow<List<Ships>>

    fun getShip(id: String?): Flow<Ships>
}