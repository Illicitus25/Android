package com.example.localizationapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.applocalize2.R
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var buttonHindi: Button
    private lateinit var buttonEnglish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        buttonHindi = findViewById(R.id.button_hindi)
        buttonEnglish = findViewById(R.id.button_english)

        // Set the text in Hindi when Hindi button is clicked
        buttonHindi.setOnClickListener {
            setLocale("hi")
        }

        // Set the text in English when English button is clicked
        buttonEnglish.setOnClickListener {
            setLocale("en")
        }
    }

    private fun setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        // Restart the activity to apply changes
        val refresh = Intent(this, MainActivity::class.java)
        startActivity(refresh)
        finish()
    }
}
