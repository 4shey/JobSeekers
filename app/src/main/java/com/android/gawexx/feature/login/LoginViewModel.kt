package com.android.gawexx.feature.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LoginViewModel {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun updateEmail(newEmail:String){
        email = newEmail
    }
    fun updatePassword(newPassword:String){
        password = newPassword
    }
}