package com.example.examplemvvm.data

import com.example.examplemvvm.data.model.Frase
import com.example.examplemvvm.data.model.FrasesProvider
import com.example.examplemvvm.data.network.FraseApiClient
import com.example.examplemvvm.data.network.FraseRequestService
import javax.inject.Inject

class FraseRepository @Inject constructor(
    private val api: FraseRequestService,
    private val frasesProvider: FrasesProvider
) {

    suspend fun getAllFrases(): List<Frase>{
        val response =  api.getAllFrases()
        frasesProvider.listOfFrases = response
        return response
    }
}