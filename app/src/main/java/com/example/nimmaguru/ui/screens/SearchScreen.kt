package com.example.nimmaguru.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nimmaguru.model.Mentor
import com.example.nimmaguru.repository.MentorRepository
import com.example.nimmaguru.ui.theme.AppStrings
import com.example.nimmaguru.ui.theme.LanguageManager

@Composable
fun SearchScreen() {

    val repository = remember {
        MentorRepository()
    }

    var mentorList by remember {
        mutableStateOf<List<Mentor>>(emptyList())
    }

    var searchText by remember {
        mutableStateOf("")
    }

    var selectedSkill by remember {
        mutableStateOf("")
    }

    val isKannada = LanguageManager.isKannada.value

    LaunchedEffect(Unit) {

        repository.getMentors {

            mentorList = it
        }
    }

    val filteredMentors = mentorList.filter {

        val matchesSearch =

            it.name.contains(
                searchText,
                ignoreCase = true
            ) ||

                    it.skill.contains(
                        searchText,
                        ignoreCase = true
                    )

        val matchesSkill =

            selectedSkill.isEmpty() ||

                    it.skill.contains(
                        selectedSkill,
                        ignoreCase = true
                    )

        matchesSearch && matchesSkill
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text =
                    if (isKannada)
                        "ಗುರುಗಳನ್ನು ಹುಡುಕಿ"
                    else
                        "Search Mentors",

                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF111827)
            )

            IconButton(
                onClick = {
                    LanguageManager.toggleLanguage()
                }
            ) {

                Icon(
                    imageVector = Icons.Default.Translate,
                    contentDescription = null,
                    tint = Color(0xFF111827)
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {

                Text(
                    if (isKannada)
                        "ಗುರು ಅಥವಾ ಕೌಶಲ್ಯ ಹುಡುಕಿ"
                    else
                        "Search by name or skill"
                )
            },
            shape = RoundedCornerShape(18.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                if (isKannada)
                    "ಕೌಶಲ್ಯ ಆಧಾರಿತ ಫಿಲ್ಟರ್"
                else
                    "FILTER BY SKILL",

            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E)
        )

        Spacer(modifier = Modifier.height(12.dp))

        val skillList =

            if (isKannada) {

                listOf(
                    "ಗಣಿತ",
                    "ವಿಜ್ಞಾನ",
                    "ಪ್ರೋಗ್ರಾಮಿಂಗ್",
                    "ಇಂಗ್ಲಿಷ್",
                    "ಪೈಥಾನ್",
                    "ಡಿಎಸ್ಎ",
                    "ಎಸ್‌ಕ್ಯೂಎಲ್",
                    "ಪವರ್ ಬಿಐ",
                    "ತೋಟಗಾರಿಕೆ",
                    "ಭೌತಶಾಸ್ತ್ರ",
                    "ಕನ್ನಡ",
                    "ಸಿ/ಸಿ++",
                    "ಡೇಟಾ ವಿಶ್ಲೇಷಣೆ",
                    "ಕೃಷಿ"
                )

            } else {

                listOf(
                    "Math",
                    "Science",
                    "Programming",
                    "English",
                    "Python",
                    "DSA",
                    "SQL",
                    "Power BI",
                    "Gardening",
                    "Physics",
                    "Kannada",
                    "C/C++",
                    "Data Analytics",
                    "Farming"
                )
            }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(skillList) { skill ->

                FilterChip(
                    selected = selectedSkill == skill,
                    onClick = {

                        selectedSkill =
                            if (selectedSkill == skill) {
                                ""
                            } else {
                                skill
                            }
                    },
                    label = {
                        Text(skill)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {

            items(filteredMentors) { mentor ->

                MentorCard(
                    mentor = mentor,
                    isKannada = isKannada
                )
            }
        }
    }
}

@Composable
fun MentorCard(
    mentor: Mentor,
    isKannada: Boolean
) {

    val context = LocalContext.current

    val mentorName = if (isKannada) {

        when (mentor.name) {

            "Maria" -> "ಮಾರಿಯಾ"
            "Alina" -> "ಅಲೀನಾ"
            "Alex The Analyst" -> "ಅಲೆಕ್ಸ್"
            "Prof. Venkatesh Rao" -> "ಪ್ರೊ. ವೆಂಕಟೇಶ್ ರಾವ್"
            "Anjali Sharma" -> "ಅಂಜಲಿ ಶರ್ಮಾ"
            "CodeWithHarry" -> "ಕೋಡ್ ವಿತ್ ಹ್ಯಾರಿ"
            "Dr. Sulochana Devi" -> "ಡಾ. ಸುಲೋಚನಾ ದೇವಿ"
            "Faizan Ahmed" -> "ಫೈಝಾನ್ ಅಹ್ಮದ್"
            "Ganesh" -> "ಗಣೇಶ್"
            "Kaaju Sharma" -> "ಕಾಜು ಶರ್ಮಾ"
            "Master H. Basappa" -> "ಮಾಸ್ಟರ್ ಎಚ್. ಬಸಪ್ಪ"
            "Muskan" -> "ಮುಸ್ಕಾನ್"
            "Physics wallah" -> "ಫಿಸಿಕ್ಸ್ ವಾಲಾ"
            "Prashant Sir" -> "ಪ್ರಶಾಂತ್ ಸರ್"
            "Ramesh Gowda" -> "ರಮೇಶ್ ಗೌಡ"
            "Suhail Sharif" -> "ಸುಹೈಲ್ ಶರೀಫ್"
            "Zahra Waseem" -> "ಜಹ್ರಾ ವಸೀಂ"
            "khan Sir" -> "ಖಾನ್ ಸರ್"
            "BOB" -> "ಬಾಬ್"

            else -> mentor.name
        }

    } else {
        mentor.name
    }

    val mentorLocation = if (isKannada) {

        when (mentor.location) {

            "Bangalore" -> "ಬೆಂಗಳೂರು"
            "Mysuru" -> "ಮೈಸೂರು"
            "Shravanabelagola" -> "ಶ್ರವಣಬೆಳಗೊಳ"
            "United States" -> "ಅಮೇರಿಕಾ"
            "Mandya" -> "ಮಂಡ್ಯ"
            "Delhi" -> "ದೆಹಲಿ"
            "Tumkur" -> "ತುಮಕೂರು"
            "Pune" -> "ಪುಣೆ"
            "Hassan" -> "ಹಾಸನ"
            "Mangalore" -> "ಮಂಗಳೂರು"
            "Ramanagara" -> "ರಾಮನಗರ"
            "Magadi" -> "ಮಾಗಡಿ"
            "Kadapa" -> "ಕಡಪ"
            "chnnaptna" -> "ಚನ್ನಪಟ್ಟಣ"

            else -> mentor.location
        }

    } else {
        mentor.location
    }

    val mentorSkill = if (isKannada) {

        when (mentor.skill.lowercase()) {

            "python" -> "ಪೈಥಾನ್"
            "power bi" -> "ಪವರ್ ಬಿಐ"
            "english" -> "ಇಂಗ್ಲಿಷ್"
            "mathematics" -> "ಗಣಿತ"
            "math" -> "ಗಣಿತ"
            "science" -> "ವಿಜ್ಞಾನ"
            "physics" -> "ಭೌತಶಾಸ್ತ್ರ"
            "programming" -> "ಪ್ರೋಗ್ರಾಮಿಂಗ್"
            "graphic design" -> "ಗ್ರಾಫಿಕ್ ಡಿಸೈನ್"
            "gardening" -> "ತೋಟಗಾರಿಕೆ"
            "tailoring" -> "ಹೊಲಿಗೆ"
            "kannada" -> "ಕನ್ನಡ"
            "sql" -> "ಎಸ್‌ಕ್ಯೂಎಲ್"
            "java" -> "ಜಾವಾ"
            "farming" -> "ಕೃಷಿ"
            "c/c++" -> "ಸಿ/ಸಿ++"
            "html/css/js" -> "ಎಚ್‌ಟಿಎಂಎಲ್/ಸಿಎಸ್‌ಎಸ್/ಜೆಎಸ್"

            else -> mentor.skill
        }

    } else {
        mentor.skill
    }

    val mentorBio = if (isKannada) {

        when (mentor.name) {

            "Maria" ->
                "AI ಮಾರ್ಗದರ್ಶಕಿ"

            "Prof. Venkatesh Rao" ->
                "ಗ್ರಾಮದ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಸಹಾಯ ಮಾಡುವ ನಿವೃತ್ತ ಕನ್ನಡ ಶಿಕ್ಷಕರು."

            "Alex The Analyst" ->
                "ಪೂರ್ಣಕಾಲಿಕ ಡೇಟಾ ಅನಾಲಿಟಿಕ್ಸ್ ಬೋಧನೆ"

            "Alina" ->
                "ಡ್ಯಾಶ್‌ಬೋರ್ಡ್ ರಚನೆ ಬೋಧನೆ"

            "Anjali Sharma" ->
                "ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಸಂವಹನ ಕೌಶಲ್ಯ ಕಲಿಸುತ್ತಿದ್ದಾರೆ"

            "CodeWithHarry" ->
                "ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಕೋಡಿಂಗ್ ಕಲಿಸುತ್ತಿದ್ದಾರೆ"

            "Dr. Sulochana Devi" ->
                "ಗ್ರಾಮೀಣ ಮಕ್ಕಳಿಗೆ ಮಾರ್ಗದರ್ಶನ ನೀಡುತ್ತಿರುವ ನಿವೃತ್ತ ಗಣಿತ ಪ್ರಾಧ್ಯಾಪಕಿ"

            "Faizan Ahmed" ->
                "Canva ಮತ್ತು Photoshop ಬೋಧನೆ"

            "Ganesh" ->
                "ಆಧುನಿಕ ಮತ್ತು ಹಳೆ ಕನ್ನಡ ಬೋಧನೆ"

            "Kaaju Sharma" ->
                "ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಡ್ಯಾಶ್‌ಬೋರ್ಡ್ ನಿರ್ಮಾಣ ಕಲಿಸುತ್ತಿದ್ದಾರೆ"

            "Master H. Basappa" ->
                "ಸಾವಯವ ಕೃಷಿ ಮತ್ತು ತೋಟಗಾರಿಕೆ ತಜ್ಞ"

            "Muskan" ->
                "ಪೂರ್ಣಕಾಲಿಕ ಜಾವಾ ಡೆವಲಪರ್"

            "Physics wallah" ->
                "1 ಗಂಟೆಯಲ್ಲಿ ಭೌತಶಾಸ್ತ್ರ"

            "Prashant Sir" ->
                "ವೆಬ್ ಡೆವಲಪ್‌ಮೆಂಟ್ ಬೋಧನೆ"

            "Ramesh Gowda" ->
                "ಪ್ರಾರಂಭಿಕರಿಗೆ ಕೋಡಿಂಗ್ ಬೋಧನೆ"

            "Suhail Sharif" ->
                "ಡೇಟಾ ಸ್ಟ್ರಕ್ಚರ್ಸ್ ಮತ್ತು ಅಲ್ಗಾರಿದಮ್ ಬೋಧನೆ"

            "Zahra Waseem" ->
                "Google ಉದ್ಯೋಗ ತರಬೇತಿ"

            "khan Sir" ->
                "ಫಿಟ್ನೆಸ್ ಮತ್ತು ವಿಜ್ಞಾನ ತರಬೇತಿ"

            "BOB" ->
                "ಪೂರ್ಣಕಾಲಿಕ ರೈತ"

            else ->
                mentor.bio
        }

    } else {
        mentor.bio
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F3FA)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Image(
                painter = rememberAsyncImagePainter(
                    mentor.imageUrl
                ),

                contentDescription = null,

                modifier = Modifier
                    .size(92.dp)
                    .clip(RoundedCornerShape(22.dp)),

                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = 170.dp),

                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column {

                    Text(
                        text = mentorName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = mentorLocation,
                            color = Color.Gray,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = mentorSkill,
                        color = Color(0xFF1A237E),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = mentor.availability,
                        color = Color(0xFF00897B),
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = mentorBio,
                        color = Color.DarkGray,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        color = Color(0xFFE8EAF6)
                    ) {

                        Text(
                            text = mentor.experience,

                            modifier = Modifier.padding(
                                horizontal = 14.dp,
                                vertical = 6.dp
                            ),

                            color = Color(0xFF3949AB),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFDFF5E1)
                    ) {

                        IconButton(
                            onClick = {

                                val intent = Intent(
                                    Intent.ACTION_DIAL,
                                    Uri.parse("tel:${mentor.phone}")
                                )

                                context.startActivity(intent)
                            }
                        ) {

                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = null,
                                tint = Color(0xFF1B5E20)
                            )
                        }
                    }
                }
            }
        }
    }
}