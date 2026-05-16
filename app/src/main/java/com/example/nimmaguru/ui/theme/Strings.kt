package com.example.nimmaguru.ui.theme

import androidx.compose.material.icons.filled.Translate
import com.example.nimmaguru.ui.theme.AppStrings
import com.example.nimmaguru.ui.theme.LanguageManager

object AppStrings {

    fun appName() =
        if (LanguageManager.isKannada.value)
            "ನಿಮ್ಮ-ಗುರು"
        else
            "Nimma-Guru"

    fun tagline() =
        if (LanguageManager.isKannada.value)
            "ಗ್ರಾಮಗಳಿಗೆ ಸಮುದಾಯ ಮಾರ್ಗದರ್ಶನ"
        else
            "COMMUNITY MENTORSHIP FOR VILLAGES"

    fun wallOfFame() =
        if (LanguageManager.isKannada.value)
            "ಕೀರ್ತಿ ಗೋಡೆ"
        else
            "Wall of Fame"

    fun appreciationFeed() =
        if (LanguageManager.isKannada.value)
            "ಮೆಚ್ಚುಗೆಯ ಫೀಡ್"
        else
            "Appreciation Feed"

    fun searchMentors() =
        if (LanguageManager.isKannada.value)
            "ಗುರುಗಳನ್ನು ಹುಡುಕಿ"
        else
            "Search Mentors"

    fun searchHint() =
        if (LanguageManager.isKannada.value)
            "ಗುರು ಅಥವಾ ಕೌಶಲ್ಯ ಹುಡುಕಿ..."
        else
            "Search by name or skill"

    fun filterBySkill() =
        if (LanguageManager.isKannada.value)
            "ಕೌಶಲ್ಯ ಆಧಾರಿತ ಫಿಲ್ಟರ್"
        else
            "FILTER BY SKILL"

    fun nearbyGurus() =
        if (LanguageManager.isKannada.value)
            "ಹತ್ತಿರದ ಗುರುಗಳು"
        else
            "NEARBY GURUS"

    fun upcomingSessions() =
        if (LanguageManager.isKannada.value)
            "ಮುಂಬರುವ ತರಗತಿಗಳು"
        else
            "Upcoming Sessions"

    fun saveChanges() =
        if (LanguageManager.isKannada.value)
            "ಬದಲಾವಣೆ ಉಳಿಸಿ"
        else
            "SAVE CHANGES"

    fun student() =
        if (LanguageManager.isKannada.value)
            "ವಿದ್ಯಾರ್ಥಿ"
        else
            "STUDENT"

    fun guru() =
        if (LanguageManager.isKannada.value)
            "ಗುರು"
        else
            "GURU"

    fun location() =
        if (LanguageManager.isKannada.value)
            "ಸ್ಥಳ"
        else
            "LOCATION"

    fun learningJourney() =
        if (LanguageManager.isKannada.value)
            "ಕಲಿಕೆಯ ಪಯಣ"
        else
            "LEARNING JOURNEY"

    fun completed() =
        if (LanguageManager.isKannada.value)
            "ಪೂರ್ಣಗೊಂಡಿದೆ"
        else
            "COMPLETED"

    fun savedSuccessfully() =
        if (LanguageManager.isKannada.value)
            "ಯಶಸ್ವಿಯಾಗಿ ಉಳಿಸಲಾಗಿದೆ"
        else
            "Saved Successfully"

    fun home() =
        if (LanguageManager.isKannada.value)
            "ಮುಖಪುಟ"
        else
            "Home"

    fun search() =
        if (LanguageManager.isKannada.value)
            "ಹುಡುಕಿ"
        else
            "Search"

    fun calendar() =
        if (LanguageManager.isKannada.value)
            "ಕ್ಯಾಲೆಂಡರ್"
        else
            "Calendar"

    fun profile() =
        if (LanguageManager.isKannada.value)
            "ಪ್ರೊಫೈಲ್"
        else
            "Profile"

    fun today() =
        if (LanguageManager.isKannada.value)
            "ಇಂದು"
        else
            "Today"

    fun upcoming() =
        if (LanguageManager.isKannada.value)
            "ಮುಂಬರುವ"
        else
            "Upcoming"

    fun completedStatus() =
        if (LanguageManager.isKannada.value)
            "ಪೂರ್ಣಗೊಂಡ"
        else
            "Completed"

    fun sessions() =
        if (LanguageManager.isKannada.value)
            "2 ತರಗತಿಗಳು"
        else
            "2 Sessions"
}