package com.example.nimmaguru.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nimmaguru.model.Session
import com.example.nimmaguru.ui.theme.AppStrings
import com.example.nimmaguru.ui.theme.LanguageManager

@Composable
fun CalendarScreen() {

    val isKannada = LanguageManager.isKannada.value

    val sessions = if (isKannada) {

        listOf(

            Session(
                mentorName = "ಡಾ. ಸುಲೋಚನಾ ದೇವಿ",
                skill = "ಗಣಿತ",
                status = "ಇಂದು",
                time = "5 PM - 8 PM",
                location = "ಮೈಸೂರು"
            ),

            Session(
                mentorName = "ಮಾಸ್ಟರ್ ಎಚ್. ಬಸಪ್ಪ",
                skill = "ತೋಟಗಾರಿಕೆ",
                status = "ಮುಂಬರುವ",
                time = "7 AM - 9 AM",
                location = "ಹಿರಿಸಾವೆ ಗ್ರಾಮ"
            ),

            Session(
                mentorName = "ಪ್ರೊ. ವೆಂಕಟೇಶ್ ರಾವ್",
                skill = "ಕಥೆ ಹೇಳುವಿಕೆ",
                status = "ಪೂರ್ಣಗೊಂಡಿದೆ",
                time = "4 PM - 6 PM",
                location = "ಶ್ರವಣಬೆಳಗೊಳ"
            )
        )

    } else {

        listOf(

            Session(
                mentorName = "Dr. Sulochana Devi",
                skill = "Mathematics",
                status = "Today",
                time = "5 PM - 8 PM",
                location = "Mysuru"
            ),

            Session(
                mentorName = "Master H. Basappa",
                skill = "Gardening",
                status = "Upcoming",
                time = "7 AM - 9 AM",
                location = "Hirisave Village"
            ),

            Session(
                mentorName = "Prof. Venkatesh Rao",
                skill = "Storytelling",
                status = "Completed",
                time = "4 PM - 6 PM",
                location = "Shravanabelagola"
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = AppStrings.upcomingSessions(),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = {
                        LanguageManager.toggleLanguage()
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.Translate,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))
        }

        items(sessions) { session ->

            val statusColor = when (session.status) {

                "Today", "ಇಂದು" -> Color.Red

                "Upcoming", "ಮುಂಬರುವ" -> Color(0xFF1565C0)

                else -> Color(0xFF2E7D32)
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.dp),

                shape = RoundedCornerShape(30.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F1F8)
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.Circle,
                            contentDescription = null,
                            tint = statusColor,
                            modifier = Modifier.size(14.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = session.status,
                            color = statusColor,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = session.mentorName,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = session.skill,
                        color = Color(0xFF283593),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = session.time,
                        color = Color(0xFF00897B),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = session.location,
                        color = Color.Gray,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}