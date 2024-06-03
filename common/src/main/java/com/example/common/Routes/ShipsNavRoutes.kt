package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.ShipsInput

sealed class ShipsNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : ShipsNavRoutes(
        route = "$ROUTE_SHIPS_DETAILS/{$ARG_SHIPS_DATA}",
        arguments = listOf(
            navArgument(ARG_SHIPS_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForShip(input: ShipsInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_SHIPS_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): ShipsInput {
            val json = entry.arguments?.getString(ARG_SHIPS_DATA) ?: ""
            return ShipsInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_SHIPS_DETAILS = "shipDetails"
        const val ARG_SHIPS_DATA = "shipData"
    }
}

