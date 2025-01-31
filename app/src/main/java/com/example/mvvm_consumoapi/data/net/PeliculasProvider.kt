package com.example.mvvm_consumoapi.data.net

import com.example.mvvm_consumoapi.utils.Constantes.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PeliculasProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val listadoPeliculasService = retrofit.create(PeliculaInterfaz::class.java)
}