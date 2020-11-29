package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setTitle("Notes")

        val card = findViewById<CardView>(R.id.cardView)
        card.setOnClickListener {
            val intent = Intent(this, SourceActivity::class.java)
            startActivity(intent)
        }
    }
}