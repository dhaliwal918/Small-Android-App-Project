package com.example.understandinglogcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.textView)
        Log.i("Info tag" , "This is my log")
        tv.setOnClickListener {
            Log.i("Info tag2" , tv.toString())
            intent = Intent(applicationContext , MainActivity2::class.java)
            startActivity(intent)   
        }
    }
}