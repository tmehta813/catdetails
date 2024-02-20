package com.sample.catapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.catapp.catdetails.presentation.view.CatDetails
import com.sample.catapp.catdetails.presentation.view.CatList
import com.sample.catapp.catdetails.presentation.viewmodel.CatInfoViewModel

@Composable
fun CatAppEntryScreenApp() {
    val navController = rememberNavController()
    val viewModel: CatInfoViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = CatsDestinations.CATS_ROUTE
    ) {
        composable(CatsDestinations.CATS_ROUTE) {
            CatList(navController, viewModel)
        }
        composable(CatsDestinations.CAT_DETAIL_ROUTE) {
            CatDetails(navController, viewModel)
        }
    }
}
