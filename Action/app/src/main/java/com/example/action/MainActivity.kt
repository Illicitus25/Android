package com.example.action

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.itema -> {
                Toast.makeText(this, "Item A", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.itemb -> {
                Toast.makeText(this, "Item B", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.itemc -> {
                Toast.makeText(this, "Item C", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.aboutus -> {
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.contactus -> {
                Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show()
                return true
            }else -> super.onOptionsItemSelected(item)
        }
        }
    }