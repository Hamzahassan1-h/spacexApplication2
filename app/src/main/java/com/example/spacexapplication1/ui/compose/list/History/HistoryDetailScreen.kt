package com.example.spacexapplication1.ui.compose.list.History

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.nav.HistoryInput

@Composable
fun HistoryDetailScreen(historyInput: HistoryInput) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Event Title: ${historyInput.title}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Event Details: ${historyInput.details}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Flight Number: ${historyInput.flightNumber}",
            style = MaterialTheme.typography.bodyMedium
        )

    }
}
