package com.example.myapplication.reciclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.myapplication.R
import com.example.myapplication.SuperHero
import com.example.myapplication.reciclerview.adapter.SuperHeroViewHolder


class SuperHeroAdapter(private val superherolist: List<SuperHero>) :
    RecyclerView.Adapter<SuperHeroViewHolder>() { //Implementr metodos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        /// 7. pinta los items o pinta el layout...creamos el proyecyo O EL LAYAOU QUE SE INSERTARA EN CADA CASILLA
        val layoutInflater =
            LayoutInflater.from(parent.context)  // en este caso el contexto proviene de una vista "parent" que es del view group
        return SuperHeroViewHolder(
            layoutInflater.inflate(
                R.layout.item_superhero,
                parent,
                false
            )
        )//retorna el layout que creamos
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        //12. el bind salte colocando el render en cada uno de ellos

        val item = superherolist[position]
        holder.render(item)              //voy  para main activity
    }

    override fun getItemCount(): Int = superherolist.size  //provee el numero de items al recicler
        // me devuelve el tamaño de la lista
    
    /*
    class HeroHolder(val view:View):RecyclerView.ViewHolder(view){
        fun evento (superHeromodel: SuperHero){

            view.setOnClickListener{Toast.makeText(view.context,"Seleccion de ${SuperHero.su}",Toast.LENGTH_LONG )}
    }

     */

}