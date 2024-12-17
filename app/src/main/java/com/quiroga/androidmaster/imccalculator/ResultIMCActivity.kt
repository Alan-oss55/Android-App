package com.quiroga.androidmaster.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.quiroga.androidmaster.R
import com.quiroga.androidmaster.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescripcion:TextView
    private lateinit var btnRecalcular:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        initUI(result)
        initBottonListener()
    }

    private fun initBottonListener() {
        btnRecalcular.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {

        tvIMC.text = result.toString()

        when(result){
            in 0.00..18.50->{
                tvResult.text = getString(R.string.title_peso_bajo)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescripcion.text = getString(R.string.descripcion_peso_bajo)
            }
            in 18.51..24.99->{
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescripcion.text = getString(R.string.descripcion_peso_normal)
            }
            in 25.00..29.99->{
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescripcion.text = getString(R.string.descripcion_sobrepeso)
            }
            in 30.00..99.00->{
                tvResult.text = getString(R.string.obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_obesidad))
                tvDescripcion.text = getString(R.string.descripcion_obesidad)
            }
            else->{
                tvIMC.text = getString(R.string.title_error)
                tvResult.text = getString(R.string.imc_error)
                tvDescripcion.text = getString(R.string.descripcion_error)
            }
        }

    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        btnRecalcular = findViewById(R.id.btnRecalcular)
    }
}