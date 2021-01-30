package com.example.mvvm_pattern.data.model

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    val idMeal: String,
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String,
    @SerializedName("strInstructions")
    val strInstructions: String
)