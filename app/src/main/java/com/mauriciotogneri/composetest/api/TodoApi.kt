package com.mauriciotogneri.composetest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TodoApi {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    val getTodos: GetTodosEndpoint by lazy {
        service(GetTodosEndpoint::class.java)
    }

    private fun <T> service(service: Class<T>): T =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service)
}