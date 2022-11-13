package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.DbBinding
import com.google.firebase.firestore.FirebaseFirestore

class DBMainActivity : AppCompatActivity() {
    lateinit var binding: DbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /* inicializa base de datos */
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        binding.btnInsertar.setOnClickListener {
            var datos = ""
            db.collection("estilistas") /// esta colecion hace referencia al nombre de la base de base datos "estilistas"
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        datos += "${document.id}:${document.data}\n"
                    }
                    binding.txtConsultar.text = datos
                }

                .addOnFailureListener { exception ->
                    binding.txtConsultar.text = "No se ha podido conectar"
                }
        }
        /* insertar */
        binding.btnInsertar.setOnClickListener {
            val id = binding.etId.text
            val nombre = binding.etNombre.text
            val valor = binding.etValor.text
            val stock = binding.etStock.text
            val activo = binding.etActivo.text
            if (id.isNotBlank() && nombre.isNotBlank() && valor.isNotBlank() && stock.isNotBlank()) {
                val datos = hashMapOf(
                    "nombre" to nombre.toString(),
                    "valor" to valor.toString().toInt(),
                    "stock" to stock.toString().toInt()
                )
                db.collection("estilistas")
                    .document(id.toString()).set(datos)
                    .addOnSuccessListener { result ->
                        binding.txtConsultar.text = "Añadido correctamente"
                    }
                    .addOnFailureListener { exception ->
                        binding.txtConsultar.text = "no se ha podido añadir"
                    }
            }
        }


        //consultar un elemento
        binding.btnMostrar1.setOnClickListener {
            val id = binding.etId.text.toString()
            if (id.isNotBlank()) {
                db.collection("estilistas")
                    .document(id)
                    .get()
                    .addOnSuccessListener {
                        binding.etNombre.setText(it.get("nombre") as String?)
                        binding.etValor.setText(it.get("valor").toString() as String?)
                        binding.etStock.setText(it.get("stock").toString() as String?)
                        binding.etActivo.setText(it.get("activo").toString() as String?)
                    }
                    .addOnFailureListener { exception ->
                        binding.txtConsultar.text = "NO se pudo consultar"
                    }
            } else {
                Toast.makeText(this, "Debe Ingresar un ID", Toast.LENGTH_LONG).show()
            }
        }


        /*eliminar un dato - Estas funciones deben estar en OnCreate*/
        binding.btnEliminar.setOnClickListener {
            val id = binding.etId.text.toString()
            if (id.isNotBlank()) {
                db.collection("estilistas")
                    .document(id)
                    .delete()
                    .addOnSuccessListener {
                        binding.txtConsultar.text = "Elemento eliminado"
                    }
                    .addOnFailureListener { exception ->
                        binding.txtConsultar.text = "No se pudo Eliminar"
                    }
            } else {
                Toast.makeText(this, "Debes ingresar un ID", Toast.LENGTH_LONG).show()
            }

        }
    }
}


