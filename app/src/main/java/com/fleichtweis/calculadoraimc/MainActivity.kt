package com.fleichtweis.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPeso = findViewById(R.id.edit_peso)
        editAltura = findViewById(R.id.edit_altura)
        btnCalcular = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            if (validarCampos()){
                val peso = editPeso.text.toString().toDouble()
                val altura = editAltura.text.toString().toDouble()

                val intent = Intent(this, DetalhesActivity::class.java)
                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)
                startActivity(intent)
            }
        }
    }

    private fun validarCampos(): Boolean {
        if (editPeso.text.isEmpty()){
            Toast.makeText(this, "Preencha o peso", Toast.LENGTH_SHORT).show()
            return false
        }
        if (editAltura.text.isEmpty()){
            Toast.makeText(this, "Preencha a altura", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}