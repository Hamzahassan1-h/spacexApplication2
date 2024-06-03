package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.RocketsInputs

sealed class RocketsNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : RocketsNavRoutes(
        route = "$ROUTE_ROCKETS_DETAILS/{$ARG_ROCKETS_DATA}",
        arguments = listOf(
            navArgument(ARG_ROCKETS_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForRocket(input: RocketsInputs): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_ROCKETS_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): RocketsInputs {
            val json = entry.arguments?.getString(ARG_ROCKETS_DATA) ?: ""
            return RocketsInputs.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_ROCKETS_DETAILS = "rocketsDetails"
        const val ARG_ROCKETS_DATA = "rocketsData"
    }
}


