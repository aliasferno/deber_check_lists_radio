package com.example.deber_listas_check_radio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MatematicasFinal : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_matematicas_final)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra("username")
        var preguntasCorrectas = intent.getIntExtra("preguntasCorrectas", 0)
        var preguntasIncorrectas = intent.getIntExtra("preguntasIncorrectas", 0)

        var cuenta = intent.getIntExtra("cuenta", 0)

        val lblUsername = findViewById<TextView>(R.id.lblUsernameMatematicasFinal)
        val lblPreguntasCorrectas = findViewById<TextView>(R.id.lblCuentaPreguntasCorrectas)
        val lblPreguntasIncorrectas = findViewById<TextView>(R.id.lblCuentaPreguntasIncorrectas)
        val lblNotaFinal = findViewById<TextView>(R.id.lblNotaFinal)
        val btnRegresa = findViewById<Button>(R.id.btnRegresarMatematicasFinal)

        lblUsername.text = username
        lblPreguntasCorrectas.text = preguntasCorrectas.toString()
        lblPreguntasIncorrectas.text = preguntasIncorrectas.toString()
        lblNotaFinal.text = cuenta.toString()

        btnRegresa.setOnClickListener {
            val sel = Intent(this, SeleccionEvaluaciones::class.java)
            sel.putExtra("notaMatematicas", cuenta)
            startActivity(sel)
        }
    }
}