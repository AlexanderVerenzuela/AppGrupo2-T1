package com.example.appgrupo2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appgrupo2.databinding.ActivityPregunta6Binding

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {

            val textoKilometros = binding.etKilometros.text.toString()

            if (textoKilometros.isEmpty()) {
                binding.etKilometros.error = "Ingrese los kilómetros recorridos"
                return
            }

            val kilometros = textoKilometros.toInt()

            if (kilometros <= 200) {

                binding.tvResultado.text =
                    "Recorrido cubierto por la tarifa contratada."

            } else {

                val kilometrosExtra = kilometros - 200
                val total = 50.0 + (1.20 * kilometrosExtra)

                binding.tvResultado.text =
                    "Kilómetros registrados: $kilometros\n" +
                            "Kilómetros extra: $kilometrosExtra\n" +
                            "Total a pagar por kilometraje excedente: S/ %.2f".format(total)
            }
        }
    }
}
