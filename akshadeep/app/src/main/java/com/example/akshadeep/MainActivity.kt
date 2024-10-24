package com.example.akshadeep

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import android.content.Intent
import android.widget.ArrayAdapter
import com.example.akshadeep.ConfirmationActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var nameE: EditText
    private lateinit var emailE: EditText
    private lateinit var passwordE: EditText
    private lateinit var radioGrp: RadioGroup
    private lateinit var countrySpner: Spinner
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nameE = findViewById(R.id.name)
        emailE = findViewById(R.id.email)
        passwordE = findViewById(R.id.passw)
        radioGrp = findViewById(R.id.radiogrp)
        countrySpner = findViewById(R.id.country_spinner)
        submitBtn = findViewById(R.id.sumbitbtn)

        val countries = arrayOf("Select Country", "India","USA", "Canada", "UK", "Australia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpner.adapter = adapter

        submitBtn.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {
        val name = nameE.text.toString().trim()
        val email = emailE.text.toString().trim()
        val password = passwordE.text.toString().trim()
        val selectedGenderId = radioGrp.checkedRadioButtonId
        val country = countrySpner.selectedItem.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || selectedGenderId == -1 || country == "Select Country") {
            Snackbar.make(submitBtn, "Please fill all fields correctly", Snackbar.LENGTH_LONG).show()
            return
        }

        val selectedGender: RadioButton = findViewById(selectedGenderId)
        val gender = selectedGender.text.toString()

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("NAME", name)
        intent.putExtra("EMAIL", email)
        intent.putExtra("PASSWORD", password)
        intent.putExtra("GENDER", gender)
        intent.putExtra("COUNTRY", country)


        startActivity(intent)
        Toast.makeText(this, "Submission Successful", Toast.LENGTH_SHORT).show()
    }
}
