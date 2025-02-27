package com.example.thesocialnetwork


data class User(
    val fullName: String? = null,
    val profilePicture: String? = null
)

data class Creator(
    val user: User
)

data class Post(
    val id: String,
    val text: String,
    val creator: Creator,
    val type: PostType
)

enum class PostType {
    Text, Image
}