package com.example.spacexapplication1.ui.compose.list.Rockets

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.common.state.CommonScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RocketsListScreen(
    viewModel: RocketsListViewModel,
    navController: NavController
) {

    LaunchedEffect(Unit) {
        viewModel.submitAction(RocketsListUiAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                RocketList(it) { item ->
                    viewModel.submitAction(
                        RocketsListUiAction.OnRocketItemClick(
                            item.company,
                            item.description,
                            item.costPerLaunch,
                            item.rocketType,
                            item.country
                        )
                    )
                }
            }

        }
    }

    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is RocketsListUiSingleEvent.OpenDetailsScreen -> {
                    Log.i("ROUTE", it.navRoute)
                    navController.navigate(it.navRoute)
                }
            }
        }
    }
}


@Composable
fun RocketList(
    model: RocketsListModel,
    onItemClick: (Rockets) -> Unit,
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(model.items) { rocket ->
            Rocket(rocket = rocket, onItemClick = onItemClick)
        }
    }

}




@Composable
fun Rocket(rocket: Rockets, onItemClick: (Rockets) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(rocket) }
        ,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Rocket Name: ${rocket.rocketName}")
        }
    }
}