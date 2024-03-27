package com.example.test

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class LoginActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailText = findViewById<TextView>(R.id.emailTxt)
        val usernameText = findViewById<TextView>(R.id.usernameTxt)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)

        val username  = editTextUsername.text.toString()

        val btnSignUP = findViewById<Button>(R.id.btnsignup)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnSignUP.setOnClickListener {
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            if (editTextUsername.text.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Empty field", Toast.LENGTH_SHORT).show()
            } else {
                getInfo(editTextUsername.text.toString(), emailText, usernameText)
            }
        }

    }

    private fun getInfo(username: String, emailText: TextView, usernameText: TextView) {

        database = FirebaseDatabase.getInstance().getReference("User")

        database.child(username).get().addOnSuccessListener {
            if (it.exists()) {
                Toast.makeText(applicationContext, "Username exist", Toast.LENGTH_SHORT).show()

                val usernameFD = it.child("username").value
                val emailFD = it.child("email").value
                val pass = it.child("password").value


                Toast.makeText(applicationContext, "Password: ${pass.toString()}", Toast.LENGTH_SHORT).show()

                emailText.text = emailFD.toString()
//                emailText.text = emailFD.toString()
                usernameText.text = usernameFD.toString()
            } else {
                Toast.makeText(applicationContext, "Username not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
        }

        database.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.value
                val email = snapshot.child("User").child("username").value
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })

    }
}






//        database = FirebaseDatabase.getInstance().getReference("User")
//
//
//        database.child(username).get().addOnSuccessListener { dataSnapshot ->
//            if (dataSnapshot.exists()) {
//                val emailFD = dataSnapshot.child("email").value.toString()
//                val passwordFD = dataSnapshot.child("password").value.toString()
//                val usernameFD = dataSnapshot.child("username").value.toString()
//                if (password==passwordFD) {
//                    Toast.makeText(applicationContext, "Match", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(applicationContext, "Not a match", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(applicationContext, "User does not exist", Toast.LENGTH_SHORT).show()
//            }
//        }.addOnFailureListener {
//            Toast.makeText(applicationContext, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
//        }
//
//
//
//    }
//
//}