package com.example.nimmaguru

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nimmaguru.ui.theme.AppStrings
import androidx.compose.material.icons.filled.Translate
import com.example.nimmaguru.ui.theme.LanguageManager

@Composable
fun BottomNavigationBar(
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 14.dp),

        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        BottomItem(
            icon = {
                Icon(Icons.Outlined.Home, null)
            },
            label = AppStrings.home(),
            selected = selectedTab == "home"
        ) {
            onTabSelected("home")
        }

        BottomItem(
            icon = {
                Icon(Icons.Outlined.Search, null)
            },
            label = AppStrings.search(),
            selected = selectedTab == "search"
        ) {
            onTabSelected("search")
        }

        BottomItem(
            icon = {
                Icon(Icons.Outlined.CalendarMonth, null)
            },
            label = AppStrings.calendar(),
            selected = selectedTab == "calendar"
        ) {
            onTabSelected("calendar")
        }

        BottomItem(
            icon = {
                Icon(Icons.Outlined.Person, null)
            },
            label = AppStrings.profile(),
            selected = selectedTab == "profile"
        ) {
            onTabSelected("profile")
        }
    }
}

@Composable
fun BottomItem(
    icon: @Composable () -> Unit,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onClick()
        }
    ) {

        icon()

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color =
                if (selected)
                    Color(0xFF0A1B66)
                else
                    Color.Gray
        )
    }
}