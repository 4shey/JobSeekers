package com.android.gawexx.feature.myjob

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gawexx.data.JobRepo
import com.android.gawexx.helper.AppState
import com.android.gawexx.model.JobApplyModel
import kotlinx.coroutines.launch

class MyJobViewModel: ViewModel() {
    var jobApply by mutableStateOf<List<JobApplyModel?>>(emptyList())

    fun getJobApply(){
        viewModelScope.launch {
            jobApply = JobRepo.getJobApply()
        }
    }
    fun applyJob(id: Int){
        viewModelScope.launch {
            val result = JobRepo.applyJob(id)
            if(result != null){
                AppState.showSnackbar(result)
            }
        }
    }
}