package com.example.gradientdesign_signup_login_15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import com.example.gradientdesign_signup_login_15.Login.LogInActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val login = findViewById<Button>(R.id.btnlogin)


        login.setOnClickListener {
            intent = Intent(applicationContext, LogInActivity::class.java)
            startActivity(intent)
        }


    }
}