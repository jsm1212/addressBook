package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class ProfileDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        val data = intent.getParcelableExtra<Address>("data")

        val name = findViewById<TextView>(R.id.profileName)
        val tel = findViewById<TextView>(R.id.profileTel)
        val address = findViewById<TextView>(R.id.profileAddress)
        val email = findViewById<TextView>(R.id.profileEmail)

        name.text = data?.name
        tel.text = data?.tel
        address.text = data?.address
        email.text = data?.email

        val deleteBtn = findViewById<Button>(R.id.deleteBtn)

        deleteBtn.setOnClickListener {
            DBHelper.getInstance(this,"address.db").delete(tel.text.toString())

            Toast.makeText(this@ProfileDetailActivity, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            var i = Intent(this, SearchActivity::class.java)
            startActivity(i)
        }

        val updateBtn = findViewById<Button>(R.id.updateBtn)

        updateBtn.setOnClickListener {
            val i = Intent(this, UpdateActivity::class.java)

            i.putExtra("data", data)

            startActivity(i)
        }

    }
}