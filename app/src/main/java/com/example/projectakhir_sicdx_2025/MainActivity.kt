package com.example.projectakhir_sicdx_2025

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNama: EditText
    private lateinit var editTextUmur: EditText
    private lateinit var editTextAlamat: EditText
    private lateinit var editTextTelepon: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var checkBox: CheckBox
    private lateinit var checkPenginapan: CheckBox
    private lateinit var checkMakan: CheckBox
    private lateinit var spinnerTujuan: Spinner
    private lateinit var btnTanggal: Button
    private lateinit var textTanggal: TextView
    private lateinit var editTextCatatan: EditText
    private lateinit var btnUploadFoto: Button
    private lateinit var imagePreview: ImageView
    private lateinit var btnSubmit: Button
    private lateinit var btnShare: Button
    private lateinit var btnKeluar: Button

    private var selectedTanggal: String = ""
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        editTextNama = findViewById(R.id.editTextNama)
        editTextUmur = findViewById(R.id.editTextUmur)
        editTextAlamat = findViewById(R.id.editTextAlamat)
        editTextTelepon = findViewById(R.id.editTextTelepon)
        editTextEmail = findViewById(R.id.editTextEmail)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        checkBox = findViewById(R.id.main_btn_checkBox)
        checkPenginapan = findViewById(R.id.checkPenginapan)
        checkMakan = findViewById(R.id.checkMakan)
        spinnerTujuan = findViewById(R.id.spinnerTujuan)
        btnTanggal = findViewById(R.id.btnTanggal)
        textTanggal = findViewById(R.id.textTanggal)
        editTextCatatan = findViewById(R.id.editTextCatatan)
        btnUploadFoto = findViewById(R.id.btnUploadFoto)
        imagePreview = findViewById(R.id.imagePreview)
        btnSubmit = findViewById(R.id.main_btn_submit)
        btnShare = findViewById(R.id.btnShare)
        btnKeluar = findViewById(R.id.btnKeluar)

        // Isi spinner
        val listTujuan = arrayOf(
            "Pilih Tujuan", "Pantai Sari Ringgung", "Pulau Pahawang", "Lembah Hijau", "Menara Siger",
            "Pulau Sebesi", "Gunung Tanggamus", "Danau Ranau", "Way Kambas", "Air Terjun Putri Malu",
            "Teluk Kiluan", "Puncak Mas", "Bukit Cendana", "Curup Gangsa"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listTujuan)
        spinnerTujuan.adapter = adapter

        // Pilih tanggal
        val calendar = Calendar.getInstance()
        btnTanggal.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    selectedTanggal = "$dayOfMonth-${month + 1}-$year"
                    textTanggal.text = "Tanggal: $selectedTanggal"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        // Upload Foto
        btnUploadFoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 100)
        }

        // Submit Formulir
        btnSubmit.setOnClickListener {
            val nama = editTextNama.text.toString()
            val umur = editTextUmur.text.toString()
            val alamat = editTextAlamat.text.toString()
            val telepon = editTextTelepon.text.toString()
            val email = editTextEmail.text.toString()
            val genderId = radioGroupGender.checkedRadioButtonId
            val gender = if (genderId != -1) findViewById<RadioButton>(genderId).text.toString() else ""
            val setuju = checkBox.isChecked
            val penginapan = checkPenginapan.isChecked
            val makan = checkMakan.isChecked
            val tujuan = spinnerTujuan.selectedItem.toString()
            val catatan = editTextCatatan.text.toString()

            if (nama.isEmpty() || umur.isEmpty() || alamat.isEmpty() || telepon.isEmpty() ||
                email.isEmpty() || gender.isEmpty() ||
                !setuju || tujuan == "Pilih Tujuan" || selectedTanggal.isEmpty()
            ) {
                Toast.makeText(this, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hasil = """
                Nama       : $nama
                Umur       : $umur
                Alamat     : $alamat
                No. Telepon: $telepon
                Email      : $email
                Gender     : $gender
                Tujuan     : $tujuan
                Tanggal    : $selectedTanggal
                Penginapan : ${if (penginapan) "Ya" else "Tidak"}
                Makan      : ${if (makan) "Ya" else "Tidak"}
                Catatan    : $catatan
            """.trimIndent()

            val intent = Intent(this, HasilActivity::class.java)
            intent.putExtra("hasilFormulir", hasil)
            startActivity(intent)
        }

        // Share hasil
        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Bagikan formulir setelah submit dari halaman hasil")
            startActivity(Intent.createChooser(shareIntent, "Bagikan hasil via"))
        }

        // Keluar aplikasi
        btnKeluar.setOnClickListener {
            finishAffinity()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            imageUri = data.data
            imagePreview.setImageURI(imageUri)
        }
    }
}
