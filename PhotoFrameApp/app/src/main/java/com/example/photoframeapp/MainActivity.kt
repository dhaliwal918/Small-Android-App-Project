package com.example.photoframeapp

import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var currentImage : Int = 0
    private lateinit var image : ImageView
    private val arrayOfNames = arrayOf("Doraemon", "Nobita Nobi" , "Shizuka Minamoto" , "Takeshi Goda (Gian)")

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



        val forward = findViewById<ImageButton>(R.id.imgForw)
        val backward = findViewById<ImageButton>(R.id.imgPrev)


        forward.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString , "id" , packageName)

            image  = findViewById(idCurrentImageInt)
            image.alpha = 0f

            ++currentImage

            currentImage = (4+currentImage)%4

            binding.textName.text = arrayOfNames[currentImage]

            val idCurrentImageToShow = "pic$currentImage"

            val idShowImageInt = this.resources.getIdentifier(idCurrentImageToShow , "id" , packageName)

            image  = findViewById(idShowImageInt)
            image.alpha = 1f
        }
        

        backward.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString , "id" , packageName)

            image  = findViewById(idCurrentImageInt)
            image.alpha = 0f

             --currentImage

            currentImage = (4+currentImage)%4

            binding.textName.text = arrayOfNames[currentImage]

            val idCurrentImageToShow = "pic$currentImage"

            val idShowImageInt = this.resources.getIdentifier(idCurrentImageToShow , "id" , packageName)

            image  = findViewById(idShowImageInt)
            image.alpha = 1f

        }


    }
}


