package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.ShipsInput
import com.google.gson.Gson

sealed class ShipsNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : ShipsNavRoutes(
        route = "$ROUTE_SHIP_DETAILS/{$ARG_SHIP_DATA}",
        arguments = listOf(
            navArgument(ARG_SHIP_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForShip(input: ShipsInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_SHIP_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): ShipsInput {
            val json = entry.arguments?.getString(ARG_SHIP_DATA) ?: ""
            return ShipsInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_SHIP_DETAILS = "shipDetails"
        const val ARG_SHIP_DATA = "shipData"
    }
}

