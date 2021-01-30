package com.example.mvvm_pattern.data.api

import com.example.mvvm_pattern.data.model.BaseReponse
import com.example.mvvm_pattern.data.model.Meal
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET("search.php")
    suspend fun getMeals(@QueryMap query: Map<String, String>): BaseReponse<List<Meal>>
}