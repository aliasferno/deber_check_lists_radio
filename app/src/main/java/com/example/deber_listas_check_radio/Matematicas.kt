package com.example.deber_listas_check_radio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Matematicas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_matematicas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var cuentaDeCorrectos = 0;
        val rg:RadioGroup=findViewById(R.id.rg) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            cuentaDeCorrectos=when(i){
                R.id.rbOpUno->cuentaDeCorrectos+2

                else -> 0
            }
        }

        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)

        btnSiguiente.setOnClickListener {
            val m2 = Intent(this, Matematicas2::class.java)
            m2.putExtra("cuenta", cuentaDeCorrectos)
            startActivity(m2)
        }
    }
}