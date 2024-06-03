package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.MissionsInput

sealed class MissionsNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : MissionsNavRoutes(
        route = "$ROUTE_MISSIONS_DETAILS/{$ARG_MISSIONS_DATA}",
        arguments = listOf(
            navArgument(ARG_MISSIONS_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForMission(input: MissionsInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_MISSIONS_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): MissionsInput {
            val json = entry.arguments?.getString(ARG_MISSIONS_DATA) ?: ""
            return MissionsInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_MISSIONS_DETAILS = "missionsDetails"
        const val ARG_MISSIONS_DATA = "missionsData"
    }
}

