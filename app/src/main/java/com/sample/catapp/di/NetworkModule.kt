package com.sample.catapp.di

import com.sample.catapp.network.ApiService
import com.sample.catapp.utils.BASE_URL
import com.sample.catapp.utils.CONNECT_TIMEOUT_IN_SECONDS
import com.sample.catapp.utils.READ_TIMEOUT_IN_SECONDS
import com.sample.catapp.utils.WRITE_TIMEOUT_IN_SECONDS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS) // Connection timeout
            .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS) // Read timeout
            .writeTimeout(WRITE_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS) // Write timeout
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
