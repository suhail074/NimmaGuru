package com.example.nimmaguru.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.icons.filled.Translate
import com.example.nimmaguru.ui.theme.AppStrings
import com.example.nimmaguru.ui.theme.LanguageManager

object LanguageManager {

    val isKannada = mutableStateOf(false)

    fun toggleLanguage() {
        isKannada.value = !isKannada.value
    }
}