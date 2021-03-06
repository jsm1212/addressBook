package com.example.addressbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)

            val adapter = CustomAdapter(this)
            recyclerView.adapter = adapter

            val layout = LinearLayoutManager(this)
            recyclerView.layoutManager = layout

            recyclerView.setHasFixedSize(true)

            adapter.dataList.addAll(DBHelper.getInstance(this, "address.db").select())

    }
}