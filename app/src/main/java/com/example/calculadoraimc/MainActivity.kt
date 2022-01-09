package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        inputPeso.doOnTextChanged { text, start, before, count ->  }
        inputAltura.doAfterTextChanged { text -> }

        btnCalcular.setOnClickListener {
            calcularImc(inputPeso.text.toString(), inputAltura.text.toString())
        }
    }


    private fun calcularImc(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura * altura)

            textTitle.text = "O seu IMC é de: %.2f".format(imc)
        }

    }
}