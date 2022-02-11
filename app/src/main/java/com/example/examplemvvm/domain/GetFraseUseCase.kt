package com.example.examplemvvm.domain

import com.example.examplemvvm.data.FraseRepository
import com.example.examplemvvm.data.model.Frase
import javax.inject.Inject

class GetFraseUseCase @Inject constructor(
    private val repository: FraseRepository
){
    suspend operator fun invoke(): List<Frase>? = repository.getAllFrases()
}