package com.example.domain.repo

import com.example.domain.entity.Capsule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow


interface CapsuleRepository {

        fun getCapsules(): Flow<List<Capsule?>?>

        fun getCapsule(serial: String?): Flow<Capsule>
}