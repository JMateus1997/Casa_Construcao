package com.example.casaconstrucao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casaconstrucao.databinding.ActivityTelaParedeBinding
import com.example.casaconstrucao.databinding.ActivityTelaPisoBinding

class Tela_Parede : AppCompatActivity() {

    private lateinit var binding: ActivityTelaParedeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaParedeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{ calcularParede() }
    }

    fun calcularParede(){

        val stringComprimentoParede = binding.comprimentoParede.text.toString()
        val comprimentoParede = stringComprimentoParede.toDoubleOrNull()

        val stringAlturaParede = binding.alturaParede.text.toString()
        val alturaParede = stringAlturaParede.toDoubleOrNull()

        val stringPrecoTijolo = binding.precoTijolo.text.toString()
        val precoTijolo = stringPrecoTijolo.toDoubleOrNull()

        if (comprimentoParede == null || alturaParede == null || precoTijolo == null)
        {
            val areaParede = " "
            binding.quantidadeTijolo.text = " "
            binding.precoFinalTijolo.text = " "
            return
        }
        val areaParede = comprimentoParede * alturaParede
        val tijolos = areaParede*40

        var milheiroTijolo = tijolos/1000
        milheiroTijolo = kotlin.math.ceil(milheiroTijolo)

        binding.quantidadeTijolo.text = tijolos.toString()
        binding.precoFinalTijolo.text = (milheiroTijolo * precoTijolo).toString()


    }
}