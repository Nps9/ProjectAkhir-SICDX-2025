package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata)

        val textView: TextView = findViewById(R.id.textViewWisata)
        val daftarWisata = """
            Daftar Wisata Lampung:

            - Pantai Pahawang
            - Way Kambas
            - Pulau Tegal Mas
            - Pantai Mutun
            - Teluk Kiluan
        ""${'"'}.trimIndent()

        textView.text = daftarWisata
    }
}
