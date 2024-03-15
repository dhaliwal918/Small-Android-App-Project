package com.example.dialogbox_and_itstypes

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogbox_and_itstypes.databinding.ActivityMainBinding

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

        binding.btnType1.setOnClickListener {
           val builder1 =  AlertDialog.Builder(this)
            builder1.setTitle("Title")
            builder1.setMessage("This is the message")
            builder1.setPositiveButton("Positive", DialogInterface.OnClickListener { dialog, which ->
                binding.txtDisplay.text = "Builder1 Positive"
            }).setNegativeButton("Negative" , DialogInterface.OnClickListener { dialog, which ->
                binding.txtDisplay.text = "Builder1 Negative"
            })

            val dialog = builder1.create()
            dialog.show()

        }


        binding.btnType2.setOnClickListener {
            val option = arrayOf("Mango" , "Banana" , "Apple" , "Chickoo")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Select one of the")
            builder2.setSingleChoiceItems(option , 0 , DialogInterface.OnClickListener { dialog, which ->
                binding.txtDisplay.text = option[which]
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext , "Submitted" , Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel" , DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext , "Cancelled" , Toast.LENGTH_SHORT).show()
                binding.txtDisplay.text = null
            })
            builder2.show()


        }


        binding.btnType3.setOnClickListener {
            val option = arrayOf("C" , "C++" , "Java" , "Lua" , "Python" , "JavaScript" , "None of the above")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Select one of the")
            builder3.setMultiChoiceItems(option , null , DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(applicationContext , "${option[which]}" , Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext , "Submitted" , Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel" , DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext , "Cancelled" , Toast.LENGTH_SHORT).show()
                binding.txtDisplay.text = null
            })
            builder3.show()


        }



    }
}