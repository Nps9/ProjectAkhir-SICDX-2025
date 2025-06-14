package com.example.projectakhir_sicdx_2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val btnWisata: Button = findViewById(R.id.btnWisata)
        val btnTentang: Button = findViewById(R.id.btnTentang)

        btnWisata.setOnClickListener {
            val intent = Intent(this, WisataActivity::class.java)
            startActivity(intent)
        }

        // Komentari sementara jika TentangActivity belum dibuat
        btnTentang.setOnClickListener {
            // startActivity(Intent(this, TentangActivity::class.java))
        }
    }
}
