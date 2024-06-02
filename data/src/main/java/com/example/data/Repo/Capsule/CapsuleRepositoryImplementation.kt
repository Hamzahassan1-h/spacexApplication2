package com.example.data.Repo.Capsule


import com.example.domain.entity.Capsule
import com.example.domain.repo.CapsuleRepository
import kotlinx.coroutines.flow.Flow

class CapsuleRepositoryImplementation(
    private val remoteSource: RemoteCapsuleDataSource,
): CapsuleRepository {

    override fun getCapsules(): Flow<List<Capsule?>?> {
        return remoteSource.getCapsules()
    }

    override fun getCapsule(serial: String?): Flow<Capsule> {
        return remoteSource.getCapsule(serial)
    }
}