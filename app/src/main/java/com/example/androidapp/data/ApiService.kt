package com.example.androidapp.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): UserResponse

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>
}

data class UserResponse(
    val id: Int,
    val name: String,
    val email: String
)

data class PostResponse(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)