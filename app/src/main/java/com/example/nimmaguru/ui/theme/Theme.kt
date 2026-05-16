package com.example.nimmaguru.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(

    primary = Color(0xFF2563EB),
    secondary = Color(0xFF10B981),

    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),

    onPrimary = Color.White,
    onBackground = Color(0xFF111827),
    onSurface = Color(0xFF111827)

)

@Composable
fun NimmaGuruTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}