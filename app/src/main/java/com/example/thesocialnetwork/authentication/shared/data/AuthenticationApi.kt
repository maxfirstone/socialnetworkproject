package com.example.thesocialnetwork.authentication.shared.data

import com.example.thesocialnetwork.authentication.shared.data.LoginRequest.LoginRequest
import com.example.thesocialnetwork.authentication.shared.data.LoginResponse.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("api/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}