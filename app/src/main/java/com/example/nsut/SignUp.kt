package com.example.nsut

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn = findViewById<Button>(R.id.signupbtn)

//        btn.setOnClickListener {
//            val intent  = Intent(this@SignUp, )
//        }
    }
}