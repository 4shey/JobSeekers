package com.android.gawexx.componen

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.android.gawexx.helper.AppState
import com.android.gawexx.helper.Screen

@Composable
fun BottomBar(){
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = AppState.currentScreen.value == Screen.EXPLORE,
            onClick = { AppState.currentScreen.value = Screen.EXPLORE },
            label = { Text("Explore", fontWeight = FontWeight.Bold) },
            icon = {
                //
            },
        )
        NavigationBarItem(
            selected = AppState.currentScreen.value == Screen.MYJOB,
            onClick = { AppState.currentScreen.value = Screen.MYJOB },
            label = { Text("My Job", fontWeight = FontWeight.Bold) },
            icon = {
                //
            },
        )
        NavigationBarItem(
            selected = AppState.currentScreen.value == Screen.PROFILE,
            onClick = { AppState.currentScreen.value = Screen.PROFILE },
            label = { Text("Profile", fontWeight = FontWeight.Bold) },
            icon = {
                //
            },
        )
    }
}