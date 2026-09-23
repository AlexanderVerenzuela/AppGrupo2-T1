package com.example.appgrupo2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appgrupo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPregunta1.setOnClickListener {
            val intent = Intent(this, Pregunta1Activity::class.java)
            startActivity(intent)
        }

        binding.btnPregunta2.setOnClickListener {
            val intent = Intent(this, Pregunta2Activity::class.java)
            startActivity(intent)
        }

       binding.btnPregunta3.setOnClickListener {
               val intent = Intent(this, Pregunta3Activity::class.java)
           startActivity(intent)
          }

        //    binding.btnPregunta4.setOnClickListener {
        //      val intent = Intent(this, Pregunta4Activity::class.java)
        //       startActivity(intent)
        //   }

           binding.btnPregunta5.setOnClickListener {
               val intent = Intent(this, Pregunta5Activity::class.java)
              startActivity(intent)
          }

           binding.btnPregunta6.setOnClickListener {
              val intent = Intent(this, Pregunta6Activity::class.java)
              startActivity(intent)
          }

           binding.btnPregunta7.setOnClickListener {
                   val intent = Intent(this, Pregunta7Activity::class.java)
              startActivity(intent)
          }
    }
}
