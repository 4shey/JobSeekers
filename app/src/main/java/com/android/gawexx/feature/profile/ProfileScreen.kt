package com.android.gawexx.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.gawexx.componen.BottomBar
import com.android.gawexx.helper.AppState
import com.android.gawexx.helper.BASE_IMAGE_URL
import com.android.gawexx.helper.BASE_URL
import com.android.gawexx.helper.Screen
import com.android.gawexx.helper.imageUrl

@Composable
fun ProfileScreen(viewModel: ProfileViewModel){

    LaunchedEffect(Unit) {
        viewModel.getProfile()
    }
    val profile = viewModel.profile

    Scaffold(
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            if(profile == null){
                Text("Data not found")
            }
            else{
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    imageUrl("${BASE_IMAGE_URL}/${profile.profilePicture}")
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        profile.fullname,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        profile.email,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        profile.phoneNumber,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp),
            ) {
                Text(
                    "Educations",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    "Feature to be added soon...",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "Experiences",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    "Feature to be added soon...",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "Skills and Interests",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    "Feature to be added soon...",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                val context = LocalContext.current
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        AppState.currentScreen.value = Screen.LOGIN
                        AppState.saveLogin(context, false)
                    }
                ) {
                    Text("Logout")
                }
            }
        }
    }
}