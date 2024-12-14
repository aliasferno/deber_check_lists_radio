package com.example.deber_listas_check_radio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class SeleccionEvaluaciones : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seleccion_evaluaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val chkMatematicas = findViewById<CheckBox>(R.id.chkMatematicas)
        val chkIngles = findViewById<CheckBox>(R.id.chkIngles)
        val chkInformatica = findViewById<CheckBox>(R.id.chkInformatica)
        val chkHistoria = findViewById<CheckBox>(R.id.chkHistoria)
        val chkDispositivos = findViewById<CheckBox>(R.id.chkDispositivos)
        val btnAvanza = findViewById<Button>(R.id.btnAvanza)
        val username = intent.getStringExtra("username")
        Log.d("recibo username", username.toString())
        val ldm = Intent(this, ListaDeMaterias::class.java)

        chkMatematicas.setOnCheckedChangeListener { compoundButton, isChecked ->
            val mate = chkMatematicas.text.toString()
            ldm.putExtra("mate", mate)
        }
        chkIngles.setOnCheckedChangeListener { compoundButton, isChecked ->
            val ingles = chkIngles.text.toString()
            ldm.putExtra("ingles", ingles)
        }
        chkInformatica.setOnCheckedChangeListener { compoundButton, isChecked ->
            val informatica = chkInformatica.text.toString()
            ldm.putExtra("informatica", informatica)
        }
        chkHistoria.setOnCheckedChangeListener { compoundButton, isChecked ->
            val historia = chkHistoria.text.toString()
            ldm.putExtra("historia", historia)
        }
        chkDispositivos.setOnCheckedChangeListener { compoundButton, isChecked ->
            val dispositivos = chkDispositivos.text.toString()
            ldm.putExtra("dispositivos", dispositivos)
        }

        btnAvanza.setOnClickListener {
            ldm.putExtra("username", username)
            startActivity(ldm)
        }
    }
}