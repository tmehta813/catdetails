package com.sample.catdetails.view.catlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sample.catdetails.CatItem
import com.sample.catdetails.R
import com.sample.catdetails.states.CatUiState
import com.sample.catdetails.view.common.AppTopBar
import com.sample.catdetails.view.common.CustomProgressBar

@Composable
fun ListOfCats(
    uiState: CatUiState,
    onItemClick: (CatItem) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is CatUiState.NoCatData -> {
                if (uiState.isLoading) {
                    CustomProgressBar()
                } else {
                    Text(
                        text = uiState.errorMessage
                            ?: stringResource(id = R.string.no_data_available)
                    )
                }
            }

            is CatUiState.CatData -> {
                if (uiState.isLoading && uiState.data.isEmpty()) {
                    CustomProgressBar()
                } else {
                    Column(modifier = Modifier.fillMaxSize()) {
                        // AppTopBar
                        AppTopBar(
                            text = stringResource(id = R.string.cat_list),
                            isBackButtonRequired = false,
                            onBackClicked = { }
                        )
                        CatList(modifier = Modifier.fillMaxSize(), 2, uiState.data, onItemClick)
                    }
                }
            }
        }
    }
}

@Composable
fun CatList(
    modifier: Modifier,
    gridCell: Int = 2,
    catItems: List<CatItem>,
    onItemClick: (CatItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCell),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(items = catItems, key = { it.id }) { catItem ->
            CatItemCard(
                catItem = catItem,
                onItemClick = onItemClick
            )
        }
    }
}
