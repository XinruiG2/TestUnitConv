package com.example.unitbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnLen : Button
    lateinit var btnVol : Button
    lateinit var btnWeight : Button
    lateinit var btnTemp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLen = findViewById(R.id.btnLen)
        btnVol = findViewById(R.id.btnVol)
        btnWeight = findViewById(R.id.btnWeight)
        btnTemp = findViewById(R.id.btnTemp)

        btnLen.setOnClickListener() {
            val intent = Intent(this, LengthActivity::class.java);
            startActivity(intent);
        }

        btnVol.setOnClickListener() {
            val intent = Intent(this, VolumeActivity::class.java);
            startActivity(intent);
        }
    }
}