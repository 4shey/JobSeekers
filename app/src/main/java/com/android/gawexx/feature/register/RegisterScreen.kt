package com.android.gawexx.feature.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.gawexx.helper.AppState
import com.android.gawexx.helper.Screen

@Composable
fun RegisterScreen(viewModel: RegisterViewModel){
    //
    Column(
        modifier = Modifier.padding(vertical = 50.dp, horizontal = 20.dp).verticalScroll(
            rememberScrollState()
        )
    ) {
        Text(
            "Gawe-an",
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        //
        Text(
            "Full Name",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        OutlinedTextField(
            value = viewModel.fullName,
            onValueChange = {
                viewModel.updateFName(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        //
        Text(
            "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = {
                viewModel.updateEmail(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        //
        Text(
            "Phone Number",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        OutlinedTextField(
            value = viewModel.phoneNumber,
            onValueChange = {
                viewModel.updatePNumber(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        //
        Text(
            "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        //
        Text(
            "Confirm Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        OutlinedTextField(
            value = viewModel.confirmPassword,
            onValueChange = {
                viewModel.updateCPassword(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                onClick = {
                    //
                }
            ) {
                Text("Register")
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row() {
            Text(
                "Already have an account?  ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray
            )
            Text(
                "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.clickable{
                    AppState.currentScreen.value = Screen.LOGIN
                }
            )
        }
    }
}