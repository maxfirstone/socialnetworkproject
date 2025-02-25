package com.example.aprendiendoxml2.authentication.shared.repository

import com.example.aprendiendoxml2.authentication.shared.AuthenticationModule
import com.example.aprendiendoxml2.authentication.shared.data.AuthenticationApi
import com.example.aprendiendoxml2.authentication.shared.data.LoginRequest.LoginRequest
import com.example.aprendiendoxml2.authentication.shared.repository.domain.AuthRepository

class RemoteAuthRepository(
    private val api: AuthenticationApi = AuthenticationModule.provideAuthenticationApi()
) : AuthRepository {

    override suspend fun login(email: String, password: String): String? {
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