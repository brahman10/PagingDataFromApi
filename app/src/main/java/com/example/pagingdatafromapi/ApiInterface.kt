package com.example.pagingdatafromapi

import com.example.pagingdatafromapi.network.RetrofitSDK
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("answers")
    suspend fun getAnswers(
        @Query("page") page:Int,
        @Query("pagesize") pagesize:Int,
        @Query("site") site:String
        ):Response<StackApiResponse>

    companion object
    {
        fun getApiService() =  RetrofitSDK.Builder().build().service
    }
}