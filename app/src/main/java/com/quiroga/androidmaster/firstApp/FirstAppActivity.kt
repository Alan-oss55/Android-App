package com.quiroga.androidmaster.firstApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

import com.quiroga.androidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnStar = findViewById<AppCompatButton>(R.id.btnStart)

        val etName = findViewById<AppCompatEditText>(R.id.etName)




        btnStar.setOnClickListener{

            val name  = etName.text.toString()

            if (name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("EXTRA_NAME", name)

                startActivity(intent)
            }
        }
    }

}