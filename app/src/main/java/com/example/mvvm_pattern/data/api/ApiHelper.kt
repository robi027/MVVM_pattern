package com.example.mvvm_pattern.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getMeals(query: Map<String, String>) = apiService.getMeals(query = query)
}