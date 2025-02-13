package com.example.aprendiendoxml2.authentication.shared.repository

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): String? {
        val jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("password", password)

        val jsonBody = jsonObject.toString()

        // val body = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}"

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://reqres.in/api/login")
            .header("Content-Type", "application/json")
            .method("POST", jsonBody.toRequestBody())
            .build()

        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val body = response.body?.string()
                val json = JSONObject(body)
                return json.getString("token")
            } else {
                return null
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            return null
        }

    }


}