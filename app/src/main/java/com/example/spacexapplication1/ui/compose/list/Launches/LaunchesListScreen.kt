package com.example.spacexapplication1.ui.compose.list.Launches

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.common.state.CommonScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LaunchesListScreen(
    viewModel: LaunchesListViewModel,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(LaunchesListUiAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                LaunchList(it) { item ->
                    viewModel.submitAction(
                        LaunchesListUiAction.OnLaunchItemClick(
                            item.details,
                            item.launchSuccess,
                            item.missionName,
                            item.launchYear
                        )
                    )
                }

                LaunchedEffect(Unit) {
                    viewModel.singleEventFlow.collectLatest {
                        when (it) {
                            is LaunchesListUiSingleEvent.OpenDetailsScreen -> {
                                Log.i("ROUTE", it.navRoute)
                                navController.navigate(it.navRoute)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LaunchList(
    model: LaunchesListModel,
    onItemClick: (Launches) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(model.items) { launch ->
            LaunchItem(launchItem = launch, onItemClick = onItemClick)
        }
    }
}

@Composable
fun LaunchItem(launchItem: Launches, onItemClick: (Launches) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onItemClick(launchItem) }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Mission Name: ${launchItem.missionName}",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Details: ${launchItem.details}",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Text(
                text = "Launch Success: ${if (launchItem.launchSuccess == true) "Yes" else "No"}",
                style = MaterialTheme.typography.headlineSmall,
                color = if (launchItem.launchSuccess == true) Color.Green else Color.Red
            )
            Text(
                text = "Launch Year: ${launchItem.launchYear}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
