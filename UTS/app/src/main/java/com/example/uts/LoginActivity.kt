package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val editEmail = findViewById<EditText>(R.id.editLoginEmail)
        val editPassword = findViewById<EditText>(R.id.editLoginPassword)
        val textRegister = findViewById<TextView>(R.id.textRegister)

        btnLogin.setOnClickListener {
            val inputEmail = editEmail.text.toString()
            val inputPassword = editPassword.text.toString()

            if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                // Ambil data dari SharedPreferences
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                val savedEmail = sharedPref.getString("email", null)
                val savedPassword = sharedPref.getString("password", null)

                if (inputEmail == savedEmail && inputPassword == savedPassword) {
                    Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, GalleryActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Email & Password wajib diisi!", Toast.LENGTH_SHORT).show()
            }
        }

        textRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}
