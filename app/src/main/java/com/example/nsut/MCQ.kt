package com.example.nsut

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MCQ : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mcq)

        val btn1 = findViewById<Button>(R.id.q1)
        val btn2 = findViewById<Button>(R.id.q2)
        val btn3 = findViewById<Button>(R.id.q3)
        val btn4 = findViewById<Button>(R.id.q4)
        val exit = findViewById<Button>(R.id.exit)
        val submit = findViewById<Button>(R.id.submit)

        btn1.setOnClickListener {

            val option = arrayOf("Breathing", "Photosynthesis", "Sleeping", "Jumping")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("What is the name of the process by which plants make their own food?")

            builder.setSingleChoiceItems(option,0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You clicked on ${option[which]}", Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNegativeButton("Back", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()

        }

        btn2.setOnClickListener {

            val options = arrayOf("Oxygen", "Nitrogen", "Carbon Dioxide", "All of the above")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("What do plants take from the air to make their food?")

            builder.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNegativeButton("Back", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()

        }

        btn3.setOnClickListener {

            val option = arrayOf("Root", "Leaves", "Stem", "Flowers")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which part of the plant takes in sunlight for making food?")


            builder.setSingleChoiceItems(option,0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You clicked on ${option[which]}", Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNegativeButton("Back", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()

        }

        btn4.setOnClickListener {

            val option1 = arrayOf("Red", "Blue", "Green", "Yellow")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("What is the main color of the leaves that helps plants make food?")


            builder.setSingleChoiceItems(option1,0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You clicked on ${option1[which]}", Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNegativeButton("Back", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()

        }

        exit.setOnClickListener {

            val intent = Intent(this@MCQ, homepage::class.java)
            startActivity(intent)
        }

        submit.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure ?")

            builder1.setMessage("Want to submit the answer..")
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Thanks for the submission", Toast.LENGTH_SHORT).show()
                var dialog = Dialog(this)
//                dialog.setContentView(R.layout.thanks_logo)
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            builder1.show()
        }



    }
}