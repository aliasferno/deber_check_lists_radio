package com.example.deber_listas_check_radio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Matematicas3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_matematicas3)
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
        Log.d("recibo username", username.toString())

        val rg: RadioGroup =findViewById(R.id.rgP3) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.rbOpCorrectaP3-> {
                    cuenta += puntosCorrecto
                    preguntasCorrectas += 1
                }

                else -> {
                    preguntasIncorrectas += 1
                }
            }
        }

        val btnSiguiente3 = findViewById<Button>(R.id.btnSiguiente3)

        btnSiguiente3.setOnClickListener {
            val m4 = Intent(this, Matematicas4::class.java)
            m4.putExtra("cuenta", cuenta)
            m4.putExtra("preguntasCorrectas", preguntasCorrectas)
            m4.putExtra("preguntasIncorrectas", preguntasIncorrectas)
            m4.putExtra("username", username)
            startActivity(m4)
        }
    }
}