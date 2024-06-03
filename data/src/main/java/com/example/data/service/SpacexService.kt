package com.example.data.service

import com.example.data.Remote.Network.Capsule.CapsuleItemModel
import com.example.data.Remote.Network.History.HistoryItemModel
import com.example.data.Remote.Network.Missions.MissionsItemModel
import com.example.data.Remote.Network.Rockets.RocketsItemModel
import com.example.data.Remote.Network.Ships.shipsItemModel
import com.example.data.Remote.Network.launches.LaunchesItemModel
import retrofit2.http.GET

interface SpacexService {

    //capsules
    @GET("capsules")
    suspend fun getCapsules(): List<CapsuleItemModel>

    @GET("capsules/{capsule_serial}")
    suspend fun getCapsule(serial: String?): CapsuleItemModel


    //history
    @GET("history")
    suspend fun getHistory(): List<HistoryItemModel>

    @GET("history/{id}")
    suspend fun getHistoryItem(id: Int?): HistoryItemModel


    //launches
    @GET("launches")
    suspend fun getLaunches(): List<LaunchesItemModel>

    @GET("launches/{flight_number}")
    suspend fun getLaunch(number: Int?): LaunchesItemModel

    //missions
    @GET("missions")
    suspend fun getMissions(): List<MissionsItemModel>

    @GET("missions/{mission_id}")
    suspend fun getMission(id: String?): MissionsItemModel

    //rockets
    @GET("rockets")
    suspend fun getRockets(): List<RocketsItemModel>

    @GET("rockets/{id}")
    suspend fun getRocket(id: Int?): RocketsItemModel


    //ships
    @GET("ships")
    suspend fun getShips(): List<shipsItemModel>

    @GET("ships/{ship_id}")
    suspend fun getShip(id: String?): shipsItemModel

}