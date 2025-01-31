package com.example.mvvm_consumoapi.data.net

import com.example.mvvm_consumoapi.domain.models.PeliculasLista
import com.example.mvvm_consumoapi.utils.Constantes.URL_CARTELERA
import com.example.mvvm_consumoapi.utils.Constantes.URL_POPULARES
import retrofit2.http.GET
import retrofit2.http.Query

interface PeliculaInterfaz {
    @GET(URL_POPULARES)
    suspend fun getPopulares(@Query("api_key") api: String): PeliculasLista

    @GET(URL_CARTELERA)
    suspend fun getCartelera(@Query("api_key") api: String): PeliculasLista
}