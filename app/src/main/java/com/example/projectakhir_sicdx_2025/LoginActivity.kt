package com.example.projectakhir_sicdx_2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.editTextUsername)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val errorText = findViewById<TextView>(R.id.textLoginError)

        btnLogin.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            if (user == "admin" && pass == "admin") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                errorText.text = "Username atau Password salah!"
            }
        }
    }
}