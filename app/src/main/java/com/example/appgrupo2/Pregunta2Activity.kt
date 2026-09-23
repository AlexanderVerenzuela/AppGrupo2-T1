package com.example.appgrupo2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import com.example.appgrupo2.databinding.ActivityPregunta2Binding

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {

            val textoDias = binding.etDias.text.toString()

            if (textoDias.isEmpty()) {
                binding.etDias.error = "Ingrese los días transcurridos"
                return
            }

            val dias = textoDias.toInt()

            if (dias <= 7) {

                binding.tvResultado.text =
                    "Contenedor retornado dentro de los días libres."

            } else {

                val diasMora = dias - 7
                val demurrage = 200.0 + (75.0 * diasMora)

                binding.tvResultado.text =
                    "Días totales transcurridos: $dias\n" +
                            "Días de mora: $diasMora\n" +
                            "Monto de demurrage liquidado: S/ %.2f".format(demurrage)
            }
        }
    }
}