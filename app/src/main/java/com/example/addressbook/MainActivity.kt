package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn = findViewById<Button>(R.id.button1)
        val searchBtn = findViewById<Button>(R.id.button2)

        insertBtn.setOnClickListener {
            val i = Intent(this, InsertActivity::class.java)
            startActivity(i)
        }

        searchBtn.setOnClickListener {
            val i = Intent(this, SearchActivity::class.java)
            startActivity(i)
        }
    }
}