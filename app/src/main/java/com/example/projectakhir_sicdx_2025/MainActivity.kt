package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var sudahSubmit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextNama = findViewById<EditText>(R.id.editTextNama)
        val btnSubmit = findViewById<Button>(R.id.main_btn_submit)
        val checkBox = findViewById<CheckBox>(R.id.main_btn_checkBox)
        val textHasil = findViewById<TextView>(R.id.textHasil)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val textWaktu = findViewById<TextView>(R.id.textWaktu)
        val btnKeluar = findViewById<Button>(R.id.btnKeluar)

        // Tombol Submit
        btnSubmit.setOnClickListener {
            val nama = editTextNama.text.toString()

            if (nama.isEmpty()) {
                Toast.makeText(this, "Silakan isi nama terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else if (!checkBox.isChecked) {
                Toast.makeText(this, "Silakan ceklis dulu", Toast.LENGTH_SHORT).show()
            } else {
                val pesan = "Halo, $nama! Selamat datang di Aplikasi Pariwisata Lampung."
                textHasil.text = pesan
                textWaktu.text = getWaktuSekarang()
                sudahSubmit = true
            }
        }

        // Tombol Reset (ImageButton)
        imageButton.setOnClickListener {
            editTextNama.text.clear()
            checkBox.isChecked = false
            textHasil.text = ""
            textWaktu.text = ""
            sudahSubmit = false
            Toast.makeText(this, "Form telah direset", Toast.LENGTH_SHORT).show()
        }

        // Tombol Keluar
        btnKeluar.setOnClickListener {
            finishAffinity() // Menutup semua activity
        }
    }

    private fun getWaktuSekarang(): String {
        val format = SimpleDateFormat("HH:mm:ss, dd MMM yyyy", Locale.getDefault())
        return "Waktu submit: ${format.format(Date())}"
    }
}
