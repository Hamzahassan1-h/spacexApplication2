package com.example.spacexapplication1.ui.compose.list.capsule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.common.nav.CapsuleInput

@Composable
fun CapsuleDetailsScreen(capsuleInput: CapsuleInput) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.background)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        // Image or Icon Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.primaryVariant)
        ) {
            // You can add an actual image related to the capsule here
            Text(
                text = "Capsule Image",
                color = MaterialTheme.colors.background,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Details Section
        Text(
            text = "Capsule Details",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f))

        Spacer(modifier = Modifier.height(8.dp))

        // Capsule Information
        CapsuleDetailItem(label = "Details", value = capsuleInput.details)
        CapsuleDetailItem(label = "Status", value = capsuleInput.status)
        CapsuleDetailItem(label = "Landings", value = capsuleInput.landings.toString())
        CapsuleDetailItem(label = "Type", value = capsuleInput.type)
        CapsuleDetailItem(label = "Launch", value = capsuleInput.launch)
    }
}

@Composable
fun CapsuleDetailItem(label: String, value: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary
        )
        Text(
            text = value ?: "N/A",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )
        Divider(
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
            thickness = 0.5.dp
        )
    }
}
