package com.example.pagingdatafromapi.network

import com.example.pagingdatafromapi.network.InterceptorHTTPClientCreator.Companion.okHttpClient
import com.example.pagingdatafromapi.ApiInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.stackexchange.com/2.2/"

class RetrofitSDK(private val retrofit: Retrofit) {

    var service: ApiInterface? = null
        private set

    /**
     * Builder for [RetrofitSDK]
     */
    class Builder {
        /**
         * Create the [RetrofitSDK] to be used.
         *
         * @return [RetrofitSDK]
         */
        fun build(): RetrofitSDK {
            var retrofit: Retrofit? = null

            if (okHttpClient != null) {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .baseUrl(BASE_URL)
                        .build()
                return RetrofitSDK(retrofit)
            } else {
                val httpClient = OkHttpClient.Builder()
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .baseUrl(BASE_URL)
                        .build()
            }
            return RetrofitSDK(retrofit)
        }
    }

    private fun createService() {
        service = retrofit.create(ApiInterface::class.java)
    }

    init {
        createService()
    }
}