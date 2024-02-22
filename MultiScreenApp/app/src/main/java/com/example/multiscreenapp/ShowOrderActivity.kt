package com.example.multiscreenapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowOrderActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_order)

        val ordersOfCustomer = intent.getStringExtra(MainActivity.KEY)

        val disOrders = findViewById<TextView>(R.id.showOrders)

        disOrders.text = "Congratulations!!!\nOrder Placed\n Here is your orders " + ordersOfCustomer.toString() + "\nEnjoy your meal\nThanks for ordering"

    }
}