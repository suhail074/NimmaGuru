package com.example.nimmaguru.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FeedCard(
    username: String,
    message: String,
    guru: String
) {

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = username,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "\"$message\"",
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "Guru: $guru",
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}