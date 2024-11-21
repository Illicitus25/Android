package com.example.customalert

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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
            showCustomAlertBox()
    }
    private fun  showCustomAlertBox(){
        val dialogView= LayoutInflater.from(this).inflate(R.layout.customalert,null)
        val positiveButton=dialogView.findViewById<Button>(R.id.positive)
        val negativeButton=dialogView.findViewById<Button>(R.id.negative)
        val title=dialogView.findViewById<TextView>(R.id.title)
        val message=dialogView.findViewById<TextView>(R.id.message)
        title.text="Continue?"
        message.text="are you sure you want to continue to the app?"
        positiveButton.text="Yes"
        negativeButton.text="No"
        val dialogBuilder= AlertDialog.Builder(this)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        val dialog=dialogBuilder.create()
        dialog.show()
        positiveButton.setOnClickListener{
            dialog.dismiss()
            val textView=findViewById<TextView>(R.id.textview)
            val name=dialogView.findViewById<EditText>(R.id.edit)
            textView.text="Welcome ${name.text}"
        }
        negativeButton.setOnClickListener {
            finishAffinity()
        }
    }
}