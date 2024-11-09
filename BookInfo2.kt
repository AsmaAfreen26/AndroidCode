package com.example.googlebooks

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.googlebooks.datasources.ExampleJson2KtKotlin
import com.google.gson.Gson

class BookInfo2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_info2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val query = intent.getStringExtra("QUERY")
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.googleapis.com/books/v1/volumes?q=$query"
        val stringRequest = StringRequest(Request.Method.GET,url,{response->
        val g = Gson()
            val s:ExampleJson2KtKotlin = g.fromJson(response,ExampleJson2KtKotlin::class.java)
            val pb: ProgressBar = findViewById(R.id.progressBar)
            pb.visibility = View.GONE
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            val d:DisplayBooks = DisplayBooks(this,s)
            recyclerView.adapter = d
            recyclerView.layoutManager = LinearLayoutManager(this)


        }, {error->})
        queue.add(stringRequest)

    }
}