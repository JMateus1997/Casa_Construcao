package com.example.casaconstrucao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casaconstrucao.databinding.ActivityTelaTelhadoBinding

class Tela_Telhado : AppCompatActivity() {

    private lateinit var binding: ActivityTelaTelhadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaTelhadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener{ calcularTelhado() }
    }
    fun calcularTelhado(){

        val stringAreaTelhado = binding.areaTelhado.text.toString()
        val areaTelhado = stringAreaTelhado.toDoubleOrNull()

        val stringPrecoTelhado = binding.precoTelhado.text.toString()
        val precoTelhado = stringPrecoTelhado.toDoubleOrNull()

        if ((areaTelhado == null) || (precoTelhado == null)){

            binding.telhas.text = " "
            binding.precoTotalTelhas.text = " "
            return
        }

        val porcentagem_telha = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 1.02
            R.id.option_eighteen_percent -> 1.031
            else -> 1.044
        }

        var cobertura = areaTelhado * 15 * porcentagem_telha * 1.05
        cobertura = kotlin.math.ceil(cobertura)

        var precoTotal = cobertura * precoTelhado
        precoTotal = kotlin.math.ceil(precoTotal)

        binding.telhas.text = cobertura.toString()
        binding.precoTotalTelhas.text = precoTotal.toString()


    }
}


/*

<RadioGroup
        android:id="@+id/opcoes_inclinacao"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checkedButton="@id/opcao_20_graus"
        android:orientation="horizontal"
        app:layout_constraintBottom_toTopOf="@id/divider6"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/divider5">

        <RadioButton
            android:id="@id/opcao_20_graus"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/vinte_porc"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.093"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.449" />

        <RadioButton
            android:id="@+id/opcao_25_graus"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/vintecinco_porc"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.473"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.45" />

        <RadioButton
            android:id="@+id/opcao_30_graus"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/trinta_porc"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.827"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.45" />
    </RadioGroup>
 */