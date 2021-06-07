package com.example.pagingdatafromapi.network

import android.app.Application

class ImorphApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        if (InterceptorHTTPClientCreator.okHttpClient == null) {
            InterceptorHTTPClientCreator.createInterceptorHTTPClient()
        }
    }
}