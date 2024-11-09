package com.example.googlebooks

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExtraInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_extra_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title: TextView = findViewById(R.id.title)
        val authors: TextView = findViewById(R.id.authors)
        val description: TextView = findViewById(R.id.description)
        val saleability: TextView = findViewById(R.id.saleability)
        val isbook: TextView = findViewById(R.id.isbook)
        val country: TextView = findViewById(R.id.country)

        title.text = intent.getStringExtra("TITLE")
        authors.text = intent.getStringExtra("AUTHOR")
        description.text = intent.getStringExtra("DESC")
        saleability.text = intent.getStringExtra("SALE INFO")
        isbook.text = intent.getStringExtra("ISBOOK")
        country.text = intent.getStringExtra("COUNTRY")


    }
}