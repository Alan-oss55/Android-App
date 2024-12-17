package com.quiroga.androidmaster.firstApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.quiroga.androidmaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        val tvResults = findViewById<TextView>(R.id.tvResults)

        val name :String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        tvResults.text =  "Hola $name"
    }
}