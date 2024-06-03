package com.example.spacexapplication1.ui.compose.list.Ships

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.nav.ShipsInput

@Composable
fun ShipsDetailsScreen(shipInput: ShipsInput) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {


        Text(
            text = "Ship Name: ${shipInput.shipName}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Ship Type: ${shipInput.shipType}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Year Built: ${shipInput.yearBuilt}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}