package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.ContextMenu
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

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
        val username: EditText = findViewById<EditText>(R.id.username)
        val password: EditText = findViewById<EditText>(R.id.password)
        val btn: Button = findViewById<Button>(R.id.button)
        val chkbsk: CheckBox = findViewById<CheckBox>(R.id.checkbox)
        chkbsk.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                btn.visibility = View.VISIBLE
                Toast.makeText(this, "T&C Accepted", Toast.LENGTH_SHORT).show()
            } else {
                btn.visibility = View.INVISIBLE
            }
        }
        btn.setOnClickListener {
            val userId = username.text.toString()
            val userPass = password.text.toString()
            if (userId == "admin" && userPass == "12345") {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,MainActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show()
            }
        }
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


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
            builder.setMessage("Do you want to exit?")
            builder.setPositiveButton("Yes") { _, _ ->
                finishAffinity()
            }
            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

        val dialog = builder.create()
        dialog.show()
    }
    private fun closeApp(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Do you want to exit?")
        builder.setPositiveButton("Yes") { _, _ ->
            finishAffinity()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}