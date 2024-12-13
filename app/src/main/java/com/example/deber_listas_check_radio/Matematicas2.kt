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

        var cuenta = intent.getIntExtra("cuenta", 0)
        Log.d("lo que traigo", cuenta.toString())
        var puntosCorrecto = 2

        val rg: RadioGroup =findViewById(R.id.rg) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            cuenta=when(i){
                R.id.rbCorrecta-> cuenta + puntosCorrecto

                else -> 0
            }
        }

        val btnSiguiente2 = findViewById<Button>(R.id.btnSiguiente2)

        btnSiguiente2.setOnClickListener {
            Toast.makeText(applicationContext, cuenta.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}