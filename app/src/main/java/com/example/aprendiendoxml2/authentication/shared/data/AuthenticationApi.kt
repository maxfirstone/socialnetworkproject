package com.example.aprendiendoxml2.authentication.shared.data

import com.example.aprendiendoxml2.authentication.shared.data.LoginRequest.LoginRequest
import com.example.aprendiendoxml2.authentication.shared.data.LoginResponse.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("api/login")
   suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}