package com.example.all3menus

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val image=findViewById<ImageView>(R.id.imageview)
        registerForContextMenu(image)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener{ view ->
            showPopupMenu(view)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nextpage -> {
                val textView=findViewById<TextView>(R.id.textview)
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("Data", "${textView.text}")
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.contextmenu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.dog->{
                findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.dog)
                true
            }
            R.id.cat->{
                findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.cat)
                true
            }
            R.id.duck->{
                findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.duck)
                true
            }
            else->super.onContextItemSelected(item)
        }
    }
    private fun showPopupMenu(view: View){
        val popupMenu = PopupMenu(this,view)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.red -> {
                    val textView = findViewById<TextView>(R.id.textview)
                    textView.setTextColor(ContextCompat.getColor(this, R.color.red))
                    true
                }
                R.id.blue -> {
                    val textView = findViewById<TextView>(R.id.textview)
                    textView.setTextColor(ContextCompat.getColor(this, R.color.blue))
                    true
                }
                R.id.green -> {
                    val textView = findViewById<TextView>(R.id.textview)
                    textView.setTextColor(ContextCompat.getColor(this, R.color.green))
                    true
                }
                R.id.dog->{
                    val textView = findViewById<TextView>(R.id.textview)
                    textView.text="Dog"
                    true
                }
                R.id.cat->{
                    val textView = findViewById<TextView>(R.id.textview)
                    textView.text="Cat"
                    true
                }
                R.id.duck->{
                    val textView = findViewById<TextView>(R.id.textview)
                    textView.text="Duck"
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}