package com.sample.catdetails.states

import androidx.compose.runtime.Stable
import com.sample.catdetails.CatItem


sealed interface CatUiState {
    val isLoading: Boolean
    val errorMessage: String?
    val isError: Boolean

    data class NoCatData(
        override val isLoading: Boolean,
        override val errorMessage: String?,
        override val isError: Boolean
    ) : CatUiState

    @Stable
    data class CatData(
        val data: List<CatItem> = emptyList(),
        override val isLoading: Boolean,
        override val errorMessage: String?,
        override val isError: Boolean

    ) : CatUiState
}