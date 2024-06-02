package com.example.data.Repo.Ships



import com.example.domain.entity.Ships
import com.example.domain.repo.ShipsRepository
import kotlinx.coroutines.flow.Flow

class ShipsRepositoryImpl(
    private val remoteSource: RemoteShipsDataSource
) : ShipsRepository {
    override fun getShips(): Flow<List<Ships>> {
        return remoteSource.getShips()
    }

    override fun getShip(id: String?): Flow<Ships> {
        return remoteSource.getShip(id)
    }
}