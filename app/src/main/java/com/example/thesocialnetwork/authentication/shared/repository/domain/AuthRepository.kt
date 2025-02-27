package com.example.thesocialnetwork.authentication.shared.repository.domain

interface AuthRepository {
    suspend fun login(email: String, password: String): String?
}