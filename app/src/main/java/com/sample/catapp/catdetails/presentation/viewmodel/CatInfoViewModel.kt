package com.sample.catapp.catdetails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.catdetails.CatItem
import com.sample.catapp.catdetails.data.network.NetworkResult
import com.sample.catapp.catdetails.presentation.CatBreedMapper
import com.sample.catapp.catdetails.domain.usecase.FetchListUseCase
import com.sample.catapp.catdetails.presentation.CatIntents
import com.sample.catapp.dispatcher.AppCoroutineDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class CatInfoViewModel @Inject constructor(
    private val dispatcher: AppCoroutineDispatcher,
    private val fetchListUseCase: FetchListUseCase
) : ViewModel() {

    @VisibleForTesting
    var pageNo = 0
    private val _state = MutableStateFlow(CatViewModelState())

    val uiState = _state
        .map(CatViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            _state.value.toUiState()
        )

    private val _stateUiCartItem = MutableStateFlow<CatItem?>(null)
    val catDetailsState: StateFlow<CatItem?> = _stateUiCartItem


    init {
        _state.update {
            _state.value.copy(isLoading = true, isError = false)
        }
        fireIntent(CatIntents.FetchCatList)
    }


    fun fireIntent(catDetailsIntent: CatIntents) {
        when (catDetailsIntent) {
            is CatIntents.FetchCatList -> {
                fetchCatList()
            }

            is CatIntents.SelectCat -> {
                _stateUiCartItem.value = catDetailsIntent.obj
            }

        }

    }

    @VisibleForTesting
    fun fetchCatList() {
        viewModelScope.launch(dispatcher.io) {
            val data =
                fetchListUseCase.invoke(pageNo = pageNo, order = order, pageLimit = PAGE_SIZE)
            setLoadingFalse()
            when (data) {
                is NetworkResult.Success -> {
                    _state.update {
                        _state.value.copy(data = CatBreedMapper.mapToUiCatItems(data.data))
                    }
                }

                is NetworkResult.Error -> {
                    _state.update {
                        _state.value.copy(isError = true, errorMessage = it.errorMessage)
                    }
                }

                is NetworkResult.Exception -> {
                    _state.update {
                        _state.value.copy(isError = true, errorMessage = it.errorMessage)
                    }
                }
            }
        }
    }

    @VisibleForTesting
    fun setLoadingFalse() {
        _state.update {
            _state.value.copy(isLoading = false)
        }
    }

    companion object {
        @VisibleForTesting
        const val PAGE_SIZE = 20

        @VisibleForTesting
        const val order = "DESC"
    }
}
