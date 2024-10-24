package com.example.findrecipe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Recipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name=intent.getStringExtra("name")
        val src=intent.getIntExtra("src",R.drawable.sample_recipe_image)
        val requirements=intent.getStringExtra("requirements")
        val steps=intent.getStringExtra("steps")
        val tips=intent.getStringExtra("tips")
        val recipeTitle=findViewById<TextView>(R.id.title)
        recipeTitle.text=name
        val recipeImage=findViewById<ImageView>(R.id.imageView)
        recipeImage.setImageResource(src)
        val recipeRequirements=findViewById<TextView>(R.id.requirements)
        recipeRequirements.text=requirements
        val recipeSteps=findViewById<TextView>(R.id.steps)
        recipeSteps.text=steps
        val recipeTips=findViewById<TextView>(R.id.tips)
        recipeTips.text=tips

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