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
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btncalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btncalcular -> evaluarAlmacenaje()
        }
    }

    fun evaluarAlmacenaje(){
        val textoHoras = binding.ethoras.text.toString()

        if (textoHoras.isEmpty()) {
            binding.txtrespuesta.text = "Ingrese una cantidad válida de horas"
            return
        }

        val horas = textoHoras.toDouble()

        if(horas <= 48){
            binding.txtrespuesta.text = "Almacenamiento cubierto por la tarifa base."[cite: 2]
        }else if (horas > 48){
            val exceso = horas - 48[cite: 2]
            val cargod = 90 + (exceso * 12)[cite: 2]
            val cargo = String.format("%.2f", cargod)[cite: 2]
            binding.txtrespuesta.text = "Horas de permanencia: $horas\n" +[cite: 2]
            "Exceso de tiempo (horas - 48): $exceso\n" +[cite: 2]
            "Cargo por estadía prolongada: S/ $cargo"[cite: 2]
        }else{
            binding.txtrespuesta.text = "Valores ingresados fuera de rango"
        }
    }
}