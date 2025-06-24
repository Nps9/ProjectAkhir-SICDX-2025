package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil) // Pastikan layout XML sesuai

        val textHasil = findViewById<TextView>(R.id.textHasil)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        // Ambil data dari intent
        val hasil = intent.getStringExtra("hasilFormulir")

        // Jika null atau kosong, beri pesan default
        if (hasil.isNullOrEmpty()) {
            Toast.makeText(this, "Data tidak tersedia", Toast.LENGTH_SHORT).show()
            textHasil.text = "Data tidak tersedia."
            return
        }

        // Format waktu saat ini
        val waktu = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        // Format struk
        val tampilanStruk = """
            ===============================
                  STRUK PEMESANAN WISATA
            ===============================

            $hasil

            -------------------------------
            Waktu Submit : $waktu
            ===============================
            Terima kasih telah mendaftar!
        """.trimIndent()

        // Tampilkan di TextView
        textHasil.text = tampilanStruk

        // Tombol kembali
        btnKembali.setOnClickListener {
            finish() // Tutup activity dan kembali ke MainActivity
        }
    }
}
