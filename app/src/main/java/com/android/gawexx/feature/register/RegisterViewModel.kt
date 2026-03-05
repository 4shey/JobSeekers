package com.android.gawexx.feature.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class RegisterViewModel {

    var fullName by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun updateFName(newVal:String){
        fullName = newVal
    }
    fun updatePNumber(newVal:String){
        phoneNumber = newVal
    }
    fun updateCPassword(newVal:String){
        confirmPassword = newVal
    }
    fun updateEmail(newVal:String){
        email = newVal
    }
    fun updatePassword(newVal:String){
        password = newVal
    }
}