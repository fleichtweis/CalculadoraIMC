package com.fleichtweis.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetalhesActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        textPeso = findViewById(R.id.text_peso_informado)
        textAltura = findViewById(R.id.text_altura_informada)
        textResultado = findViewById(R.id.text_resultado)

        val extras = intent.extras
        val peso = extras?.getDouble("peso") ?: 0.0
        val altura = extras?.getDouble("altura") ?: 0.0

        textPeso.text = "Peso informado: $peso Kg"
        textAltura.text = "Altura informada: $altura m"

        calcularIMC(peso, altura)
    }

    private fun calcularIMC(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)

        if (imc < 18.5) textResultado.text = "Magreza"
        if (imc >= 18.5 && imc < 25) textResultado.text = "Normal"
        if (imc >= 25 && imc < 30) textResultado.text = "Sobrepeso"
        if (imc >= 30 && imc < 40) textResultado.text = "Obesidade"
        if (imc >= 40) textResultado.text = "Obesidade grave"
    }
}