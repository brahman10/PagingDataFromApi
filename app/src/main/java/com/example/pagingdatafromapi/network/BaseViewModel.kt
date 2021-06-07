package com.example.pagingdatafromapi.network

import androidx.lifecycle.ViewModel
import com.example.pagingdatafromapi.network.RetrofitSDK

open class BaseViewModel:ViewModel() {
    val apiServiceInterface = RetrofitSDK.Builder().build().service
}