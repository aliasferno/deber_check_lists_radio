package com.example.deber_listas_check_radio

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val username = intent.getStringExtra("user")
        var lblUsername = findViewById<TextView>(R.id.lblUsername)
        val arrayAdapter: ArrayAdapter<*>
        val materias = arrayOf(
            "Matemáticas", "Inglés", "Informática", "Historia del Ecuador", "Dispositivos Móviles", "Resultados Finales"
        )

        var lstMaterias = findViewById<ListView>(R.id.lstMaterias)

        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, materias)

        lstMaterias.adapter = arrayAdapter

        lblUsername.text = username

        lstMaterias.setOnItemClickListener { adapterView, view, position, l ->

            Toast.makeText(this, "onclick " + adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }


    }
}