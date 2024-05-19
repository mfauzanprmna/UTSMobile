package com.example.utsmobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailBeritaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val imageView: ImageView = findViewById(R.id.imageDetail)
        val titleView: TextView = findViewById(R.id.detailJudul)
        val descriptionView: TextView = findViewById(R.id.descDetail)

        val imageResId = intent.getIntExtra("imageResId", 0)
        val title = intent.getStringExtra("title")
        val isi = intent.getStringExtra("isi")

        imageView.setImageResource(imageResId)
        titleView.text = title
        descriptionView.text = isi
    }
}