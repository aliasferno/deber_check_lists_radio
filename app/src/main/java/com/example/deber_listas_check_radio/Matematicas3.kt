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
        var cuenta = intent.getIntExtra("cuenta", 0)
        var puntosCorrecto = 2

        val rg: RadioGroup =findViewById(R.id.rgP4) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            cuenta=when(i){
                R.id.rbOpCorrectaP3-> cuenta + puntosCorrecto

                else -> 0
            }
        }

        val btnSiguiente3 = findViewById<Button>(R.id.btnSiguiente3)

        btnSiguiente3.setOnClickListener {
            val m4 = Intent(this, Matematicas4::class.java)
            m4.putExtra("cuenta", cuenta)
            startActivity(m4)
        }
    }
}