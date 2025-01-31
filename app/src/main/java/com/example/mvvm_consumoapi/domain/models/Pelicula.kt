package com.example.mvvm_consumoapi.domain.models

import com.google.gson.annotations.SerializedName

data class Pelicula(
    @SerializedName("poster_path") val imagen: String,
    @SerializedName("title") val titulo: String,
    @SerializedName("vote_average") val valoracion : Double,

)