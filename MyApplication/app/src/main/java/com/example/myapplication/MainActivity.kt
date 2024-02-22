package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonRead = findViewById<Button>(R.id.btnRead)
        val buttonLight = findViewById<Button>(R.id.btnLight)
        val linearLayout = findViewById<LinearLayout>(R.id.LinearLayout)

        buttonDark.setOnClickListener {
            linearLayout.setBackgroundResource(R.color.dark)
        }
        buttonRead.setOnClickListener {
            linearLayout.setBackgroundResource(R.color.Yellowish)
        }
        buttonLight.setOnClickListener {
            linearLayout.setBackgroundResource(R.color.light)
        }

    }
}