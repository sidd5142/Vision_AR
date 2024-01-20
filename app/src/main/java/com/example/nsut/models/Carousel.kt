package com.example.nsut.models

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.nsut.R
import com.example.nsut.SignIn
import com.example.nsut.adapters.ImageAdapter
import java.util.UUID

class Carousel : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)


        val btn = findViewById<Button>(R.id.btn1)

        btn.setOnClickListener {
            val intent = Intent(this@Carousel, SignIn::class.java)

            startActivity(intent)
        }

        val imageRV = findViewById<RecyclerView>(R.id.imageRV)

        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "https://fastly.picsum.photos/id/866/500/500.jpg?hmac=FOptChXpmOmfR5SpiL2pp74Yadf1T_bRhBF1wJZa9hg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://fastly.picsum.photos/id/270/500/500.jpg?hmac=MK7XNrBrZ73QsthvGaAkiNoTl65ZDlUhEO-6fnd-ZnY"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://fastly.picsum.photos/id/320/500/500.jpg?hmac=2iE7TIF9kIqQOHrIUPOJx2wP1CJewQIZBeMLIRrm74s"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://fastly.picsum.photos/id/798/500/500.jpg?hmac=Bmzk6g3m8sUiEVHfJWBscr2DUg8Vd2QhN7igHBXLLfo"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://fastly.picsum.photos/id/95/500/500.jpg?hmac=0aldBQ7cQN5D_qyamlSP5j51o-Og4gRxSq4AYvnKk2U"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://fastly.picsum.photos/id/778/500/500.jpg?hmac=jZLZ6WV_OGRxAIIYPk7vGRabcAGAILzxVxhqSH9uLas"
            )
        )

        val imageAdapter = ImageAdapter()
        imageRV.adapter = imageAdapter
        imageAdapter.submitList(imageList)


    }
}

//package com.example.nsut.models
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
//import com.example.nsut.R
//import com.example.nsut.SignIn
//import com.example.nsut.adapters.ImageAdapter
//import java.util.UUID
//
//class Carousel : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_carousel)
//
//        val btn = findViewById<Button>(R.id.btn1)
//
//        btn.setOnClickListener {
//            val intent = Intent(this@Carousel, SignIn::class.java)
//            startActivity(intent)
//        }
//
//        val imageRV = findViewById<RecyclerView>(R.id.imageRV)
//
//        val imageList = arrayListOf(
//            ImageItem(UUID.randomUUID().toString(), R.drawable.App1),
//            ImageItem(UUID.randomUUID().toString(), R.drawable.App2),
//            ImageItem(UUID.randomUUID().toString(), R.drawable.App3),
//            ImageItem(UUID.randomUUID().toString(), R.drawable.App4),
////            ImageItem(UUID.randomUUID().toString(), R.drawable.app5),
////            ImageItem(UUID.randomUUID().toString(), R.drawable.app6)
//        )
//
//        val imageAdapter = ImageAdapter()
//        imageRV.adapter = imageAdapter
//        imageAdapter.submitList(imageList)
//    }
//}
