package com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName


data class Frase(
    @SerializedName("quote")
    val message: String,
    @SerializedName("author")
    val author: String
    )