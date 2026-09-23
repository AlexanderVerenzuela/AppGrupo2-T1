package com.example.appgrupo2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appgrupo2.databinding.ActivityPregunta4Binding

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when (v.id) {

            R.id.btnCalcular -> evaluarAlmacenaje()

        }
    }

    fun evaluarAlmacenaje() {

        val textoHoras = binding.txtrespuesta.text.toString()

        if (textoHoras.isEmpty()) {

            binding.txtrespuesta.error = "Ingrese una cantidad válida de horas"
            return
        }

        val horas = textoHoras.toDouble()

        if (horas <= 48) {

            binding.tvResultado.text =
                "Almacenamiento cubierto por la tarifa base."

        } else if (horas > 48) {

            val exceso = horas - 48
            val cargod = 90 + (exceso * 12)
            val cargo = String.format("%.2f", cargod)

            binding.tvResultado.text =
                "Horas de permanencia: $horas\n" +
                        "Exceso de tiempo (horas - 48): $exceso\n" +
                        "Cargo por estadía prolongada: S/ $cargo"

        } else {

            binding.tvResultado.text =
                "Valores ingresados fuera de rango"
        }
    }
}