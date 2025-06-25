package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val hasilFormulir = intent.getStringExtra("hasilFormulir")
        val username = intent.getStringExtra("username")

        val textViewWelcome = findViewById<TextView>(R.id.textViewWelcome)
        val textViewHasil = findViewById<TextView>(R.id.textViewHasil)

        textViewWelcome.text = "Halo, $username!"
        textViewHasil.text = hasilFormulir
    }
}
