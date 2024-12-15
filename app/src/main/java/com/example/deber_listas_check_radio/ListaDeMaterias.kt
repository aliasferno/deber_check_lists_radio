package com.example.deber_listas_check_radio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class ListaDeMaterias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_de_materias)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra("username")
        val lblUsername = findViewById<TextView>(R.id.lblUsername)
        val arrayAdapter: ArrayAdapter<*>
        val mate = intent.getStringExtra("mate")
        val ingles = intent.getStringExtra("ingles")
        val informatica = intent.getStringExtra("informatica")
        val historia = intent.getStringExtra("historia")
        val dispositivos = intent.getStringExtra("dispositivos")
        Log.d("recibo username", username.toString())

        var lstMaterias = findViewById<ListView>(R.id.lstMaterias)

        var materias = arrayOf(mate, ingles, informatica, historia, dispositivos).filterNotNull().toTypedArray()

        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, materias)

        lstMaterias.adapter = arrayAdapter

        lblUsername.text = username

        lstMaterias.setOnItemClickListener { adapterView, view, position, l ->

            val elementoSeleccionado = adapterView.getItemAtPosition(position).toString()

            Log.d("elemento seleccionado", elementoSeleccionado)

            if(elementoSeleccionado == "Matemáticas"){
                val actMatematicas = Intent(this, Matematicas::class.java)
                actMatematicas.putExtra("username", username)
                startActivity(actMatematicas)
            }
            if(elementoSeleccionado == "Inglés"){
                val actIngles = Intent(this, Ingles1::class.java)
                actIngles.putExtra("username", username)
                startActivity(actIngles)
            }
        }


    }
}