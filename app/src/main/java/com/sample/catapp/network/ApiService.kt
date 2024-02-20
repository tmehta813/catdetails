package com.sample.catapp.network

import com.sample.catapp.catdetails.data.network.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("breeds")
    suspend fun fetchData(
        @Header("x-api-key") apiKey: String,
    ): Response<List<ApiResponse>>
}
