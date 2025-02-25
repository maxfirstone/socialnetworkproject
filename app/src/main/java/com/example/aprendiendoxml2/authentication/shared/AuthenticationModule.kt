package com.example.aprendiendoxml2.authentication.shared

import com.example.aprendiendoxml2.BuildConfig
import com.example.aprendiendoxml2.authentication.shared.data.AuthenticationApi
import com.example.aprendiendoxml2.authentication.shared.repository.RemoteAuthRepository
import com.example.aprendiendoxml2.authentication.shared.repository.domain.AuthRepository
import com.example.aprendiendoxml2.networking.NetworkingModule


object AuthenticationModule {

    private val retrofit = NetworkingModule.provideRetrofit()

    fun provideAuthenticationApi(): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }

    fun provideRepository(): AuthRepository {
        if (BuildConfig.DEBUG) {
            return MockAuthRepository()
        } else {
            return RemoteAuthRepository()
        }
   }
}