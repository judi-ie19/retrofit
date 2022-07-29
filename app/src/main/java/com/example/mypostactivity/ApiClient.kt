package com.example.mypostactivity

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T>  buildApiClient(ApiInterface: Class<T>): T{
        return retrofit.create(ApiInterface)
    }

}

