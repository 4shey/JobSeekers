package com.android.gawexx.feature.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gawexx.data.AuthRepo
import com.android.gawexx.model.RegisterModel
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {

    var fullName by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var loading by mutableStateOf(false)

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
    fun register(){
        loading = true
        viewModelScope.launch {
            AuthRepo.register(
                RegisterModel(
                    fullname = fullName,
                    email = email,
                    phoneNumber = phoneNumber,
                    password = password,
                    confirmPassword = confirmPassword,
                )
            )
            loading = false
        }
    }
}