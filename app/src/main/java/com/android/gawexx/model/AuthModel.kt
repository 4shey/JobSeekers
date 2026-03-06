package com.android.gawexx.model

data class LoginRequestModel (
    val email: String,
    val password: String
)
data class LoginResponseModel (
    val id: Int,
    val profilePicture: String,
    val fullname: String,
    val email: String,
    val phoneNumber: String,
    val role: String,
)
data class RegisterModel (
    val fullname: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val confirmPassword: String,
)