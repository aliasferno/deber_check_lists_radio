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

class Ingles1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingles1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = intent.getStringExtra("username")
        Log.d("recibo username", username.toString())
        var cuentaDeIngles = 0;
        var cuentaDePreguntasCorrectasIngles = 0;
        var cuentaDePreguntasIncorrectasIngles = 0;
        val rg: RadioGroup =findViewById(R.id.rgIngles3) as RadioGroup

        rg.setOnCheckedChangeListener { radioGroup, i ->
            when (i){
                R.id.rbOpCorrectaIngles3-> {
                    cuentaDeIngles += 2
                    cuentaDePreguntasCorrectasIngles += 1
                }
                else -> {
                    cuentaDePreguntasIncorrectasIngles += 1
                }
            }
        }

        val btnSiguienteIngles1 = findViewById<Button>(R.id.btnSiguienteIngles1)





        btnSiguienteIngles1.setOnClickListener {
            val i2 = Intent(this, Ingles2::class.java)
            Log.d(" lo que envio correctos", cuentaDeIngles.toString())
            Log.d(" lo que envio pc", cuentaDePreguntasCorrectasIngles.toString())
            i2.putExtra("cuentaIngles", cuentaDeIngles)
            i2.putExtra("preguntasCorrectasIngles", cuentaDePreguntasCorrectasIngles)
            i2.putExtra("preguntasIncorrectasIngles", cuentaDePreguntasIncorrectasIngles)
            i2.putExtra("username", username)
            startActivity(i2)
        }
    }
}