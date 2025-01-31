package com.example.mvvm_consumoapi.domain.models

import com.google.gson.annotations.SerializedName

data class PeliculasLista(
    @SerializedName("results") val listadoPeliculas: List<Pelicula>
)