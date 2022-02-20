package com.example.addressbook

import android.Manifest
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MapActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        val data = intent.getParcelableExtra<Address>("data")
        val addrText = findViewById<TextView>(R.id.mapAddressText)

        addrText.text = data?.address

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        val mapsFragment = MapsFragment(this)
        fragmentTransaction.add(R.id.mapContent, mapsFragment)
        fragmentTransaction.commit()

        val geocoder: Geocoder = Geocoder(this)

        var latitude : Double = 1.1
        var longitude : Double = 1.1

        var list: List<android.location.Address>? = geocoder.getFromLocationName(data?.address,10)

        latitude = list!![0].latitude
        longitude = list!![0].longitude

        val mapSearchBtn = findViewById<Button>(R.id.mapSearchBtn)
        val mapContent = findViewById<FrameLayout>(R.id.mapContent)

        mapContent.visibility = View.INVISIBLE

        mapSearchBtn.setOnClickListener {
            mapContent.visibility = View.VISIBLE
            mapsFragment.setLocation(latitude, longitude)
        }

        }

}