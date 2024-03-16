package com.example.assignmentappexam

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignmentappexam.databinding.ActivityExamBinding

class ExamActivity : AppCompatActivity() {

    private var result : Int = 0
    private lateinit var binding : ActivityExamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            val state1 = "Which of the following is an irrational number?"
            val options1 = arrayOf("A. √2", "B. 0.25", "C. 3/4", "D. 1.5")
            val answer1 = 0

            val state2 = "The degree of the polynomial 3x^4 - 2x^3 + 5x^2 - 7 is:"
            val options2 = arrayOf("A. 4", "B. 3", "C. 2", "D. 1")
            val answer2 = 0

            val state3 = "The solution of the system of equations 2x + 3y = 7 and 4x - y = 5 is:"
            val options3 = arrayOf("A. (2, 1)", "B. (1, 2)", "C. (3, 4)", "D. (4, 3)")
            val answer3 = 0

            val state4 = "The roots of the quadratic equation x^2 - 5x + 6 = 0 are:"
            val options4 = arrayOf("A. 2 and 3", "B. 3 and 2", "C. 1 and 6", "D. 6 and 1")
            val answer4 = 0

            val state5 = "In an arithmetic progression, the common difference is 4. If the first term is 3, what is the 10th term?"
            val options5 = arrayOf("A. 39", "B. 43", "C. 47", "D. 51")
            val answer5 = 1

            val state6 = "In a right-angled triangle, if one acute angle is 30°, what is the measure of the other acute angle?"
            val options6 = arrayOf("A. 30°", "B. 45°", "C. 60°", "D. 90°")
            val answer6 = 2

            val state7 = "The coordinates of the midpoint of the line segment joining points (-3, 4) and (5, -2) are:"
            val options7 = arrayOf("A. (1, 1)", "B. (1, -1)", "C. (4, 1)", "D. (4, -1)")
            val answer7 = 0

            val state8 = "In a right-angled triangle, if the length of the hypotenuse is 13 cm and one of the angles is 30°, what is the length of the side opposite the 30° angle?"
            val options8 = arrayOf("A. 6.5 cm", "B. 7.5 cm", "C. 8.5 cm", "D. 9.5 cm")
            val answer8 = 1

            val state9 = "The total surface area of a cube with edge length 4 cm is:"
            val options9 = arrayOf("A. 16 cm²", "B. 64 cm²", "C. 96 cm²", "D. 128 cm²")
            val answer9 = 1

            val state10 = "A die is rolled. What is the probability of getting an odd number?"
            val options10 = arrayOf("A. 1/2", "B. 1/3", "C. 2/3", "D. 1/6")
            val answer10 = 2


        binding.btnResult.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Your result is : $result")
            builder.setPositiveButton("Close" , DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            val dialog = builder.create()
            dialog.show()

        }


        binding.qOne.setOnClickListener {
            question(state1 , options1 , answer1)
        }
        binding.qTwo.setOnClickListener {
            question(state2 , options2 , answer2)
        }
        binding.qThree.setOnClickListener {
            question(state3 , options3 , answer3)
        }
        binding.qfour.setOnClickListener {
            question(state4 , options4 , answer4)
        }
        binding.qfive.setOnClickListener {
            question(state5 , options5 , answer5)
        }
        binding.qSix.setOnClickListener {
            question(state6 , options6 , answer6)
        }
        binding.qSeven.setOnClickListener {
            question(state7 , options7 , answer7)
        }
        binding.qEight.setOnClickListener {
            question(state8 , options8 , answer8)
        }
        binding.qNine.setOnClickListener {
            question(state9 , options9 , answer9)
        }
        binding.qTen.setOnClickListener {
            question(state10 , options10 , answer10)
        }


    }

    private fun question(qStatement : String, array : Array<String>, answer : Int ) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(qStatement)
        builder.setSingleChoiceItems(array , 0 , DialogInterface.OnClickListener { dialog, which ->
            if(which==answer) {
                result++

            }
        }).setNegativeButton("Cancel" , DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        }).setPositiveButton("Submit" , DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        val dialog = builder.create()
        dialog.show()
    }

}
