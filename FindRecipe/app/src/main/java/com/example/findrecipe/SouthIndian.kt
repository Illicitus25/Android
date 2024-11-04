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

class SouthIndian : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_south_indian)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layoutButton = findViewById<LinearLayout>(R.id.flash1)
        layoutButton.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            intent.putExtra("name", "Masala Dosa")
            intent.putExtra("src", R.drawable.masaladosa)
            intent.putExtra(
                "requirements", "Rice: 2 cups\n" +
                        "Urad dal: ½ cup\n" +
                        "Potatoes: 2, boiled and mashed\n" +
                        "Onion: 1, chopped\n" +
                        "Green chilies: 2, chopped\n" +
                        "Mustard seeds: 1 tsp\n" +
                        "Turmeric powder: ½ tsp\n" +
                        "Salt: To taste\n"
            )
            intent.putExtra(
                "steps",
                "Soak rice and urad dal separately for 6 hours. Grind into a batter and ferment overnight.\n" +
                        "Heat oil, add mustard seeds, onions, green chilies, and turmeric. Add mashed potatoes and mix well.\n" +
                        "Spread batter on a hot pan, cook until crisp, and add the potato filling. Fold and serve."
            )
            intent.putExtra(
                "tips",
                "Ferment the batter in a warm place for best results."
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
            intent.putExtra("name", "Sambar")
            intent.putExtra("src", R.drawable.sambar)
            intent.putExtra("requirements", "Toor dal: 1 cup\n" +
                    "Tamarind pulp: 2 tbsp\n" +
                    "Drumstick: 1, chopped\n" +
                    "Carrot: 1, chopped\n" +
                    "Sambar powder: 2 tbsp\n" +
                    "Mustard seeds: 1 tsp\n" +
                    "Curry leaves: A few\n" +
                    "Salt: To taste\n")
            intent.putExtra("steps", "Pressure cook toor dal with turmeric.\n" +
                    "In a pot, cook vegetables with tamarind pulp and sambar powder.\n" +
                    "Add cooked dal, bring to a boil, and temper with mustard seeds and curry leaves.\n" +
                    "Skewer the paneer and grill on high heat until slightly charred.\n")
            intent.putExtra("tips", "Add a little jaggery for sweetness to balance the tanginess.")
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