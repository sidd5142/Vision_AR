package com.example.nsut

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        var qz = findViewById<Button>(R.id.quizzesbtn)

        qz.setOnClickListener {
            val intent = Intent(this@homepage, MCQ::class.java)
            startActivity(intent)
        }

        val vr = findViewById<Button>(R.id.arbtn)

        vr.setOnClickListener {
            val mIntent = packageManager.getLaunchIntentForPackage("com.DefaultCompany.VisionAR")
            if (mIntent != null) {
                try {
                    startActivity(mIntent)
                } catch (err: ActivityNotFoundException) {
                    Toast.makeText(applicationContext, "App is not found", Toast.LENGTH_SHORT)
                        .show()
                }
                startActivity(mIntent)
            } else {
                Toast.makeText(applicationContext, "App is not installed", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}