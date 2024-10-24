package com.example.akshadeep

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.akshadeep.R

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var confirmationTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var  confirmationTextView = findViewById<TextView>(R.id.confirmationTextView)

        val name = intent.getStringExtra("NAME") ?: "N/A"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "N/A"
        val country = intent.getStringExtra("COUNTRY") ?: "N/A"

        confirmationTextView.text = "Name: $name\nEmail: $email\nGender: $gender\nCountry: $country"
    }
}
