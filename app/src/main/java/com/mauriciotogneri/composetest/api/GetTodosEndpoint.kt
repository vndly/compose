package com.mauriciotogneri.composetest.api

import retrofit2.Response
import retrofit2.http.GET

interface GetTodosEndpoint {
    @GET("/todos")
    suspend fun call(): Response<List<Todo>>
}