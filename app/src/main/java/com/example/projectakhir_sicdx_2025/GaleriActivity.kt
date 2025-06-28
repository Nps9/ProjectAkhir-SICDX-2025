package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GaleriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri)

        // Menampilkan tombol kembali di action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Galeri Wisata Lampung"
    }

    // Aksi ketika tombol kembali ditekan
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
