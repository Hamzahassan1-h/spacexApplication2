package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.CapsuleInput

sealed class CapsuleNavRoutes (
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : CapsuleNavRoutes(
        route = "$ROUTE_CAPSULES_DETAILS/{$ARG_CAPSULES_DATA}",
        arguments = listOf(
            navArgument(ARG_CAPSULES_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForCapsule(input: CapsuleInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_CAPSULES_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): CapsuleInput {
            val json = entry.arguments?.getString(ARG_CAPSULES_DATA) ?: ""
            return CapsuleInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_CAPSULES_DETAILS = "capsuleDetails"
        const val ARG_CAPSULES_DATA = "capsule_data"
    }
}


