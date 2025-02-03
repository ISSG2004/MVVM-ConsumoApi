package com.example.mvvm_consumoapi.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_consumoapi.R
import com.example.mvvm_consumoapi.databinding.ActivityMainBinding
import com.example.mvvm_consumoapi.ui.adapters.PeliculasAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pelisViewModel: PeliculaViewModel by viewModels()
    private val adapter= PeliculasAdapter(listOf()){titulo->mostrarTitulos(titulo)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        pelisViewModel.listadoPelis.observe(this){
            adapter.actualizarPeliculas(it)
        }
        setListeners()
        setAdapter()
    }

    private fun setAdapter() {
        val layoutManager = GridLayoutManager(this,2)
        binding.recyclerPelis.layoutManager=layoutManager
        binding.recyclerPelis.adapter=adapter
    }


    private fun setListeners() {
        binding.btnPopulares.setOnClickListener {
            pelisViewModel.traerPopulares()
        }
        binding.btnCartelera.setOnClickListener{
            pelisViewModel.traerCartelera()
        }
    }

    private fun mostrarTitulos(titulo:String){
        Toast.makeText(this,titulo,Toast.LENGTH_SHORT).show()
    }
}