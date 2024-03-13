package com.example.viewbinding

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        if(binding.checkBox.isChecked) {
//            binding.btnSignUp.setEnabled(true)
//        }else {
//            binding.btnSignUp.setEnabled(false)
//        }

        binding.btnSignUp.setOnClickListener {
            if(binding.checkBox.isChecked){
                Toast.makeText(applicationContext , "Successfully Sign In" , Toast.LENGTH_SHORT).show()
            }else {
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(applicationContext , "Please accept the T&C" , Toast.LENGTH_SHORT).show()
            }

        }
    }
}