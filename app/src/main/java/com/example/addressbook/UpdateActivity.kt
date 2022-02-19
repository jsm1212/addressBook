package com.example.addressbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val data = intent.getParcelableExtra<Address>("data")

        val updateEditName = findViewById<EditText>(R.id.updateEditName)
        val updateEditTel = findViewById<EditText>(R.id.updateEditTel)
        val updateEditAddress = findViewById<EditText>(R.id.updateEditAddress)
        val updateEditEmail = findViewById<EditText>(R.id.updateEditEmail)

        updateEditName.setText(data?.name)
        updateEditTel.setText(data?.tel)
        updateEditAddress.setText(data?.address)
        updateEditEmail.setText(data?.email)

        val updateBtn = findViewById<Button>(R.id.updateBtn)

        updateBtn.setOnClickListener {

            DBHelper.getInstance(this,"address.db").update(updateEditName.text.toString(),
                updateEditTel.text.toString(),
                        updateEditAddress.text.toString(),
                        updateEditEmail.text.toString()
                )

            Toast.makeText(this@UpdateActivity, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            var i = Intent(this, SearchActivity::class.java)
            startActivity(i)
        }
    }
}