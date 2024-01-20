package com.example.nsut

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class homepage : AppCompatActivity() {

    private val sharedPreferencesFileName = "userPreferences"
    private val isLoggedInKey = "isLoggedIn"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val name = intent.getStringExtra(SignIn.KEY2)
        val mail = intent.getStringExtra(SignIn.KEY1)
        val userId = intent.getStringExtra(SignIn.KEY3)

        var qz = findViewById<Button>(R.id.quizzesbtn)
        val username = findViewById<TextView>(R.id.username)

        username.text = "Hey $name !"

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

        val logout = findViewById<Button>(R.id.logout)

        logout.setOnClickListener {
            clearUserSession()
            val intent = Intent(this@homepage, SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Override the back button press to do nothing (disable going back)
        // You can also implement custom behavior if needed
    }

    private fun clearUserSession() {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(isLoggedInKey, false)
        editor.apply()
    }
}