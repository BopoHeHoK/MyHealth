package com.test.myhealth.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: MyHealthAPI by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.45.130:5000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyHealthAPI::class.java)
    }
}