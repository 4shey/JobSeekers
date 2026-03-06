package com.android.gawexx.data

import com.android.gawexx.helper.BASE_URL
import com.android.gawexx.model.CompanyModel
import com.android.gawexx.model.JobApplyModel
import com.android.gawexx.model.JobModel
import com.android.gawexx.model.ProfileModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

object JobRepo {
    suspend fun getJobApply(): List<JobApplyModel?> = withContext(Dispatchers.IO){
        try{
            val url = URL("${BASE_URL}/job-applications")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()
            val response = connection.inputStream.bufferedReader().readText()
            println(response)

            val json = JSONObject(response)
            val data = json.getJSONArray("data")
            val jobApply =mutableListOf<JobApplyModel>()
            for(i in 0 until data.length()){
                val obj = data.getJSONObject(i)
                val job = obj.getJSONObject("job")
                val company = job.getJSONObject("company")

                jobApply.add(
                    JobApplyModel(
                        id = obj.getInt("id"),
                        applicationDate = obj.getString("applicationDate"),
                        job = JobModel(
                            id = job.getInt("id"),
                            name = job.getString("name"),
                            locationType = job.getString("locationType"),
                            locationRegion = job.getString("locationRegion"),
                            yearOfExperience = job.getString("yearOfExperience"),
                            quota = job.getInt("quota"),
                            company = CompanyModel(
                                name = company.getString("name")
                            )
                        )
                    )
                )
            }
            jobApply
        }catch (e: Exception) {
            println("failed...")
            e.printStackTrace()
            emptyList<JobApplyModel>()
        }
    }
    suspend fun getJob(
        url: String
    ): List<JobModel?> = withContext(Dispatchers.IO){
        try{
            val url = URL("${url}")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()
            val response = connection.inputStream.bufferedReader().readText()
            println(response)

            val json = JSONObject(response)
            val data = json.getJSONArray("data")
            val job =mutableListOf<JobModel>()
            for(i in 0 until data.length()){
                val obj = data.getJSONObject(i)
                val company = obj.getJSONObject("company")

                job.add(
                    JobModel(
                        id = obj.getInt("id"),
                        name = obj.getString("name"),
                        locationType = obj.getString("locationType"),
                        locationRegion = obj.getString("locationRegion"),
                        yearOfExperience = obj.getString("yearOfExperience"),
                        quota = obj.getInt("quota"),
                        company = CompanyModel(
                            name = company.getString("name")
                        )
                    )
                )
            }
            job
        }catch (e: Exception) {
            println("failed...")
            e.printStackTrace()
            emptyList<JobModel>()
        }
    }
}