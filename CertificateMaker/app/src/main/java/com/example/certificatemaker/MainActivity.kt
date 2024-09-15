package com.example.certificatemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val welcome: TextView= findViewById(R.id.welcome)
        val name: EditText=findViewById(R.id.name)
        val age: EditText=findViewById(R.id.age)
        val address: EditText=findViewById(R.id.address)
        val submit: Button=findViewById(R.id.submit)
        val checkBox: CheckBox=findViewById(R.id.checkBox)
        val radioGroup: RadioGroup=findViewById(R.id.group)
        checkBox.setOnCheckedChangeListener
        if(checkBox.isChecked){
            submit.visibility=android.view.view.VISIBLE
        }
    }
}