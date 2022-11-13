package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.reciclerview.adapter.SuperHeroAdapter


class MainActivity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listado)

        //SuperHeroProver.listaservicios// Tengo Acceso a toda el lista
        inicireciclerview()  //12- llamamos al iniciar recicler con todos los parametros
    }

    private fun inicireciclerview() {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerSuperhero)
        recyclerview.layoutManager =
            LinearLayoutManager(this) // codigo necesario para configurar el contenido de cada item
        recyclerview.adapter = SuperHeroAdapter(SuperHeroProver.listaservicios)

    }


}