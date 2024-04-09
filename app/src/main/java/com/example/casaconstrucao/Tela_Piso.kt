package com.example.casaconstrucao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.casaconstrucao.databinding.ActivityMainBinding
import com.example.casaconstrucao.databinding.ActivityTelaPisoBinding
import java.text.NumberFormat

class Tela_Piso : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPisoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaPisoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcularButton.setOnClickListener{ calcularPiso() }
    }

    fun calcularPiso (){

        val stringComprimentoPiso = binding.comprimentoPiso.text.toString()
        val comprimentoPiso = stringComprimentoPiso.toDoubleOrNull()

        val stringLarguraPiso = binding.larguraPiso.text.toString()
        val larguraPiso = stringLarguraPiso.toDoubleOrNull()

        val stringPrecoPiso = binding.precoPiso.text.toString()
        val precoPiso = stringPrecoPiso.toDoubleOrNull()

        val stringComprimentoChao = binding.comprimentoChao.text.toString()
        val comprimentoChao = stringComprimentoChao.toDoubleOrNull()

        val stringLarguraChao = binding.larguraChao.text.toString()
        val larguraChao = stringLarguraChao.toDoubleOrNull()

        if (larguraPiso == null || comprimentoPiso == null){
            val areaPiso = " "
            binding.pisosNecessarios.text = " "
            binding.areaPisoTotal.text = " "
            binding.precoTotal.text = " "
            binding.corte.text = " "
            return
        }
        if (larguraChao == null || comprimentoChao == null){
            val areaChao = " "
            binding.pisosNecessarios.text = " "
            binding.areaPisoTotal.text = " "
            binding.precoTotal.text = " "
            binding.corte.text = " "
            return
        }
        val areaPiso = comprimentoPiso * 0.01 * larguraPiso * 0.01
        val areaChao = comprimentoChao * larguraChao

        var pisos = areaChao/areaPiso

        if (((larguraChao%(larguraPiso*0.01)) != 0.0 ) || ((comprimentoChao%(comprimentoPiso*0.01)) != 0.0)){
            binding.corte.text = "Sim"
        }
        else { binding.corte.text = "Não"}


        pisos = kotlin.math.ceil(pisos)

        if (precoPiso == null){
            val precoTotalPisos = " "
            return
        }

        val areaTotalPiso = areaPiso*pisos
        val precoTotalPisos = areaTotalPiso * precoPiso

        binding.pisosNecessarios.text = pisos.toString()
        binding.areaPisoTotal.text = areaTotalPiso.toString()
        binding.precoTotal.text = precoTotalPisos.toString()

    }




}
