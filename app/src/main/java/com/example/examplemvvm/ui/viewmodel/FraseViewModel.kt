package com.example.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.Frase
import com.example.examplemvvm.data.model.FrasesProvider
import com.example.examplemvvm.domain.GetFraseUseCase
import com.example.examplemvvm.domain.GetRandomFraseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FraseViewModel @Inject constructor(
    private val getFraseUseCase: GetFraseUseCase,
    private val getRandomUseCase: GetRandomFraseUseCase
) : ViewModel() {
    val fraseModel = MutableLiveData<Frase?>()
    val isLoading = MutableLiveData<Boolean>()

    fun create(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getFraseUseCase()
            if (!result.isNullOrEmpty()){
                fraseModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun getFraseRandom(){
        //val currenFrase: Frase = FrasesProvider.getRandomFrase()
        //fraseModel.postValue(currenFrase)
        isLoading.postValue(true)
        val newfrase = getRandomUseCase()
        if (newfrase != null){
            fraseModel.postValue(newfrase)
        }
        isLoading.postValue(false)
    }

}