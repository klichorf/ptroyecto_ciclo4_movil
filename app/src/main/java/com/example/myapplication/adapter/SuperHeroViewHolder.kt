package com.example.myapplication.reciclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.Servicios

//import com.example.myapplication.SuperHero  ***********modificación


class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {   //8. realizo la extencion

    private val Servicios =
        view.findViewById<TextView>(R.id.tvsuperheroname) //10.ACCEDO A LAS VISTAS DEL NOMBRE DEL SUPERHERO
    private val profesional = view.findViewById<TextView>(R.id.tvrealname)
    private val línea = view.findViewById<TextView>(R.id.tvpublisher)
    private val tarjeta_presentación = view.findViewById<ImageView>(R.id.ivsuperhero)


    fun render(superHeromodel: Servicios) {  //9.recibe un objeto superhero esta funcion se llama por cada uno de los listados
        Servicios.text =
            superHeromodel.servicios  //11. coloco el valor de la variable en el text view
        línea.text = superHeromodel.línea
        profesional.text = superHeromodel.profesional

        Glide.with(tarjeta_presentación.context).load(superHeromodel.tarjeta_presentación)
            .into(tarjeta_presentación)  // revisar

        //Glide.with(photo.context).load(superHeromodel.photo).into(photo)//12. incliyo la foto luego de instalar la libreria
        //13. voy a maifesta para los permisos

    }

}