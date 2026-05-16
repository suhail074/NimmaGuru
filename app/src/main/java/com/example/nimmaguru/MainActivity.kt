package com.example.nimmaguru

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nimmaguru.ui.screens.RoleSelectionScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            RoleSelectionScreen(

                onStudentClick = {

                    startActivity(
                        Intent(
                            this,
                            StudentActivity::class.java
                        )
                    )
                },

                onGuruClick = {

                    startActivity(
                        Intent(
                            this,
                            MentorActivity::class.java
                        )
                    )
                }
            )
        }
    }
}