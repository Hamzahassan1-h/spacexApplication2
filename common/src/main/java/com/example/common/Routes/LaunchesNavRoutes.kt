package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.LaunchesInput

sealed class LaunchesNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : LaunchesNavRoutes(
        route = "$ROUTE_LAUNCHES_DETAILS/{$ARG_LAUNCHES_DATA}",
        arguments = listOf(
            navArgument(ARG_LAUNCHES_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForLaunch(input: LaunchesInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_LAUNCHES_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): LaunchesInput {
            val json = entry.arguments?.getString(ARG_LAUNCHES_DATA) ?: ""
            return LaunchesInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_LAUNCHES_DETAILS = "launchesDetails"
        const val ARG_LAUNCHES_DATA = "launchesData"
    }
}

