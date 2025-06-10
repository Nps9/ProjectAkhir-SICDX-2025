package com.example.projectakhir_sicdx_2025

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getStringExtra("username")
        Toast.makeText(this, "Selamat datang, $username!", Toast.LENGTH_LONG).show()
    }
}
