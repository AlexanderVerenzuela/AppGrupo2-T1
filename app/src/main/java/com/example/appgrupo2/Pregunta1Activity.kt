package com.example.appgrupo2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appgrupo2.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {

            val textoLongitud = binding.etLongitud.text.toString()

            if (textoLongitud.isEmpty()) {
                binding.etLongitud.error = "Ingrese la longitud de la carga"
                return
            }

            val longitud = textoLongitud.toDouble()

            if (longitud <= 12) {

                binding.tvResultado.text =
                    "Carga dentro de las dimensiones permitidas."

            } else {

                val exceso = longitud - 12
                val sobrecargo = 400.0 + (120.0 * exceso)

                binding.tvResultado.text =
                    "Longitud ingresada: %.2f m\n".format(longitud) +
                            "Exceso de metros: %.2f m\n".format(exceso) +
                            "Sobrecargo total calculado: S/ %.2f".format(sobrecargo)
            }
        }
    }
}
