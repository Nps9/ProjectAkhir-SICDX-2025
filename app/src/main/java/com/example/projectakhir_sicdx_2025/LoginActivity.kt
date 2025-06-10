package com.example.projectakhir_sicdx_2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.editTextUsername)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            if (user == "admin" && pass == "1234") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", user)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login gagal!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
