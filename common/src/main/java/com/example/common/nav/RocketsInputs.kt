package com.example.common.nav

import com.google.gson.Gson

data class RocketsInputs(
    val company: String?,
    val description: String?,
    val costPerLaunch: Int?,
    val rocketType: String?,
    val country: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): RocketsInputs {
            return Gson().fromJson(json, RocketsInputs::class.java)
        }
    }
}

