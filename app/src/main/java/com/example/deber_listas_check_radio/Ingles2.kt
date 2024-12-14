package com.example.deber_listas_check_radio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ingles2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingles2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = intent.getStringExtra("username")
        Log.d("recibo username", username.toString())
        var cuentaDeIngles = intent.getStringExtra("cuentaIngles")
        var cuentaDePreguntasCorrectasIngles = intent.getStringExtra("preguntasCorrectasIngles");
        var cuentaDePreguntasIncorrectasIngles = intent.getStringExtra("preguntasIncorrectasIngles");
        val rg: RadioGroup =findViewById(R.id.rgIngles3) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            when (i){
                R.id.rbOpDosIngles3-> {
                    cuentaDeIngles += 2
                    cuentaDePreguntasCorrectasIngles += 1
                }
                else -> {
                    cuentaDePreguntasIncorrectasIngles += 1
                }
            }
        }

        val btnSiguienteIngles2 = findViewById<Button>(R.id.btnSiguienteIngles2)





        btnSiguienteIngles2.setOnClickListener {
            val i3 = Intent(this, Ingles3::class.java)
            Log.d(" lo que envio correctos", cuentaDeIngles.toString())
            Log.d(" lo que envio pc", cuentaDePreguntasCorrectasIngles.toString())
            i3.putExtra("cuentaIngles", cuentaDeIngles)
            i3.putExtra("preguntasCorrectasIngles", cuentaDePreguntasCorrectasIngles)
            i3.putExtra("preguntasIncorrectasIngles", cuentaDePreguntasIncorrectasIngles)
            i3.putExtra("username", username)
            startActivity(i3)
        }
    }
}