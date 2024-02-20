package com.sample.catapp.di

import com.sample.catapp.dispatcher.AppCoroutineDispatcher
import com.sample.catapp.dispatcher.AppCoroutineDispatcherImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DispatcherModule {

    @Provides
    fun provideCoroutineDispatcher(): AppCoroutineDispatcher {
        return AppCoroutineDispatcherImpl()
    }
}
