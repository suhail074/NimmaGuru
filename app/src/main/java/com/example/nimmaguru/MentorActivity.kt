package com.example.nimmaguru

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.nimmaguru.ui.screens.CalendarScreen
import com.example.nimmaguru.ui.screens.HomeScreen
import com.example.nimmaguru.ui.screens.MentorProfileScreen
import com.example.nimmaguru.ui.screens.SearchScreen
import com.google.firebase.auth.FirebaseAuth

class MentorActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        FirebaseAuth.getInstance()
            .signInAnonymously()
            .addOnSuccessListener {

                Toast.makeText(
                    this,
                    "Firebase Connected",
                    Toast.LENGTH_LONG
                ).show()

                setContent {

                    var selectedTab by remember {
                        mutableStateOf("home")
                    }

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Box(
                            modifier = Modifier.weight(1f)
                        ) {

                            when (selectedTab) {

                                "home" -> HomeScreen()

                                "search" -> SearchScreen()

                                "calendar" -> CalendarScreen()

                                "profile" -> MentorProfileScreen()
                            }
                        }

                        BottomNavigationBar(
                            selectedTab = selectedTab,
                            onTabSelected = {
                                selectedTab = it
                            }
                        )
                    }
                }
            }

            .addOnFailureListener {

                Toast.makeText(
                    this,
                    "Firebase Failed",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}