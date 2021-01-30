package com.example.mvvm_pattern.data.repository

import com.example.mvvm_pattern.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getMeals(query: Map<String, String>) = apiHelper.getMeals(query);
}