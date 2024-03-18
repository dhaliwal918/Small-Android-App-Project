package com.example.customalertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.customalertdialog.R.*
import com.example.customalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        dialog = Dialog(this)
        dialog.setContentView(layout.custom_dialogue_box)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_dialog_box))

        val feedbackID = dialog.findViewById<Button>(id.btnFeedback)
        val goodID = dialog.findViewById<Button>(id.btnGood)

        feedbackID.setOnClickListener {
            Toast.makeText(applicationContext , "Feedback sent" , Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        goodID.setOnClickListener {
            Toast.makeText(applicationContext , "Thanks" , Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        binding.btnClickMe.setOnClickListener {
            dialog.show()
        }


    }
}