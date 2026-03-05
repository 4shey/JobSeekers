package com.android.gawexx.feature.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gawexx.data.JobRepo
import com.android.gawexx.model.JobApplyModel
import com.android.gawexx.model.JobModel
import kotlinx.coroutines.launch

class ExploreViewModel: ViewModel() {

    var search by mutableStateOf("")
    var job by mutableStateOf<List<JobModel?>>(emptyList())

    fun getJob(){
        viewModelScope.launch {
            job = JobRepo.getJob()
        }
    }
    fun updateSearch(newVal:String){
        search = newVal
    }
}