package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.HistoryInput

sealed class HistoryNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : HistoryNavRoutes(
        route = "$ROUTE_HISTORY_DETAILS/{$ARG_HISTORY_DATA}",
        arguments = listOf(
            navArgument(ARG_HISTORY_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForHistory(input: HistoryInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_HISTORY_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): HistoryInput {
            val json = entry.arguments?.getString(ARG_HISTORY_DATA) ?: ""
            return HistoryInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_HISTORY_DETAILS = "historyDetails"
        const val ARG_HISTORY_DATA = "historyData"
    }
}

