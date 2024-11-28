package com.example.appchooser

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpenChooser=findViewById<Button>(R.id.btnOpenChooser)
        btnOpenChooser.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this awesome content!")
            }

            val chooser = Intent.createChooser(intent, "Share via")
            startActivity(chooser)
        }
    }
}