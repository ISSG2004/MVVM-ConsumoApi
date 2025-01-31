package com.example.mvvm_consumoapi.data.repository

import com.example.mvvm_consumoapi.data.net.PeliculasProvider
import com.example.mvvm_consumoapi.domain.models.Pelicula
import com.example.mvvm_consumoapi.utils.Constantes.API_KEY

class PeliculasRepository {
    private val apiService = PeliculasProvider.listadoPeliculasService

    suspend fun getPopulares(): List<Pelicula>{
        return apiService.getPopulares(API_KEY).listadoPeliculas
    }

    suspend fun getCartelera(): List<Pelicula>{
        return apiService.getCartelera(API_KEY).listadoPeliculas
    }
}