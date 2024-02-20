package com.sample.catapp.di

import com.sample.catapp.catdetails.data.CatRepository
import com.sample.catapp.catdetails.data.ICatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface RepoModules {
    @Binds
    fun bindICatRepo(catRepository: CatRepository): ICatRepository
}
