package com.example.unitbasic

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class VolumeActivity : AppCompatActivity() {

    lateinit var backBtnToMain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        backBtnToMain = findViewById(R.id.backBtnToMain)
        backBtnToMain.setOnClickListener() {
            finish()
        }
    }
}