package com.sample.catapp.catdetails.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.sample.catdetails.view.catdetails.DetailsOfCat
import com.sample.catdetails.view.catlist.ListOfCats
import com.sample.catapp.CatsDestinations
import com.sample.catapp.catdetails.presentation.CatIntents
import com.sample.catapp.catdetails.presentation.viewmodel.CatInfoViewModel

@Composable
fun CatList(navController: NavHostController, viewModel: CatInfoViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ListOfCats(uiState = uiState, onItemClick = {
        viewModel.fireIntent(CatIntents.SelectCat(it))
        navController.navigate(CatsDestinations.CAT_DETAIL_ROUTE)
    })
}

@Composable
fun CatDetails(navController: NavHostController, viewModel: CatInfoViewModel) {
    val detailsState by viewModel.catDetailsState.collectAsStateWithLifecycle()
    detailsState?.let {
        DetailsOfCat(it) {
            navController.popBackStack()
        }
    }
}
