package com.example.spacexapplication1.ui.compose.list.Missions


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.common.nav.MissionsInput


@Composable
fun MissionDetailsScreen(missionInput: MissionsInput) {

    Column {
        Text(
            text = "Mission Description:",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "${missionInput.descriptions}"
        )

    }

}