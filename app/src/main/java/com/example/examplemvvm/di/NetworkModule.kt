package com.example.examplemvvm.di

import com.example.examplemvvm.data.network.FraseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): FraseApiClient{
        return retrofit.create(FraseApiClient::class.java)
    }
}