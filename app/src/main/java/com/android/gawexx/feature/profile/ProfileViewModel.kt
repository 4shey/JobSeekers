package com.android.gawexx.feature.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gawexx.data.ProfileRepo
import com.android.gawexx.model.ProfileModel
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    var profile by mutableStateOf<ProfileModel?>(null)
    fun getProfile(){
        viewModelScope.launch {
            profile = ProfileRepo.getProfile()
        }
    }
}