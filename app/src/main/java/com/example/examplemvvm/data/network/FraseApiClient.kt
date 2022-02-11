package com.example.examplemvvm.data.network

import com.example.examplemvvm.data.model.Frase
import retrofit2.Response
import retrofit2.http.GET

interface FraseApiClient {
    @GET("/.json")
    suspend fun getAllFrases(): Response<List<Frase>>
}