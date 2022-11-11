package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.reciclerview.adapter.SuperHeroAdapter


class
MainActivity : AppCompatActivity() {

    private var editTxtUSR: EditText? = null // declaración de variables para recibir usuario
    private var editTextPassword: EditText? =
        null // declaración de variables para recibir contraseña

    private lateinit var binding: ActivityMainBinding
    //la utilizacion del Binding para referencias de vistas o actividades//


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTxtUSR.setOnClickListener { usuario_toast() }

        editTxtUSR = findViewById(R.id.editTxtUSR) // concatenación parte grafica con lógica
        editTextPassword = findViewById(R.id.editTextPassword)


    }


    fun getAndShowName() {

        val bundle = intent.extras
        val name = bundle?.get("HOLA_MUNDO")
    }


    fun login(btnentrar: View) {

        // validaciones con credenciales
        if (editTxtUSR!!.text.toString() == "hello" && editTextPassword!!.text.toString() == "k") {

            val nombre_variable = Intent(this, MainActivity2::class.java)
            startActivity(nombre_variable)

        } else {
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()


        }

    }


    fun actividaddos(botondos: View) {
        val objeto3 = Intent(this, MainActivity2::class.java)
        startActivity(objeto3)
    }

    fun regist(btnnewuser: View) {
        val objeto = Intent(this, Formulario::class.java)
        startActivity(objeto)
    }


    fun usuario_toast() {

        Toast.makeText(this, "ingrese usuario", Toast.LENGTH_SHORT).show()
    }


}
