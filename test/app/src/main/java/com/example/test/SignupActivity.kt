package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var Database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.btnlogin)
        val editTextUsername = findViewById<EditText>(R.id.editTextUserName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            val intent = Intent(applicationContext , LoginActivity::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val email = editTextEmail.text.toString()

            setDataOnDatabase(username , password , email)

            editTextUsername.text.clear()
            editTextEmail.text.clear()
            editTextPassword.text.clear()

        }

    }

    private fun setDataOnDatabase (username : String, password : String, email : String ) {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(applicationContext , "Empty field" , Toast.LENGTH_SHORT).show()
            return
        }
        val user = User(username , email , password )
        Database = FirebaseDatabase.getInstance().getReference("User")

        Database.child(username).setValue(user).addOnSuccessListener {
            Toast.makeText(applicationContext, "Registered Successfully", Toast.LENGTH_SHORT)
                .show()
        }.addOnFailureListener {
            Toast.makeText(applicationContext, "Registered failed", Toast.LENGTH_SHORT)
                .show()
        }
        return
    }

}
