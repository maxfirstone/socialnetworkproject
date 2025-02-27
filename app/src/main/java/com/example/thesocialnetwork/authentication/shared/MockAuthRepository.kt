package com.example.thesocialnetwork.authentication.shared

import com.example.thesocialnetwork.authentication.shared.repository.domain.AuthRepository

class MockAuthRepository : AuthRepository {

    private val mockUsers = mapOf(
        "nitofleita@hotmail.com" to "123456",
        "maxfleita@hotmail.com" to "000001",
        "hernan@hotmail.com" to "123456"
    )

    override suspend fun login(email: String, password: String): String? {
        if (mockUsers.containsKey(email)) {
            if (mockUsers[email] == password) {
                return "Token: MOCK_TOKEN : $email"
            }
        }
        return null
    }
}
