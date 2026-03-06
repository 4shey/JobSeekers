package com.android.gawexx.data

import com.android.gawexx.helper.BASE_URL
import com.android.gawexx.model.LoginRequestModel
import com.android.gawexx.model.LoginResponseModel
import com.android.gawexx.model.RegisterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

object AuthRepo {
    suspend fun login(request: LoginRequestModel): LoginResponseModel? = withContext(Dispatchers.IO){
        try {
            val url = URL("${BASE_URL}/auth")
            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            val jsonBody = JSONObject().apply {
                put("email", request.email)
                put("password", request.password)
            }

            connection.outputStream.write(jsonBody.toString().toByteArray())

            val response = connection.inputStream.bufferedReader().readText()
            println(response)

            val json = JSONObject(response)
            val data = json.getJSONObject("data")

            LoginResponseModel(
                id = data.getInt("id"),
                profilePicture = data.getString("profilePicture"),
                fullname = data.getString("fullname"),
                email = data.getString("email"),
                phoneNumber = data.getString("phoneNumber"),
                role = data.getString("role")
            )

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    suspend fun register(request: RegisterModel): String? = withContext(Dispatchers.IO){
        try {
            val url = URL("${BASE_URL}/register")
            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            val jsonBody = JSONObject().apply {
                put("fullName", request.fullname)
                put("email", request.email)
                put("phoneNumber", request.phoneNumber)
                put("password", request.password)
                put("confirmPassword", request.confirmPassword)
            }

            connection.outputStream.write(jsonBody.toString().toByteArray())
            val responseCode = connection.responseCode

            val response = if (responseCode in 200..299) {
                connection.inputStream.bufferedReader().readText()
            } else {
                connection.errorStream.bufferedReader().readText()
            }
            println(response)
            val json = JSONObject(response)
            json.getString("message")
        } catch (e: Exception) {
            e.printStackTrace()
            "Network Error"
        }
    }
}