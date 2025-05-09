package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {

    private val imageIds = arrayOf(
        R.drawable.perang1,
        R.drawable.perang2,
        R.drawable.perang3,
        R.drawable.perang4,
        R.drawable.perang5
    )

    private val imageDescriptions = arrayOf(
        "Invasi Rusia ke Ukraina dimulai tahun 2022",
        "Pasukan Ukraina bertahan di Kyiv",
        "Pengungsi meninggalkan wilayah timur",
        "Dukungan NATO terhadap Ukraina",
        "Kerusakan infrastruktur akibat perang"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        // Set up GridView dengan ImageAdapter
        val gridView = findViewById<GridView>(R.id.galleryGrid)
        gridView.adapter = ImageAdapter(this, imageIds, imageDescriptions)

        // Set up Logout Button
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
