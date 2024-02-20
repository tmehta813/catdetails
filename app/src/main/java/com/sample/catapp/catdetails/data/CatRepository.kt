package com.sample.catapp.catdetails.data

import com.sample.catapp.catdetails.data.network.ApiResponse
import com.sample.catapp.catdetails.data.network.NetworkResult
import com.sample.catapp.catdetails.data.network.handleApi
import com.sample.catapp.network.ApiService
import com.sample.catapp.utils.CAT_API_KEY
import javax.inject.Inject


class CatRepository @Inject constructor(private val apiService: ApiService) : ICatRepository {

    override suspend fun fetchCatData(
        pageNo: Int,
        order: String,
        pageLimit: Int
    ): NetworkResult<List<ApiResponse>> {
        return handleApi {
            apiService.fetchData(
                apiKey = CAT_API_KEY
            )
        }
    }
}





