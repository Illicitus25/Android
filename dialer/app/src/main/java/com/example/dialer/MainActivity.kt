package com.example.dialer

import android.os.Bundle
<<<<<<< HEAD
=======
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton
>>>>>>> badfaa9 (Git Commit)
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
=======
        val switchButton: ImageButton = findViewById(R.id.call)
        switchButton.setOnClickListener{{
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }}
>>>>>>> badfaa9 (Git Commit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}