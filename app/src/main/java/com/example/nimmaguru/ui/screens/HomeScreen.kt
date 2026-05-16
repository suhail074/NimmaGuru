package com.example.nimmaguru.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nimmaguru.ui.theme.AppStrings
import com.example.nimmaguru.ui.theme.LanguageManager




data class FameMentor(
    val rank: Int,
    val name: String,
    val hearts: Int,
    val image: String
)

data class Appreciation(
    val username: String,
    val message: String,
    val guru: String
)

@Composable
fun HomeScreen() {
    IconButton(
        onClick = {
            LanguageManager.toggleLanguage()
        }
    ) {

        Icon(
            imageVector = Icons.Default.Translate,
            contentDescription = null
        )
    }

    val wallOfFame = listOf(

        FameMentor(
            1,
            "Maria",
            299,
            "https://randomuser.me/api/portraits/women/68.jpg"
        ),

        FameMentor(
            2,
            "Alina",
            292,
            "https://randomuser.me/api/portraits/women/31.jpg"
        ),

        FameMentor(
            3,
            "Zahra Waseem",
            285,
            "https://randomuser.me/api/portraits/women/79.jpg"
        ),

        FameMentor(
            4,
            "CodeWithHarry",
            270,
            "https://cdn.bio.link/uploads/profile_pictures/2024-02-10/9aYo2a1Is4mh5SdZomJZU16s31IW02g5.png"
        ),

        FameMentor(
            5,
            "Muskan",
            250,
            "https://randomuser.me/api/portraits/women/72.jpg"
        ),

        FameMentor(
            6,
            "Alex The Analyst",
            240,
            "https://yt3.googleusercontent.com/ytc/AIdro_l9wLnClpLKJeVmP5XwHy4NF_Gu13GfyRT1WTZDaSYS-g=s160-c-k-c0x00ffffff-no-rj"
        ),

        FameMentor(
            7,
            "Suhail Sharif",
            225,
            "https://randomuser.me/api/portraits/men/22.jpg"
        )

    )

    val appreciations = if (LanguageManager.isKannada.value) {

        listOf(

            Appreciation(
                "@rahul",
                "\"ಮರಿಯಾ ಮ್ಯಾಡಂ ನನ್ನಿಗೆ ಗಣಿತವನ್ನು ಸುಲಭವಾಗಿ ಕಲಿಸಿದರು.\"",
                "Maria"
            ),

            Appreciation(
                "@sneha",
                "\"ಜಹ್ರಾ ವಸೀಮ್ ಅವರಿಂದ ನಾನು ನನ್ನ ಮೊದಲ DSA ಇಂಟರ್ವ್ಯೂ ಕ್ಲಿಯರ್ ಮಾಡಿದೆ.\"",
                "Zahra Waseem"
            ),

            Appreciation(
                "@anand",
                "\"CodeWithHarry ಸರ್ ನನಗೆ ಪ್ರತಿದಿನ ಕೋಡಿಂಗ್ ಮಾಡಲು ಪ್ರೇರಣೆ ನೀಡಿದರು.\"",
                "CodeWithHarry"
            ),

            Appreciation(
                "@farhan",
                "\"Alex The Analyst ಡೇಟಾ ಅನಾಲಿಟಿಕ್ಸ್ ಅನ್ನು ಸುಲಭವಾಗಿ ವಿವರಿಸಿದರು.\"",
                "Alex The Analyst"
            ),

            Appreciation(
                "@pooja",
                "\"ಮುಸ್ಕಾನ್ ಅಕ್ಕ ತುಂಬಾ ಸಹನೆಯಿಂದ ಕಲಿಸುತ್ತಾರೆ.\"",
                "Muskan"
            ),

            Appreciation(
                "@vijay",
                "\"SQL ಇಷ್ಟು ಸುಲಭ ಅಂತ ನಾನು ಯೋಚಿಸಲಿಲ್ಲ.\"",
                "Alex The Analyst"
            )

        )

    } else {

        listOf(

            Appreciation(
                "@rahul",
                "\"Math used to be scary, but Maria madam made it easy for me.\"",
                "Maria"
            ),

            Appreciation(
                "@sneha",
                "\"I cracked my first DSA interview round because of Zahra Waseem.\"",
                "Zahra Waseem"
            ),

            Appreciation(
                "@anand",
                "\"CodeWithHarry sir motivated me to start coding every day.\"",
                "CodeWithHarry"
            ),

            Appreciation(
                "@farhan",
                "\"Alex The Analyst helped me understand Data Analytics clearly.\"",
                "Alex The Analyst"
            ),

            Appreciation(
                "@pooja",
                "\"Muskan akka teaches with so much patience and kindness.\"",
                "Muskan"
            ),

            Appreciation(
                "@vijay",
                "\"I never thought SQL could be this simple to learn.\"",
                "Alex The Analyst"
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

                Column {

                    Text(
                        text = AppStrings.appName(),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = AppStrings.tagline(),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(
                    onClick = {
                        LanguageManager.toggleLanguage()
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.Translate,
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = AppStrings.wallOfFame(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))
        }

        item {

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                items(wallOfFame) { mentor ->

                    Card(
                        modifier = Modifier
                            .width(190.dp)
                            .height(240.dp),
                        shape = RoundedCornerShape(24.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "#${mentor.rank}",
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Image(
                                painter = rememberAsyncImagePainter(mentor.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(RoundedCornerShape(20.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Text(
                                text = mentor.name,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "● ${mentor.hearts} HEARTS",
                                color = Color(0xFFFFB300),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }

        item {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = AppStrings.appreciationFeed(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))
        }

        items(appreciations) { appreciation ->

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F1F8)
                ),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = appreciation.username,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = appreciation.message
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Guru: ${appreciation.guru}",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}