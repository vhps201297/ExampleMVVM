package com.example.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FrasesProvider @Inject constructor(){
    var listOfFrases: List<Frase> = emptyList()
}