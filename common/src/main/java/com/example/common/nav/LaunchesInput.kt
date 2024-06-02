package com.example.common.nav

import com.google.gson.Gson

data class LaunchesInput(
    val details: String?,
    val success: Boolean?,
    val missionName: String?,
    val launchYear: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): LaunchesInput {
            return Gson().fromJson(json, LaunchesInput::class.java)
        }
    }
}
