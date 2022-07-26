package com.mauriciotogneri.composetest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TodoApi {
    val api: GetTodosEndpoint by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetTodosEndpoint::class.java)
    }
}