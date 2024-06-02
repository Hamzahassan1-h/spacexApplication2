package com.example.common.nav

import com.google.gson.Gson

data class HistoryInput(
    val title: String?,
    val details: String?,
    val flightNumber: Int?,
    val date: String?,
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): HistoryInput {
            return Gson().fromJson(json, HistoryInput::class.java)
        }
    }
}
