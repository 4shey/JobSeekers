package com.android.gawexx.feature.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gawexx.data.JobRepo
import com.android.gawexx.helper.BASE_URL
import com.android.gawexx.model.JobApplyModel
import com.android.gawexx.model.JobModel
import kotlinx.coroutines.launch

class ExploreViewModel: ViewModel() {

    var search by mutableStateOf("")
    var location by mutableStateOf("")
    var job by mutableStateOf<List<JobModel?>>(emptyList())
    var baseUrl by mutableStateOf("${BASE_URL}/jobs")
    var url by mutableStateOf(baseUrl)
    var loading by mutableStateOf(false)

    fun getJob(){
        loading = true
        viewModelScope.launch {
            job = JobRepo.getJob(url)
            loading = false
        }
    }
    fun updateSearch(newVal:String){
        search = newVal
        search()
    }
    fun search(){
        if(search.trim() != "" && location != ""){
            url = "${baseUrl}?search=${search.trim()}&location=${location}"
        }else if(search.trim() != ""){
            url = "${baseUrl}?search=${search.trim()}"
        } else if(location != ""){
            url = "${baseUrl}?location=${location}"
        } else{
            url = baseUrl
        }
        getJob()
    }
}