package com.sample.catapp.catdetails.presentation.viewmodel

import com.sample.catdetails.CatItem
import com.sample.catdetails.states.CatUiState

data class CatViewModelState(
    val data: List<CatItem> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
) {
    fun toUiState(): CatUiState {
        if (data.isEmpty()) {
            return CatUiState.NoCatData(
                isLoading = isLoading,
                isError = isError,
                errorMessage = errorMessage
            )
        }
        return CatUiState.CatData(
            data = data,
            isLoading = isLoading,
            errorMessage = errorMessage,
            isError = isError
        )

    }

}
