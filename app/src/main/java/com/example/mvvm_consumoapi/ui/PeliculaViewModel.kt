package com.example.mvvm_consumoapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_consumoapi.data.repository.PeliculasRepository
import com.example.mvvm_consumoapi.domain.models.Pelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeliculaViewModel:ViewModel() {
    private val repository = PeliculasRepository()
    private val _listadoPelis= MutableLiveData<List<Pelicula>>()
    val listadoPelis:LiveData<List<Pelicula>> = _listadoPelis

    fun traerPopulares(){
        viewModelScope.launch(Dispatchers.IO){ //lanzamos la funcion para traernos los datos de la API. SE lanza en un hilo secundario
            val datos = repository.getPopulares()
            _listadoPelis.postValue(datos)

        }
        fun traerCartelera(){
            viewModelScope.launch(Dispatchers.IO){
                val datos = repository.getCartelera()
                _listadoPelis.postValue(datos)

            }
        }
    }
}