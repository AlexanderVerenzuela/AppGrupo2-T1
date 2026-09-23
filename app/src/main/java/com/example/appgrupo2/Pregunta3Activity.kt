package com.example.appgrupo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.appgrupo2.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnCalcular.id) {
            val textoMinutos = binding.etMinutos.text.toString()

            if (textoMinutos.isEmpty()) {
                binding.etMinutos.error = "Ingrese los minutos de retraso"
                return
            }

            val minutos = textoMinutos.toIntOrNull()
            if (minutos == null) {
                binding.etMinutos.error = "Ingrese un número entero válido"
                return
            }

            if (minutos <= 15) {
                binding.tvResultado.text = "Entrega dentro de la tolerancia operativa."
            } else {
                val minutosExceso = minutos - 15
                val penalidad = 15.00 + (2.50 * minutosExceso)

                binding.tvResultado.text =
                    "Minutos reportados: $minutos\n" +
                    "Minutos de exceso: $minutosExceso\n" +
                    "Monto total de la penalidad: S/ %.2f".format(penalidad)
            }
        }
    }
}
