package com.example.examplemvvm.domain

import com.example.examplemvvm.data.FraseRepository
import com.example.examplemvvm.data.model.Frase
import com.example.examplemvvm.data.model.FrasesProvider
import javax.inject.Inject

class GetRandomFraseUseCase @Inject constructor(
    private val repository: FraseRepository,
    private val frasesProvider: FrasesProvider
){

    operator fun invoke(): Frase?{
        val listFrases = frasesProvider.listOfFrases
        if (!listFrases.isNullOrEmpty()){
            val numRandom = (listFrases.indices).random()
            return listFrases[numRandom]
        }
        return null
    }
}