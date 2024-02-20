package com.sample.catapp.catdetails.presentation

import com.sample.catdetails.CatItem

sealed class CatIntents {
    object FetchCatList : CatIntents()
    data class SelectCat(val obj: CatItem) : CatIntents()
}
