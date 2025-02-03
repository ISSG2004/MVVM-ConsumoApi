package com.example.mvvm_consumoapi.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_consumoapi.R
import com.example.mvvm_consumoapi.databinding.PeliLayoutBinding
import com.example.mvvm_consumoapi.domain.models.Pelicula
import com.example.mvvm_consumoapi.utils.Constantes
import com.squareup.picasso.Picasso

class PeliculasAdapter(var listaPeliculas: List<Pelicula>,
    private val onItemClick: (String)->Unit
    ):RecyclerView.Adapter<PeliculasAdapter.PeliViewHolder>() {

        class PeliViewHolder(v:View):RecyclerView.ViewHolder(v) {
            private var binding= PeliLayoutBinding.bind(v)
            fun render (pelicula: Pelicula, onItemClick: (String) -> Unit){
                Picasso.get().load(Constantes.URL_IMG+pelicula.imagen).into(binding.ivCaratula)
                binding.circularProgress.apply {
                    maxProgress=Constantes.VAL_MAX
                    setCurrentProgress(pelicula.valoracion.toDouble())
                }
                itemView.setOnClickListener{
                    onItemClick(pelicula.titulo)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.peli_layout,parent,false)
        return PeliViewHolder(vista)
    }

    override fun getItemCount()=listaPeliculas.size

    override fun onBindViewHolder(holder: PeliViewHolder, position: Int) {
        holder.render(listaPeliculas[position],onItemClick)
    }

}