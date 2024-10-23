package com.example.ca2

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioGroup: RadioGroup = findViewById(R.id.group)
        val btn: Button = findViewById(R.id.changeLang)
        val submit: Button = findViewById(R.id.submit)
        btn.setOnClickListener {
            val selectedId: Int = radioGroup.checkedRadioButtonId
            when (selectedId) {
                R.id.hindi->{
                    setLocale("hi")
                }
                R.id.english->{
                    setLocale("en")
                }
                R.id.french->{
                    setLocale("fr")
                }
                else->{
                    setLocale("en")
                }
            }
            }
        submit.setOnClickListener{
            Toast.makeText(this,"Table Reserved Successfully",Toast.LENGTH_SHORT).show()
            val name: EditText = findViewById(R.id.name)
            val number: EditText = findViewById(R.id.number)
            val date: EditText = findViewById(R.id.date)
            val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("number",number.text.toString())
            intent.putExtra("date",date.text.toString())
            startActivity(intent)
        }
        }

    fun setLocale(language:String){
        val locale=Locale(language)
        Locale.setDefault(locale)
        val config=Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
        recreate()
    }
}