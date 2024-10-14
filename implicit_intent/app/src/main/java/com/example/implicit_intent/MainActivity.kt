package com.example.implicit_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val implicit_button: Button=findViewById<Button>(R.id.implicit)
        val explicit_button: Button=findViewById<Button>(R.id.explicit)
        explicit_button.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
//        implicit_button.setOnClickListener{
//            val url="https://www.youtube.com"
//            val intent=Intent(Intent.ACTION_VIEW)
//            intent.data= Uri.parse(url)
//            startActivity(intent)
//        }
//        val num="9719835959"
//        implicit_button.setOnClickListener{
//            val intent=Intent(Intent.ACTION_DIAL)
//            intent.data= Uri.parse("tel:$num")
//            startActivity(intent)
//            val num="9719835959"
//            implicit_button.setOnClickListener{
//                val intent=Intent(Intent.ACTION_SENDTO)
//                intent.data= Uri.parse("smsto:$num")
//                val smsText=" Meow meow meow meow?"
//                intent.putExtra("sms_body",smsText)
//                startActivity(intent)
        implicit_button.setOnClickListener{
            val location="geo:0,0?q=1600+Amphiteatre+Parkway,+Mountain+View,+california"
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse(location)
            startActivity(intent)
        }
    }
}