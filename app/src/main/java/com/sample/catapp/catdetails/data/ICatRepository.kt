package com.sample.catapp.catdetails.data

import com.sample.catapp.catdetails.data.network.ApiResponse
import com.sample.catapp.catdetails.data.network.NetworkResult

interface ICatRepository {
    suspend fun fetchCatData(
        pageNo: Int,
        order: String,
        pageLimit: Int
    ): NetworkResult<List<ApiResponse>>
}
