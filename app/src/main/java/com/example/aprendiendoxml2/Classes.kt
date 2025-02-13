package com.example.aprendiendoxml2



data class User(
    val fullName: String? = null,
    val profilePicture: String? = null
)

data class Creator (
    val user: User
)

data class Post(
    val id: String,
    val text: String,
    val creator: Creator
)