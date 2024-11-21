package com.example.ca3

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener { view ->
            showPopUpMenu(view)
        }
    }

    private fun showPopUpMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.mango -> {
                    val img = findViewById<ImageView>(R.id.img)
                    img.setImageResource(R.drawable.mango)
                    true
                }

                R.id.banana -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Uh-Oh")
                    builder.setMessage("The item you have selected is not availiable")
                    builder.setPositiveButton("Continue") { dialog, _ ->
                        dialog.dismiss()
                        true
                    }
                    builder.setNegativeButton("Close") { _, _ ->
                        finishAffinity()
                    }
                    val dialog=builder.create()
                    dialog.show()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}