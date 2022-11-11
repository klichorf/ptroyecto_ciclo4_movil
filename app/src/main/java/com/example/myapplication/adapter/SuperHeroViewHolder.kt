package com.example.myapplication.reciclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.SuperHero


class SuperHeroViewHolder (view: View):RecyclerView.ViewHolder(view){   //8. realizo la extencion

    private val superHero=view.findViewById<TextView>(R.id.tvsuperheroname) //10.ACCEDO A LAS VISTAS DEL NOMBRE DEL SUPERHERO
    private val realname=view.findViewById<TextView>(R.id.tvrealname)
    private val publisher=view.findViewById<TextView>(R.id.tvpublisher)
    private val photo=view.findViewById<ImageView>(R.id.ivsuperhero)



    fun render (superHeromodel: SuperHero){  //9.recibe un objeto superhero esta funcion se llama por cada uno de los listados
          superHero.text=superHeromodel.superHero  //11. coloco el valor de la variable en el text view
          realname.text=superHeromodel.realName
          publisher.text=superHeromodel.publisher

        Glide.with(photo.context).load(superHeromodel.photo).into(photo)

          //Glide.with(photo.context).load(superHeromodel.photo).into(photo)//12. incliyo la foto luego de instalar la libreria
          //13. voy a maifesta para los permisos

    }

}