package com.example.aprendiendoxml2.authentication.shared

import com.example.aprendiendoxml2.authentication.shared.data.AuthenticationApi
import com.example.aprendiendoxml2.networking.NetworkingModule

object AuthenticationModule {

    private val retrofit = NetworkingModule.provideRetrofit()

    fun provideAuthenticationApi(): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }
}