package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Ambil referensi UI
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val editName = findViewById<EditText>(R.id.editName)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editPassword = findViewById<EditText>(R.id.editPassword)

        btnRegister.setOnClickListener {
            val name = editName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()

            // Validasi input
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan data ke SharedPreferences (opsional)
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("name", name)
                putString("email", email)
                putString("password", password)
                apply()
            }

            // 1. Log untuk debugging
            Log.d("REGISTER", "User Registered: $name | Email: $email")

            // 2. Tampilkan 2x Toast
            Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Selamat datang, $name!", Toast.LENGTH_SHORT).show()

            // 3. Pindah ke GalleryActivity
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
