package com.quiroga.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.quiroga.androidmaster.firstApp.FirstAppActivity
import com.quiroga.androidmaster.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val btnSaludapp = findViewById<Button>(R.id.btnSaludapp)

        val btnIMCapp = findViewById<Button>(R.id.btnIMCapp)

        btnSaludapp.setOnClickListener { navegateSaludapp() }
        btnIMCapp.setOnClickListener { navegatoIMCapp() }


    }

    // FUNCIÓN PARA LLEVAR A LA APP DE IMC
    private fun navegatoIMCapp() {

        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }


    //FUNCIÓN PARA IR A LA SECCIÓN DE ESCRIBIR NOMBRE
    private fun navegateSaludapp(){

        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}