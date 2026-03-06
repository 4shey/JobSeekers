package com.android.gawexx.feature.login

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gawexx.data.AuthRepo
import com.android.gawexx.helper.AppState
import com.android.gawexx.helper.Screen
import com.android.gawexx.model.LoginRequestModel
import com.android.gawexx.model.LoginResponseModel
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    var loginResponse by mutableStateOf<LoginResponseModel?>(null)
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun updateEmail(newEmail:String){
        email = newEmail
    }
    fun updatePassword(newPassword:String){
        password = newPassword
    }
    fun login(context: Context){
        viewModelScope.launch {
            loginResponse = AuthRepo.login(
                LoginRequestModel(
                    email = email,
                    password = password
                )
            )
            if(loginResponse != null){
                AppState.currentScreen.value = Screen.EXPLORE
                AppState.saveLogin(context, true)
            }
        }
    }
}