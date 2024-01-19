package com.example.nsut

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MCQ : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mcq)

        val btn1 = findViewById<Button>(R.id.q1)
        val btn2 = findViewById<Button>(R.id.q2)
        val btn3 = findViewById<Button>(R.id.q3)
        val btn4 = findViewById<Button>(R.id.q4)


//        btn1.setOnClickListener(this)
//        btn2.setOnClickListener(this)
//        btn3.setOnClickListener(this)
//        btn4.setOnClickListener(this)

    }

//    @Override
//    public fun onClick(View v) {
//        switch(v.getId())
//        {
//            case R.id.q1 :
//
//        }

}