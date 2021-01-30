package com.example.mvvm_pattern.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_pattern.data.repository.MainRepository
import com.example.mvvm_pattern.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getMeals(query : Map<String, String>) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getMeals(query)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "something_wrong"))
        }
    }
}