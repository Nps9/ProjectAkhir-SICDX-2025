package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class GaleriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri)

        // ActionBar Back Button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Galeri Wisata"

        // Pantai
        val btnPantai = findViewById<Button>(R.id.btnPantai)
        val sectionPantai = findViewById<LinearLayout>(R.id.sectionPantai)
        btnPantai.setOnClickListener {
            toggleSection(sectionPantai, btnPantai, "Pantai")
        }

        // Air Terjun
        val btnAirTerjun = findViewById<Button>(R.id.btnAirTerjun)
        val sectionAirTerjun = findViewById<LinearLayout>(R.id.sectionAirTerjun)
        btnAirTerjun.setOnClickListener {
            toggleSection(sectionAirTerjun, btnAirTerjun, "Air Terjun")
        }

        // Lainnya
        val btnLainnya = findViewById<Button>(R.id.btnLainnya)
        val sectionLainnya = findViewById<LinearLayout>(R.id.sectionLainnya)
        btnLainnya.setOnClickListener {
            toggleSection(sectionLainnya, btnLainnya, "Wisata Lainnya")
        }
    }

    private fun toggleSection(section: LinearLayout, button: Button, label: String) {
        if (section.visibility == View.GONE) {
            section.visibility = View.VISIBLE
            button.text = "Sembunyikan $label"
        } else {
            section.visibility = View.GONE
            button.text = "Lihat Wisata $label"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
