package com.android.gawexx.helper

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

enum class Screen{
    LOGIN,
    REGISTER,
    EXPLORE,
    MYJOB,
    JOBDETAIL,
    PROFILE
}

object AppState{
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.LOGIN)
    val dataStore: MutableState<MutableMap<String, Any?>> = mutableStateOf(mutableMapOf())

    fun saveLogin(context: Context, value: Boolean) {
        val pref = context.getSharedPreferences("app", Context.MODE_PRIVATE)
        pref.edit().putBoolean("isLogin", value).apply()
    }

    fun isLogin(context: Context): Boolean {
        val pref = context.getSharedPreferences("app", Context.MODE_PRIVATE)
        return pref.getBoolean("isLogin", false)
    }
}