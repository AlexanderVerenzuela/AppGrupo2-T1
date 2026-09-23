package com.example.appgrupo2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appgrupo2.databinding.ActivityPregunta7Binding
import java.util.Locale

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val textoMinutos = binding.etMinutos.text.toString().trim()

            if (textoMinutos.isEmpty()) {
                Toast.makeText(
                    this,
                    "Ingrese los minutos de permanencia",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val minutos = textoMinutos.toInt()

            if (minutos < 0) {
                Toast.makeText(
                    this,
                    "Ingrese un valor válido",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            if (minutos <= 45) {

                binding.tvResultado.text =
                    "Maniobra terminada dentro del tiempo asignado."

            } else {

                val exceso = minutos - 45
                val cargo = 70.0 + (exceso * 4.0)

                val cargoFormateado = String.format(Locale.US, "S/ %.2f", cargo)

                binding.tvResultado.text =
                    "Minutos de uso: $minutos min\n" +
                            "Exceso de permanencia: $exceso min\n" +
                            "Cargo por ocupación extraordinaria: $cargoFormateado"
            }
        }
    }
}


