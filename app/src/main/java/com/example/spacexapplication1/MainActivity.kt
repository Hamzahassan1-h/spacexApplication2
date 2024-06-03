package com.example.spacexapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.NavRoutes.NavRoutes
import com.example.common.Routes.CapsuleNavRoutes
import com.example.common.Routes.HistoryNavRoutes
import com.example.common.Routes.LaunchesNavRoutes
import com.example.common.Routes.MissionsNavRoutes
import com.example.common.Routes.RocketsNavRoutes
import com.example.common.Routes.ShipsNavRoutes
import com.example.spacexapplication1.ui.compose.list.History.HistoryDetailScreen
import com.example.spacexapplication1.ui.compose.list.History.HistoryListScreen
import com.example.spacexapplication1.ui.compose.list.Launches.LaunchesDetailsScreen
import com.example.spacexapplication1.ui.compose.list.Launches.LaunchesListScreen
import com.example.spacexapplication1.ui.compose.list.Missions.MissionDetailsScreen
import com.example.spacexapplication1.ui.compose.list.Missions.MissionsListScreen
import com.example.spacexapplication1.ui.compose.list.Rockets.RocketDetailsScreen
import com.example.spacexapplication1.ui.compose.list.Rockets.RocketsListScreen
import com.example.spacexapplication1.ui.compose.list.Ships.ShipsDetailsScreen
import com.example.spacexapplication1.ui.compose.list.Ships.ShipsListScreen
import com.example.spacexapplication1.ui.compose.list.capsule.CapsuleDetailsScreen
import com.example.spacexapplication1.ui.compose.list.capsule.CapsuleListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                App(navController = navController)

            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App(navController: NavHostController) {
    val bottomBarState = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {


        else -> {
            bottomBarState.value = false
        }
    }

    Scaffold(

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ROUTE_LOGIN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.ROUTE_CAPSULES) {
                CapsuleListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Capsule.route,
                arguments = NavRoutes.Capsule.arguments
            ) {
                CapsuleDetailsScreen(CapsuleNavRoutes.Details.fromEntry(it))
            }
            composable(NavRoutes.ROUTE_HISTORY) {
                HistoryListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.History.route,
                arguments = NavRoutes.History.arguments
            ) {
                HistoryDetailScreen(HistoryNavRoutes.Details.fromEntry(it))
            }
            composable(NavRoutes.ROUTE_MISSIONS) {
                MissionsListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Missions.route,
                arguments = NavRoutes.Missions.arguments
            ) {
                MissionDetailsScreen(MissionsNavRoutes.Details.fromEntry(it))
            }
            composable(NavRoutes.ROUTE_ROCKETS) {
                RocketsListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Rockets.route,
                arguments = NavRoutes.Rockets.arguments
            ) {
                RocketDetailsScreen(RocketsNavRoutes.Details.fromEntry(it))
            }
            composable(NavRoutes.ROUTE_LAUNCHES) {
                LaunchesListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Launches.route,
                arguments = NavRoutes.Launches.arguments
            ) {
                LaunchesDetailsScreen(LaunchesNavRoutes.Details.fromEntry(it))
            }
            composable(NavRoutes.ROUTE_SHIPS) {
                ShipsListScreen(hiltViewModel(), navController = navController)
            }
            composable(
                route = NavRoutes.Ships.route,
                arguments = NavRoutes.Ships.arguments
            ) {
                ShipsDetailsScreen(ShipsNavRoutes.Details.fromEntry(it))
            }
        }
    }
}
