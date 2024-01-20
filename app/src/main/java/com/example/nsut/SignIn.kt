package com.example.nsut

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {

    companion object{
        const val KEY1 = "com.example.database.SignIn.mail"
        const val KEY2 = "com.example.database.SignIn.name"
        const val KEY3 = "com.example.database.SignIn.id"
    }

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btn = findViewById<Button>(R.id.signinbtn)
        val username = findViewById<TextInputEditText>(R.id.edtUsernametv)
        val pass = findViewById<TextInputEditText>(R.id.edtPasswordtv)

        btn.setOnClickListener {

            val uniqueId = username.text.toString()
            val password = pass.text.toString()

            if (uniqueId.isNotEmpty() && password.isNotEmpty()){

                readData(uniqueId,password)
            }
            else{
                Toast.makeText(this, "Please Enter the Empty Fields", Toast.LENGTH_SHORT).show()
            }
//            val intent = Intent(this@SignIn, SignUp::class.java)
//
//            startActivity(intent)
        }

        val signup = findViewById<TextView>(R.id.signup)
        signup.setOnClickListener {
            val openSignInActivity = Intent(this, SignUp::class.java)
            startActivity(openSignInActivity)
        }
    }

    private fun readData(uniqueId: String, password: String) {

        database = FirebaseDatabase.getInstance().getReference("user")
        database.child(uniqueId).get().addOnSuccessListener {

            if (it.exists()) {
                //welcome user in your app with intent and also pass
                val email = it.child("email").value
                val name = it.child("name").value
                val userId = it.child("uniqueId").value

                val intentWelcome = Intent(this, homepage::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, userId.toString())
                startActivity(intentWelcome)

            } else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}