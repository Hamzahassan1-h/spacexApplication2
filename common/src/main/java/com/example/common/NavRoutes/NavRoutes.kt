package com.example.common.NavRoutes

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.Routes.CapsuleNavRoutes
import com.example.common.Routes.HistoryNavRoutes
import com.example.common.Routes.LaunchesNavRoutes
import com.example.common.Routes.MissionsNavRoutes
import com.example.common.Routes.RocketsNavRoutes
import com.example.common.Routes.ShipsNavRoutes
import com.example.common.nav.CapsuleInput

sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Capsule : NavRoutes(CapsuleNavRoutes.Details.route, CapsuleNavRoutes.Details.arguments)
    data object History : NavRoutes(HistoryNavRoutes.Details.route, HistoryNavRoutes.Details.arguments)
    data object Launches : NavRoutes(LaunchesNavRoutes.Details.route, LaunchesNavRoutes.Details.arguments)
    data object Missions : NavRoutes(MissionsNavRoutes.Details.route, MissionsNavRoutes.Details.arguments)
    data object Rockets : NavRoutes(RocketsNavRoutes.Details.route, RocketsNavRoutes.Details.arguments)
    data object Ships : NavRoutes(ShipsNavRoutes.Details.route, ShipsNavRoutes.Details.arguments)

    companion object {
        const val ROUTE_CAPSULES = "capsules"
        const val ROUTE_MISSIONS = "missions"
        const val ROUTE_LAUNCHES = "launches"
        const val ROUTE_ROCKETS = "rockets"
        const val ROUTE_SHIPS = "ships"
        const val ROUTE_AUTH = "auth"
        const val ROUTE_HISTORY = "history"
    }
}