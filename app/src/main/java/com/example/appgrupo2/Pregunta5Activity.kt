package com.example.appgrupo2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appgrupo2.databinding.ActivityMainBinding
import com.example.appgrupo2.databinding.ActivityPregunta5Binding

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta5Binding.inflate(layoutInflater)
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
            R.id.btncalcular -> evaluarPeso()
        }
    }

    fun evaluarPeso(){
        val peso = binding.etpeso.text.toString().toDouble()

        if(peso<=18){
            binding.txtrespuesta.text = "Vehiculo con carga reglamentaria autorizada"
        }else if (peso > 18){
            val exceso = peso - 18;
            val multad = 1800 + (exceso*650)
            val multa =String.format("%.2f", multad)
            binding.txtrespuesta.text = "Peso Registrado: $peso \n" +
                    "Exceso de carga: $exceso \n" +
                    "Multa calculada: s/. $multa"
        }else{
            binding.txtrespuesta.text = "Valores ingresados fuera de rango"
        }
    }
}