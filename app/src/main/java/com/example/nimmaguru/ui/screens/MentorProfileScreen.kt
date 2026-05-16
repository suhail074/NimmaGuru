package com.example.nimmaguru.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nimmaguru.ui.theme.ProfileStorage

@Composable
fun MentorProfileScreen() {

    val context = LocalContext.current

    var showDialog by remember {
        mutableStateOf(false)
    }

    var name by remember {
        mutableStateOf(ProfileStorage.getMentorName(context))
    }

    var location by remember {
        mutableStateOf(ProfileStorage.getMentorLocation(context))
    }

    var skill by remember {
        mutableStateOf(ProfileStorage.getMentorSkill(context))
    }

    var time by remember {
        mutableStateOf(ProfileStorage.getMentorTime(context))
    }

    var bio by remember {
        mutableStateOf(ProfileStorage.getMentorBio(context))
    }

    var imageUri by remember {
        mutableStateOf(ProfileStorage.getMentorImage(context))
    }

    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.OpenDocument()
        ) { uri ->

            uri?.let {

                context.contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )

                imageUri = it.toString()

                ProfileStorage.saveMentorImage(
                    context,
                    it.toString()
                )
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
            .padding(bottom = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF7F4FA)
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box {

                    if (imageUri.isNotEmpty()) {

                        Image(
                            painter = rememberAsyncImagePainter(Uri.parse(imageUri)),
                            contentDescription = null,
                            modifier = Modifier
                                .size(205.dp)
                                .clip(CircleShape)
                                .border(
                                    4.dp,
                                    Color.Black,
                                    CircleShape
                                ),
                            contentScale = ContentScale.Crop
                        )

                    } else {

                        Box(
                            modifier = Modifier
                                .size(205.dp)
                                .clip(CircleShape)
                                .border(
                                    4.dp,
                                    Color.Black,
                                    CircleShape
                                )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(x = 6.dp, y = 2.dp)
                            .size(78.dp)
                            .clip(RoundedCornerShape(22.dp))
                            .background(Color(0xFFFFC400))
                            .clickable {
                                showDialog = true
                            },
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = name,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "GURU",
                    color = Color(0xFFFFB800),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            shape = RoundedCornerShape(36.dp),
            border = BorderStroke(3.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF7F4FA)
            )
        ) {

            Column(
                modifier = Modifier.padding(
                    horizontal = 28.dp,
                    vertical = 30.dp
                )
            ) {

                Text(
                    text = "LOCATION",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(28.dp),
                    border = BorderStroke(3.dp, Color.Black),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 22.dp,
                                vertical = 24.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(62.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF5F2F7)),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color(0xFFFFC400),
                                modifier = Modifier.size(34.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(22.dp))

                        Text(
                            text = location,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "SKILL",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(18.dp),
                    border = BorderStroke(2.dp, Color.LightGray)
                ) {

                    Text(
                        text = skill,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "AVAILABLE TIME SLOT",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(28.dp),
                    border = BorderStroke(3.dp, Color.Black),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 22.dp,
                                vertical = 24.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = null,
                            modifier = Modifier.size(34.dp)
                        )

                        Spacer(modifier = Modifier.width(18.dp))

                        Text(
                            text = time,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "BIO",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = bio,
                    color = Color.Gray,
                    fontSize = 18.sp
                )
            }
        }
    }

    if (showDialog) {

        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },

            title = {
                Text("Edit Mentor Profile")
            },

            text = {

                Column {

                    Button(
                        onClick = {
                            launcher.launch(arrayOf("image/*"))
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFC400)
                        )
                    ) {
                        Text("Upload Profile Image")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        label = {
                            Text("Mentor Name")
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = location,
                        onValueChange = {
                            location = it
                        },
                        label = {
                            Text("Location")
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = skill,
                        onValueChange = {
                            skill = it
                        },
                        label = {
                            Text("Skill")
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = time,
                        onValueChange = {
                            time = it
                        },
                        label = {
                            Text("Available Time")
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = bio,
                        onValueChange = {
                            bio = it
                        },
                        label = {
                            Text("Bio")
                        }
                    )
                }
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        ProfileStorage.saveMentorName(context, name)
                        ProfileStorage.saveMentorLocation(context, location)
                        ProfileStorage.saveMentorSkill(context, skill)
                        ProfileStorage.saveMentorTime(context, time)
                        ProfileStorage.saveMentorBio(context, bio)

                        showDialog = false
                    }
                ) {
                    Text("Save")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}