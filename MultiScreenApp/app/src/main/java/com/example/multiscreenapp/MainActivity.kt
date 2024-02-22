package com.example.multiscreenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    //Key of class
    companion object {
        const val KEY = "com.example.multiscreenapp.MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val istorder = findViewById<EditText>(R.id.order1)
        val sndorder = findViewById<EditText>(R.id.order2)
        val thrdorder = findViewById<EditText>(R.id.order3)
        val frthorder = findViewById<EditText>(R.id.order4)

        val btnOrder = findViewById<Button>(R.id.orderbtn)
        btnOrder.setOnClickListener {
            val allOrders = istorder.text.toString() + " , " + sndorder.text.toString() +
                    " , " + thrdorder.text.toString() + " , " + frthorder.text.toString()
            intent = Intent(this, ShowOrderActivity::class.java)
            intent.putExtra(KEY , allOrders)
            startActivity(intent)
        }



    }
}