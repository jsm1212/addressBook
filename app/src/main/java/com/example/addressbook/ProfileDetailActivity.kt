package com.example.addressbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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

    }
}