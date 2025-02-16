package com.example.aprendiendoxml2.authentication.shared.repository

import com.example.aprendiendoxml2.authentication.shared.AuthenticationModule
import com.example.aprendiendoxml2.authentication.shared.data.AuthenticationApi
import com.example.aprendiendoxml2.authentication.shared.data.LoginRequest.LoginRequest

class AuthRepository(
    private val api: AuthenticationApi = AuthenticationModule.provideAuthenticationApi()
) {
    suspend fun login(
        email: String,
        password: String
    ): String? {
        val loginRequest = LoginRequest(email, password)
        return try {
            val response = api.login(loginRequest)
            response.token
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

}