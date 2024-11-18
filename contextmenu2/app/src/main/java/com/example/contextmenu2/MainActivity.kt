package com.example.contextmenu2

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
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
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener{ view ->
            showPopupMenu(view)
        }
    }
    private fun showPopupMenu(view: View){
        val popupMenu = PopupMenu(this,view)
        popupMenu.inflate(R.menu.contextmenu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.edit -> {
                    val textView = findViewById<TextView>(R.id.textView)
                    textView.text = "Hello Friends"
                    true
                }
                R.id.Delete -> {
                    val textView = findViewById<TextView>(R.id.textView)
                    textView.text = ""
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}