package com.example.mvvm_pattern.data.model

import com.google.gson.annotations.SerializedName

data class BaseReponse<T>(
    @SerializedName("meals")
    val meals: T
)