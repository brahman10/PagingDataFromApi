package com.example.pagingdatafromapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AnswerViewModelFactory(private val apiService: ApiInterface) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnswerViewModel::class.java)) {
            return AnswerViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}