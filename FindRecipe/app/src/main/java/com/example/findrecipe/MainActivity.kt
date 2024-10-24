package com.example.findrecipe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutButton = findViewById<LinearLayout>(R.id.flash1)
        layoutButton.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Butter Chicken")
            intent.putExtra("src", R.drawable.butterchicken)
            intent.putExtra(
                "requirements", "Boneless chicken: 500g\n" +
                        "Butter: 3 tbsp\n" +
                        "Tomato puree: 1 cup\n" +
                        "Fresh cream: ½ cup\n" +
                        "Garam masala: 1 tsp\n" +
                        "Ginger-garlic paste: 1 tbsp\n" +
                        "Red chili powder: 1 tsp\n" +
                        "Fenugreek leaves: 1 tsp\n" +
                        "Salt: To taste"
            )
            intent.putExtra(
                "steps",
                "Marinate chicken with yogurt, chili powder, and salt. Leave for 1 hour.\n" +
                        "Heat butter in a pan, add marinated chicken, and sauté until half-cooked.\n" +
                        "In the same pan, add ginger-garlic paste and tomato puree. Cook for 10 minutes.\n" +
                        "Add red chili powder, garam masala, and fenugreek leaves. Cook for 5 more minutes.\n" +
                        "Stir in the cream and simmer until chicken is fully cooked and the gravy thickens."
            )
            intent.putExtra(
                "tips",
                "Cook the chicken on medium heat and simmer gently after adding the cream to avoid curdling."
            )
            startActivity(intent)
        }
        val layoutButton2 = findViewById<LinearLayout>(R.id.flash2)
        layoutButton2.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Rasam")
            intent.putExtra("src", R.drawable.rasam)
            intent.putExtra("requirements", "Tamarind pulp: 2 tbsp\n" +
                    "Tomato: 1, chopped\n" +
                    "Mustard seeds: 1 tsp\n" +
                    "Cumin seeds: 1 tsp\n" +
                    "Curry leaves: A few\n" +
                    "Red chili powder: ½ tsp\n" +
                    "Coriander powder: 1 tsp\n" +
                    "Salt: To taste\n")
            intent.putExtra("steps", "Boil tamarind pulp with chopped tomatoes.\n" +
                    "Heat oil, add mustard seeds, cumin seeds, curry leaves, and red chili powder. Add this tempering to the tamarind mixture.\n" +
                    "Simmer for 10 minutes and serve hot.")
            intent.putExtra("tips", "Strain the tamarind pulp to avoid any fibers.")
            startActivity(intent)
        }
        val layoutButton3= findViewById<LinearLayout>(R.id.flash3)
        layoutButton3.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Tom Yum Soup")
            intent.putExtra("src", R.drawable.tomyum)
            intent.putExtra("requirements", "Shrimp: 200g\n" +
                    "Lemongrass: 2 stalks, crushed\n" +
                    "Lime leaves: 4\n" +
                    "Mushrooms: 1 cup, sliced\n" +
                    "Fish sauce: 2 tbsp\n" +
                    "Lime juice: 2 tbsp")
            intent.putExtra("steps", "Boil water with lemongrass and lime leaves.\n" +
                    "Add mushrooms and shrimp. Cook until shrimp turns pink.\n" +
                    "Add fish sauce and lime juice. Serve hot.")
            intent.putExtra("tips", "Do not overcook the shrimp, as they can become rubbery.")
            startActivity(intent)
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
                val intent=Intent(this, AboutUs::class.java)
                startActivity(intent)
                return true
            }

            R.id.contactus -> {
                val intent=Intent(this,contactUs::class.java)
                startActivity(intent)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}