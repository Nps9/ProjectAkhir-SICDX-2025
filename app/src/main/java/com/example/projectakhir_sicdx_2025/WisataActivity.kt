package com.example.projectakhir_sicdx_2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WisataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata)

        val btnGaleri = findViewById<Button>(R.id.btnGaleri)
        val btnWisata = findViewById<Button>(R.id.btnWisata)
        val btnTentang = findViewById<Button>(R.id.btnTentang)

        // Tombol Galeri
        btnGaleri.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        // Tombol Daftar Wisata
        btnWisata.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Tombol Tentang
        btnTentang.setOnClickListener {
            // Implementasi sesuai kebutuhan
        }
    }
}
