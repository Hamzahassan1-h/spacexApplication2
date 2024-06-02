package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.MissionsInput
import com.google.gson.Gson

sealed class MissionsNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : MissionsNavRoutes(
        route = "$ROUTE_MISSION_DETAILS/{$ARG_MISSION_DATA}",
        arguments = listOf(
            navArgument(ARG_MISSION_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForMission(input: MissionsInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_MISSION_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): MissionsInput {
            val json = entry.arguments?.getString(ARG_MISSION_DATA) ?: ""
            return MissionsInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_MISSION_DETAILS = "missionDetails"
        const val ARG_MISSION_DATA = "missionData"
    }
}

