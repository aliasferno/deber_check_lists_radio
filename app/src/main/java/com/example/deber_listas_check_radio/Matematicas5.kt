package com.example.deber_listas_check_radio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Matematicas5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_matematicas5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = intent.getStringExtra("username")
        var preguntasCorrectas = intent.getIntExtra("preguntasCorrectas", 0)
        var preguntasIncorrectas = intent.getIntExtra("preguntasIncorrectas", 0)

        var cuenta = intent.getIntExtra("cuenta", 0)
        var puntosCorrecto = 2

        val rg: RadioGroup =findViewById(R.id.rgP5) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.rbOpCorrectaP5-> {
                    cuenta += puntosCorrecto
                    preguntasCorrectas += 1
                }

                else -> {
                    preguntasIncorrectas += 1
                }
            }
        }

        val btnFinalizarMatematica5 = findViewById<Button>(R.id.btnFinalizarMatematica5)

        btnFinalizarMatematica5.setOnClickListener {
            val mf = Intent(this, MatematicasFinal::class.java)
            mf.putExtra("cuenta", cuenta)
            mf.putExtra("preguntasCorrectas", preguntasCorrectas)
            mf.putExtra("preguntasIncorrectas", preguntasIncorrectas)
            mf.putExtra("username", username)
            startActivity(mf)
        }
    }
}