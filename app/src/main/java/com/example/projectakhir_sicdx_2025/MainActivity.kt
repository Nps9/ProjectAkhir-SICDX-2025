package com.example.projectakhir_sicdx_2025

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import android.content.Intent
import com.example.projectakhir_sicdx_2025.WisataActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNama: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var checkBoxSetuju: CheckBox
    private lateinit var spinnerTujuan: Spinner
    private lateinit var btnTanggal: Button
    private lateinit var textTanggal: TextView
    private lateinit var editTextCatatan: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnKeluar: Button
    private lateinit var textHasil: TextView
    private lateinit var textWaktu: TextView
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi semua view
        editTextNama = findViewById(R.id.editTextNama)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        checkBoxSetuju = findViewById(R.id.main_btn_checkBox)
        spinnerTujuan = findViewById(R.id.spinnerTujuan)
        btnTanggal = findViewById(R.id.btnTanggal)
        textTanggal = findViewById(R.id.textTanggal)
        editTextCatatan = findViewById(R.id.editTextCatatan)
        btnSubmit = findViewById(R.id.main_btn_submit)
        btnKeluar = findViewById(R.id.btnKeluar)
        textHasil = findViewById(R.id.textHasil)
        textWaktu = findViewById(R.id.textWaktu)
        bottomNav = findViewById(R.id.bottom_navigation) // Tambahan bottom navigation

        // Data untuk spinner tujuan wisata
        val daftarTujuan = arrayOf(
            "Pantai Pahawang", "Way Kambas", "Pulau Tegal Mas",
            "Pantai Mutun", "Teluk Kiluan"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daftarTujuan)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTujuan.adapter = adapter

        // Fungsi untuk memilih tanggal
        val kalender = Calendar.getInstance()
        btnTanggal.setOnClickListener {
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                    kalender.set(year, month, day)
                    val tanggal = sdf.format(kalender.time)
                    textTanggal.text = tanggal
                },
                kalender.get(Calendar.YEAR),
                kalender.get(Calendar.MONTH),
                kalender.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // Tombol Submit
        btnSubmit.setOnClickListener {
            val nama = editTextNama.text.toString()
            val gender = when (radioGroupGender.checkedRadioButtonId) {
                R.id.radioLaki -> "Laki-laki"
                R.id.radioPerempuan -> "Perempuan"
                else -> "Belum dipilih"
            }
            val setuju = checkBoxSetuju.isChecked
            val tujuan = spinnerTujuan.selectedItem.toString()
            val tanggal = textTanggal.text.toString()
            val catatan = editTextCatatan.text.toString()

            if (!setuju) {
                Toast.makeText(
                    this,
                    "Silakan centang persetujuan terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val hasil = """
                    Nama: $nama
                    Gender: $gender
                    Tujuan: $tujuan
                    Tanggal: $tanggal
                    Catatan: $catatan
                """.trimIndent()
                textHasil.text = hasil

                val waktu = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
                textWaktu.text = "Waktu pengisian: $waktu"
            }
        }

        // Tombol Keluar
        btnKeluar.setOnClickListener {
            finishAffinity() // Keluar dari seluruh activity
        }

        // Bottom Navigation Listener
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_beranda -> {
                    val intent = Intent(this, WisataActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_galeri -> {
                    Toast.makeText(this, "Galeri dibuka", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profil -> {
                    Toast.makeText(this, "Profil dibuka", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
}
