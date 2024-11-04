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

class northIndian : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_north_indian)
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
            intent.putExtra("name", "Rogan Josh")
            intent.putExtra("src", R.drawable.roganjosh)
            intent.putExtra("requirements", "Lamb: 500g\n" +
                    "Yogurt: 1 cup\n" +
                    "Ghee: 3 tbsp\n" +
                    "Onion: 2, sliced\n" +
                    "Garlic paste: 1 tbsp\n" +
                    "Kashmiri chili powder: 2 tsp\n" +
                    "Garam masala: 1 tsp\n" +
                    "Fennel powder: 1 tsp\n" +
                    "Salt: To taste\n")
            intent.putExtra("steps", "Heat ghee and sauté onions until golden brown.\n" +
                    "Add garlic paste and lamb, searing the meat until browned.\n" +
                    "Add yogurt, chili powder, and garam masala. Cook on low heat for 30 minutes, stirring occasionally.\n" +
                    "Add fennel powder and simmer for another 10-15 minutes until meat is tender.\n")
            intent.putExtra("tips", "Keep the heat low to prevent the yogurt from splitting. Slow cooking enhances the flavor.")
            startActivity(intent)
        }
        val layoutButton3= findViewById<LinearLayout>(R.id.flash3)
        layoutButton3.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Paneer Tikka")
            intent.putExtra("src", R.drawable.paneertikka)
            intent.putExtra("requirements", "Paneer (Indian cottage cheese): 250g\n" +
                    "Yogurt: ½ cup\n" +
                    "Ginger-garlic paste: 1 tbsp\n" +
                    "Red chili powder: 1 tsp\n" +
                    "Garam masala: ½ tsp\n" +
                    "Lemon juice: 1 tbsp\n" +
                    "Oil: 1 tbsp\n")
            intent.putExtra("steps", "Cut paneer into cubes.\n" +
                    "In a bowl, mix yogurt, ginger-garlic paste, red chili powder, garam masala, lemon juice, and salt.\n" +
                    "Coat paneer with the marinade and let it sit for 30 minutes.\n" +
                    "Skewer the paneer and grill on high heat until slightly charred.\n")
            intent.putExtra("tips", "Ensure the paneer is not too soft, and press it gently while grilling to avoid breaking.")
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