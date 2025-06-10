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

        btnSubmit.setOnClickListener {
            val nama = editTextNama.text.toString()

            if (nama.isEmpty()) {
                Toast.makeText(this, "Silakan isi nama terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else if (!checkBox.isChecked) {
                Toast.makeText(this, "Silakan ceklis dulu", Toast.LENGTH_SHORT).show()
            } else {
                val pesan = "Halo, $nama! Selamat datang di Aplikasi Pariwisata Lampung."
                textHasil.text = pesan
                sudahSubmit = true
            }
        }
        imageButton.setOnClickListener {
            editTextNama.text.clear()
            checkBox.isChecked = false
            textHasil.text = ""
            sudahSubmit = false


        }
    }
}
