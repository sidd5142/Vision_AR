package com.example.nsut

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btn = findViewById<Button>(R.id.signinbtn)

        btn.setOnClickListener {
            val intent = Intent(this@SignIn, SignUp::class.java)

            startActivity(intent)
        }
    }
}