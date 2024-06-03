package com.example.spacexapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
import com.example.spacexapplication1.ui.compose.nav.HomeScreen
import com.example.spacexapplication1.ui.compose.nav.LoginScreen
import com.example.spacexapplication1.ui.compose.nav.signOut
import com.google.firebase.auth.FirebaseAuth
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App(navController: NavHostController) {
    val topBarState = remember { mutableStateOf(false) }
    val bottomBarState = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val topBarTitle = remember(currentRoute) {
        when (currentRoute) {
            NavRoutes.ROUTE_CAPSULES -> "Capsules"
            NavRoutes.Capsule.route -> "Capsule Details"
            NavRoutes.ROUTE_HISTORY -> "History"
            NavRoutes.History.route -> "History Details"
            NavRoutes.ROUTE_MISSIONS -> "Missions"
            NavRoutes.Missions.route -> "Mission Details"
            NavRoutes.ROUTE_ROCKETS -> "Rockets"
            NavRoutes.Rockets.route -> "Rocket Details"
            NavRoutes.ROUTE_LAUNCHES -> "Launches"
            NavRoutes.Launches.route -> "Launches Details"
            NavRoutes.ROUTE_SHIPS -> "Ships"
            NavRoutes.Ships.route -> "Ship Details"
            else -> "Details"
        }
    }

    when (navBackStackEntry?.destination?.route) {
        NavRoutes.Home.route,
        NavRoutes.Home.route -> {
            bottomBarState.value = true
            topBarState.value = false
        }

        else -> {
            bottomBarState.value = false
            topBarState.value = true
        }
    }

    Scaffold(
        topBar = {
            if (topBarState.value) {
                TopAppBar(
                    //backgroundColor = MaterialTheme.colorScheme.primary,
                    title = { Text(text = topBarTitle) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (bottomBarState.value) {
                BottomAppBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ROUTE_LOGIN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.ROUTE_LOGIN) {
                LoginScreen(navController = navController)
            }
            composable(NavRoutes.Home.route) {
                HomeScreen(navController = navController)
            }
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

@Composable
fun BottomAppBar(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .clickable { signOut(auth, navController) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign Out",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .clickable { signOut(auth, navController) }
            )
        }
    }
}
