package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
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

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val spinnerTujuan = findViewById<Spinner>(R.id.spinnerTujuan)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.daftar_tujuan,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTujuan.adapter = adapter

        btnSubmit.setOnClickListener {
            val nama = editTextNama.text.toString()
            val tujuan = spinnerTujuan.selectedItem.toString()
            val selectedRadioId = radioGroup.checkedRadioButtonId

            if (nama.isEmpty()) {
                Toast.makeText(this, "Silakan isi nama terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else if (!checkBox.isChecked) {
                Toast.makeText(this, "Silakan ceklis dulu", Toast.LENGTH_SHORT).show()
            } else if (selectedRadioId == -1) {
                Toast.makeText(this, "Silakan pilih jenis kelamin", Toast.LENGTH_SHORT).show()
            } else if (tujuan == "Pilih Tujuan Wisata") {
                Toast.makeText(this, "Silakan pilih tujuan wisata", Toast.LENGTH_SHORT).show()
            } else {
                val gender = findViewById<RadioButton>(selectedRadioId).text.toString()
                val pesan = "Halo $nama ($gender)!\nTujuan wisata: $tujuan\nSelamat datang di Aplikasi Pariwisata Lampung."
                textHasil.text = pesan
                textWaktu.text = getWaktuSekarang()
                sudahSubmit = true
            }
        }

        imageButton.setOnClickListener {
            editTextNama.text.clear()
            checkBox.isChecked = false
            textHasil.text = ""
            textWaktu.text = ""
            spinnerTujuan.setSelection(0)
            radioGroup.clearCheck()
            sudahSubmit = false
            Toast.makeText(this, "Form telah direset", Toast.LENGTH_SHORT).show()
        }

        btnKeluar.setOnClickListener {
            finishAffinity()
        }
    }

    private fun getWaktuSekarang(): String {
        val format = SimpleDateFormat("HH:mm:ss, dd MMM yyyy", Locale.getDefault())
        return "Waktu submit: ${format.format(Date())}"
    }
}
