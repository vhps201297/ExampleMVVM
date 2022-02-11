package com.example.examplemvvm.data.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.Frase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FraseRequestService @Inject constructor(
    private val api: FraseApiClient
){

    suspend fun getAllFrases(): List<Frase>{
        return withContext(Dispatchers.IO){
            val response = api.getAllFrases()
            response.body() ?: emptyList()
        }

    }
}