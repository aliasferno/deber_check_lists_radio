package com.example.deber_listas_check_radio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Integer.parseInt

class Matematicas2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_matematicas2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = intent.getStringExtra("username")
        var preguntasCorrectas = intent.getIntExtra("preguntasCorrectas", 0)
        var preguntasIncorrectas = intent.getIntExtra("preguntasIncorrectas", 0)

        var cuenta = intent.getIntExtra("cuenta", 0)
        Log.d(" lo que recibo correctos", cuenta.toString())
        Log.d(" lo que recibo pc", preguntasCorrectas.toString())
        Log.d(" lo que recibo pi", preguntasIncorrectas.toString())
        var puntosCorrecto = 2

        val rg: RadioGroup =findViewById(R.id.rg) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.rbCorrecta-> {
                    cuenta += puntosCorrecto
                    preguntasCorrectas += 1
                }

                else -> {
                    preguntasIncorrectas += 1
                }
            }
        }

        val btnSiguiente2 = findViewById<Button>(R.id.btnSiguiente2)

        btnSiguiente2.setOnClickListener {
            val m3 = Intent(this, Matematicas3::class.java)
            m3.putExtra("cuenta", cuenta)
            m3.putExtra("preguntasCorrectas", preguntasCorrectas)
            m3.putExtra("preguntasIncorrectas", preguntasIncorrectas)
            m3.putExtra("username", username)
            startActivity(m3)
        }
    }
}