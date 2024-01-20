package com.example.nsut

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    lateinit var database : DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn = findViewById<Button>(R.id.signupbtn)
        val etname  = findViewById<TextInputEditText>(R.id.name)
        val etusername = findViewById<TextInputEditText>(R.id.edtUsernametv)
        val etemail = findViewById<TextInputEditText>(R.id.email)
        val pass = findViewById<TextInputEditText>(R.id.edtPasswordtv)

        btn.setOnClickListener {

            val name = etname.text.toString()
            val uniqueId = etusername.text.toString()
            val email = etemail.text.toString()
            val password = pass.text.toString()

            val user = User(name, email, password, uniqueId)
//            val userKey = database.child("user").push().key

            database = FirebaseDatabase.getInstance().getReference("user")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
//            database.child(userKey!!).setValue(user).addOnSuccessListener {
            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                val intent  = Intent(this@SignUp, homepage::class.java )
                startActivity(intent)

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }


//            val intent  = Intent(this@SignUp, homepage::class.java )
//            startActivity(intent)

        val signIn = findViewById<TextView>(R.id.signin)
        signIn.setOnClickListener {
            val openSignInActivity = Intent(this, SignIn::class.java)
            startActivity(openSignInActivity)
        }

    }
}