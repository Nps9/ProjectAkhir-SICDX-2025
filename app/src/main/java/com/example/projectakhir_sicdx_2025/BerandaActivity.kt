package com.example.projectakhir_sicdx_2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val btnWisata: Button = findViewById(R.id.btnWisata)
        val btnTentang: Button = findViewById(R.id.btnTentang)
        val textViewQuote: TextView = findViewById(R.id.textViewQuote)

        val quotes = listOf( //
            "\"Travel brings power and love back into your life.\"",
            "\"Adventure is worthwhile in itself.\" – Amelia Earhart",
            "\"Life is short and the world is wide.\"",
            "\"The journey, not the arrival, matters.\"",
            "\"Travel far, travel wide, and travel often.\""
        )

        val randomIndex = Random.nextInt(quotes.size)

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
