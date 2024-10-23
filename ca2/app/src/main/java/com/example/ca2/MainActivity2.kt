package com.example.ca2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("name")
        val numberOfPeople = intent.getStringExtra("number")
        val date = intent.getStringExtra("date")
        val naam=findViewById<TextView>(R.id.name)
        val datee=findViewById<TextView>(R.id.date)
        val number=findViewById<TextView>(R.id.number)
        naam.text="Name: $name"
        datee.text="Date: $date"
        number.text="Seats: ${numberOfPeople}"
    }
}