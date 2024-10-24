package com.example.findrecipe

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

class Thai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thai)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layoutButton = findViewById<LinearLayout>(R.id.flash1)
        layoutButton.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Pad Thai")
            intent.putExtra("src", R.drawable.padthai)
            intent.putExtra(
                "requirements", "Rice noodles: 200g\n" +
                        "Shrimp: 100g\n" +
                        "Tofu: 100g, cubed\n" +
                        "Bean sprouts: 1 cup\n" +
                        "Tamarind paste: 2 tbsp\n" +
                        "Fish sauce: 2 tbsp\n" +
                        "Peanuts: ¼ cup, crushed\n" +
                        "Eggs: 2\n"
            )
            intent.putExtra(
                "steps",
                "Soak rice noodles in warm water for 10 minutes. Drain.\n" +
                        "Stir-fry shrimp and tofu. Add tamarind paste, fish sauce, and beaten eggs.\n" +
                        "Toss in noodles and bean sprouts. Garnish with peanuts.\n"
            )
            intent.putExtra(
                "tips",
                "Don’t over-soak noodles; they should be soft but firm when stir-fried."
            )
            startActivity(intent)
        }
        val layoutButton2 = findViewById<LinearLayout>(R.id.flash2)
        layoutButton2.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Green Curry")
            intent.putExtra("src", R.drawable.greencurry)
            intent.putExtra("requirements", "Green curry paste: 2 tbsp\n" +
                    "Coconut milk: 1 can\n" +
                    "Chicken breast: 200g, cubed\n" +
                    "Bamboo shoots: 100g\n" +
                    "Eggplant: 1, diced\n" +
                    "Fish sauce: 1 tbsp\n" +
                    "Basil leaves: A handful")
            intent.putExtra("steps", "Heat curry paste in a pan, add coconut milk, and bring to a simmer.\n" +
                    "Add chicken, bamboo shoots, and eggplant. Cook until tender.\n" +
                    "Stir in fish sauce and basil leaves. Simmer for another 5 minutes.")
            intent.putExtra("tips", "Adjust the curry paste according to your spice tolerance.")
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