package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.LaunchesInput
import com.google.gson.Gson

sealed class LaunchesNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : LaunchesNavRoutes(
        route = "$ROUTE_LAUNCH_DETAILS/{$ARG_LAUNCH_DATA}",
        arguments = listOf(
            navArgument(ARG_LAUNCH_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForLaunch(input: LaunchesInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_LAUNCH_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): LaunchesInput {
            val json = entry.arguments?.getString(ARG_LAUNCH_DATA) ?: ""
            return LaunchesInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_LAUNCH_DETAILS = "launchDetails"
        const val ARG_LAUNCH_DATA = "launchDetails"
    }
}

