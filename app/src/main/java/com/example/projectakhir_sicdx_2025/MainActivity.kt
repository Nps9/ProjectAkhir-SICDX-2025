package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val checkBox = findViewById<CheckBox>(R.id.main_btn_checkBox)
        val button = findViewById<Button>(R.id.main_btn_submit)

        imageButton.setOnClickListener {
            editText.setText("")
            Toast.makeText(this, "Input direset", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            val nama = editText.text.toString()
            val isChecked = checkBox.isChecked

            if (nama.isEmpty()) {
                Toast.makeText(this, "Masukan nama dulu ya!", Toast.LENGTH_SHORT).show()
            } else {
                val status = if (isChecked) "Sudah diceklis" else "Belum diceklis"
                Toast.makeText(this, "Halo $nama, checkbox: $status", Toast.LENGTH_LONG).show()
            }
        }
    }
}
