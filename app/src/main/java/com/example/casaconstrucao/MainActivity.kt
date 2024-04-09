package com.example.casaconstrucao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.casaconstrucao.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.paredeButton.setOnClickListener { navegarParede() }
        binding.pisoButton.setOnClickListener { navegarPiso() }
        binding.telhadoButton.setOnClickListener { navegarTelhado() }
}
    //Leva para a tela de Parede
    private fun navegarParede(){

        val intent = Intent(applicationContext, Tela_Parede::class.java)
        startActivity(intent)

    }
    //Leva para a tela de Piso
    private fun navegarPiso(){

        val intent = Intent(applicationContext, Tela_Piso::class.java)
        startActivity(intent)

    }
    //Leva para a tela de Telhado
    private fun navegarTelhado(){

        val intent = Intent(applicationContext, Tela_Telhado::class.java)
        startActivity(intent)

    }

}