package com.sample.catapp.catdetails.domain.usecase

import com.sample.catapp.catdetails.data.ICatRepository
import javax.inject.Inject

class FetchListUseCase @Inject constructor(private val repository: ICatRepository) {

    suspend operator fun invoke(pageNo: Int, order: String, pageLimit: Int) =
        repository.fetchCatData(pageNo, order, pageLimit)

}
