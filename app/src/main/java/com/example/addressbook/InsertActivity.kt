package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val insertBtn = findViewById<Button>(R.id.insertBtn)

        val insertName = findViewById<EditText>(R.id.editName)
        val insertAddress = findViewById<EditText>(R.id.editAddress)
        val insertTel = findViewById<EditText>(R.id.editTel)
        val insertEmail = findViewById<EditText>(R.id.editEmail)

        insertBtn.setOnClickListener {
            val address = Address(0,
                insertName.text.toString(),
                insertAddress.text.toString(),
                insertTel.text.toString(),
                insertEmail.text.toString()
                )
            DBHelper.getInstance(this,"address.db").insert(address)

            Toast.makeText(this@InsertActivity, "추가되었습니다.", Toast.LENGTH_SHORT).show()
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}