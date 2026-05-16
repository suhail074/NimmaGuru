package com.example.nimmaguru.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoleSelectionScreen(

    onStudentClick: () -> Unit,
    onGuruClick: () -> Unit

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(30.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Text(
            text = "Welcome To",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Nimma Guru",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF061A5A)
        )

        Spacer(modifier = Modifier.height(80.dp))

        Button(

            onClick = onStudentClick,

            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),

            shape = RoundedCornerShape(24.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF061A5A)
            )

        ) {

            Text(
                text = "STUDENT",
                fontSize = 28.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(

            onClick = onGuruClick,

            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),

            shape = RoundedCornerShape(24.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFB800)
            )

        ) {

            Text(
                text = "GURU",
                fontSize = 28.sp,
                color = Color.Black
            )
        }
    }
}