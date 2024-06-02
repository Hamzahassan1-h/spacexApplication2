package com.example.data.Repo.Capsule

//import com.example.data.Remote.Network.Capsule.Capsule
import com.example.domain.entity.Capsule
import kotlinx.coroutines.flow.Flow

interface RemoteCapsuleDataSource {

    fun getCapsules(): Flow<List<Capsule?>?>

    fun getCapsule(serial: String?): Flow<Capsule>

}

