package com.quiroga.androidmaster.imccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.quiroga.androidmaster.R


class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelecte = true
    private var isFemaleSelected = false

    private var currentWeigth: Int = 70
    private var currentAge: Int = 20
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHright: TextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculator: Button

    companion object{
        const val IMC_KEY = "IMC_REULT"
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)



        iniComponents()
        initListener()
        initUI()

    }


    //    FUNCIÓN PARA INICIALIZAR LAS CARDVIEWS
    private fun iniComponents() {
        viewMale = findViewById<CardView>(R.id.cardMale)
        viewFemale = findViewById<CardView>(R.id.cardFemale)
        rsHeight = findViewById<RangeSlider>(R.id.rgHeight)
        tvHright = findViewById<TextView>(R.id.tvHright)

        btnSubtractWeight = findViewById<FloatingActionButton>(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById<FloatingActionButton>(R.id.btnPlusWeight)
        tvWeight = findViewById<TextView>(R.id.tvWeight)

        btnSubtractAge = findViewById<FloatingActionButton>(R.id.btnSubtractAge)
        btnPlusAge = findViewById<FloatingActionButton>(R.id.btnPlustAge)
        tvAge = findViewById<TextView>(R.id.tvAge)
        btnCalculator = findViewById<Button>(R.id.btnCaculator)
    }

    //    FUNCIÓN PARA INICIALIZAR LAS LLAMADAS AL TOCAR LAS CARDVIEWS
    @RequiresApi(Build.VERSION_CODES.N)
    private fun initListener() {

        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->

            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHright.text = "$currentHeight cm"

        }

        btnPlusWeight.setOnClickListener {
            currentWeigth += 1
            setWeigth()
        }

        btnSubtractWeight.setOnClickListener {
            currentWeigth -= 1
            setWeigth()
        }

        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnCalculator.setOnClickListener {
            val result = calculateIMC()
            navigateToImcResult(result)
        }

    }

    private fun navigateToImcResult(result:Double){
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun calculateIMC(): Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeigth / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }


//    SETEAR LA EDAD
    private fun setAge() {
        tvAge.text = currentAge.toString()
    }


    //ACA SETEAMOS EL VAMOR DEL TEXTO DEL PESO
    private fun setWeigth() {
        tvWeight.text = currentWeigth.toString()
    }


    //    CADA VEZ QUE SE HACE CLICK SE CAMBIA EL BOOLEAN, EJEMPLO: TRUE CAMBIA A FALSE PORQUE ES !=
    private fun changeGender() {
        isMaleSelecte = !isMaleSelecte
        isFemaleSelected = !isFemaleSelected

    }


    //    FUNCIÓN PARA OBTENER LOS COLORES
    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackGroundColor(isMaleSelecte))
        viewFemale.setCardBackgroundColor(getBackGroundColor(isFemaleSelected))
    }


    //    OBTENER EL COLOR
    private fun getBackGroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)

    }


    //    AL PRINCIPIO INICIALIZAR LA INTERFAS DEL USUARIO
    private fun initUI() {
        setGenderColor()
        setWeigth()
        setAge()
    }


}