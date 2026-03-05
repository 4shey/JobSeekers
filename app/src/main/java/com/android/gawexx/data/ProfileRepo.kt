package com.android.gawexx.data

import com.android.gawexx.helper.BASE_URL
import com.android.gawexx.model.ProfileModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

object ProfileRepo {
    suspend fun getProfile(): ProfileModel? = withContext(Dispatchers.IO){
        try{
            val url = URL("${BASE_URL}/me")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()
            val response = connection.inputStream.bufferedReader().readText()
            println(response)

            val json = JSONObject(response)
            val data = json.getJSONObject("data")

            ProfileModel(
                id = data.getInt("id"),
                fullname = data.getString("fullname"),
                email = data.getString("email"),
                phoneNumber = data.getString("phoneNumber"),
                profilePicture = data.getString("profilePicture"),
                role = data.getString("role"),
            )
        }catch (e: Exception) {
            println("failed...")
            e.printStackTrace()
            null
        }
    }
}