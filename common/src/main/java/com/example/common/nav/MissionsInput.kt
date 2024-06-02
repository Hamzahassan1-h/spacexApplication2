package com.example.common.nav

import com.google.gson.Gson

data class MissionsInput(
    val descriptions: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): MissionsInput {
            return Gson().fromJson(json, MissionsInput::class.java)
        }
    }
}