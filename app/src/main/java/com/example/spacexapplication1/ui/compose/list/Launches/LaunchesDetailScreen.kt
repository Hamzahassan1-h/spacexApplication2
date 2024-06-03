package com.example.spacexapplication1.ui.compose.list.Launches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.nav.LaunchesInput

@Composable
fun LaunchesDetailsScreen(launchInput: LaunchesInput) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Mission Name: ${launchInput.missionName}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Details: ${launchInput.details}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Launch Success: ${launchInput.success}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Launch Year: ${launchInput.launchYear}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}