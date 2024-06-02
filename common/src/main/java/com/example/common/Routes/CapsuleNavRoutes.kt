package com.example.common.Routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.CapsuleInput
import com.google.gson.Gson

sealed class CapsuleNavRoutes (
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : CapsuleNavRoutes(
        route = "$ROUTE_CAPSULE_DETAILS/{$ARG_CAPSULE_DATA}",
        arguments = listOf(
            navArgument(ARG_CAPSULE_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForCapsule(input: CapsuleInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_CAPSULE_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): CapsuleInput {
            val json = entry.arguments?.getString(ARG_CAPSULE_DATA) ?: ""
            return CapsuleInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_CAPSULE_DETAILS = "capsuleDetails"
        const val ARG_CAPSULE_DATA = "capsule_data"
    }
}


