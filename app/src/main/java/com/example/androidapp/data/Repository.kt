package com.example.androidapp.data

import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUser(id: Int) = flow {
        try {
            emit(apiService.getUser(id))
        } catch (e: Exception) {
            emit(null)
        }
    }

    suspend fun getPosts() = flow {
        try {
            emit(apiService.getPosts())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}