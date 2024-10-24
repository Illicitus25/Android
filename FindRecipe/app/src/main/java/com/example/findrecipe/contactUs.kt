package com.example.findrecipe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class contactUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_us)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.northIndian -> {
                val intent = Intent(this, northIndian::class.java)
                startActivity(intent)
                return true
            }

            R.id.southIndian -> {
                val intent = Intent(this, SouthIndian::class.java)
                startActivity(intent)
                return true
            }

            R.id.thaiDish -> {
                val intent = Intent(this, Thai::class.java)
                startActivity(intent)
                return true
            }

            R.id.aboutus -> {
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.contactus -> {
                Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}