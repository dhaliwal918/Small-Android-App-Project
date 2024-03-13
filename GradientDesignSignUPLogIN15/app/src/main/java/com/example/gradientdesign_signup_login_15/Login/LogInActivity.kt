package com.example.gradientdesign_signup_login_15.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gradientdesign_signup_login_15.R
import com.example.gradientdesign_signup_login_15.SignUpActivity

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val signup = findViewById<Button>(R.id.btnSignup)

        signup.setOnClickListener {
            val intent = Intent(applicationContext , SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}