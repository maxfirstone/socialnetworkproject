package com.example.aprendiendoxml2.authentication.shared.repository.domain

interface AuthRepository {
    suspend fun login(email: String, password: String): String?
}