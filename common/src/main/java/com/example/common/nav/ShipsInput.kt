package com.example.common.nav

import com.google.gson.Gson

data class ShipsInput(
    val model: String?,
    val shipName: String?,
    val status: String?,
    val shipType: String?,
    val image: String?,
    val weight: Int?,
    val yearBuilt: Int?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): ShipsInput {
            return Gson().fromJson(json, ShipsInput::class.java)
        }
    }
}
