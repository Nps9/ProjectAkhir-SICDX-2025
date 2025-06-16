package com.example.projectakhir_sicdx_2025

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNama: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var checkBox: CheckBox
    private lateinit var spinnerTujuan: Spinner
    private lateinit var btnTanggal: Button
    private lateinit var textTanggal: TextView
    private lateinit var editTextCatatan: EditText
    private lateinit var btnSubmit: Button
    private lateinit var textHasil: TextView
    private lateinit var textWaktu: TextView
    private lateinit var btnKeluar: Button

    private var selectedTanggal: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        editTextNama = findViewById(R.id.editTextNama)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        checkBox = findViewById(R.id.main_btn_checkBox)
        spinnerTujuan = findViewById(R.id.spinnerTujuan)
        btnTanggal = findViewById(R.id.btnTanggal)
        textTanggal = findViewById(R.id.textTanggal)
        editTextCatatan = findViewById(R.id.editTextCatatan)
        btnSubmit = findViewById(R.id.main_btn_submit)
        textHasil = findViewById(R.id.textHasil)
        textWaktu = findViewById(R.id.textWaktu)
        btnKeluar = findViewById(R.id.btnKeluar)

        // Mengisi spinner
        val listTujuan = arrayOf("Pilih Tujuan", "Pantai Sari Ringgung", "Pulau Pahawang", "Lembah Hijau", "Menara Siger", "Pulau Sebesi", "Gunung Tanggamus", "Danau Ranau", "Way Kambas", "Air Terjun Putri Malu", "Teluk Kiluan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listTujuan)
        spinnerTujuan.adapter = adapter

        // Tombol untuk memilih tanggal
        val calendar = Calendar.getInstance()
        btnTanggal.setOnClickListener {
            val datePicker = DatePickerDialog(this, { view, year, month, dayOfMonth ->
                val pickedDate = "$dayOfMonth-${month + 1}-$year"
                selectedTanggal = pickedDate
                textTanggal.text = "Tanggal: $pickedDate"
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        // Tombol submit
        btnSubmit.setOnClickListener {
            val nama = editTextNama.text.toString()
            val genderId = radioGroupGender.checkedRadioButtonId
            val gender = if (genderId != -1) findViewById<RadioButton>(genderId).text.toString() else ""
            val setuju = checkBox.isChecked
            val tujuan = spinnerTujuan.selectedItem.toString()
            val catatan = editTextCatatan.text.toString()

            // Validasi input
            if (nama.isEmpty() ||
                gender.isEmpty() ||
                !setuju ||
                tujuan == "Pilih Tujuan" ||
                selectedTanggal.isEmpty()) {

                Toast.makeText(this, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Format hasil dan waktu
            val hasil = """
                Nama : $nama
                Gender : $gender
                Tujuan : $tujuan
                Tanggal : $selectedTanggal
                Catatan : $catatan
            """.trimIndent()

            val waktu = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())

            textHasil.text = hasil
            textWaktu.text = "Waktu submit: $waktu"

            // Setelah tampil hasil, pindah ke ActivityWisata
            val intent = Intent(this, WisataActivity::class.java)
            startActivity(intent)

            // Jika memang diberi tombol untuk keluar
            btnKeluar.setOnClickListener {
                finishAffinity()
            }
        }
    }
}
