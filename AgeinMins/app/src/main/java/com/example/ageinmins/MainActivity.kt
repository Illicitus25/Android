    package com.example.ageinmins

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.Locale

    class MainActivity : AppCompatActivity() {
    private var selectedDate:TextView?=null
        private var TimeinMins:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val datepicker= findViewById<Button>(R.id.btn)
        selectedDate=findViewById(R.id.op1)
        TimeinMins=findViewById(R.id.op2)
        datepicker.setOnClickListener{
            clickDatePicker()
        }
    }
    fun clickDatePicker(){
        val myCalendar= Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{ view,year,month,day->
            val str="$day/${month+1}/$year"
            selectedDate?.text=str
            val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date=sdf.parse(str)
            val timeInMinutes=date.time/60000
            val currentTime=sdf.parse(sdf.format(System.currentTimeMillis()))
            val difference=(currentTime.time/60000)-timeInMinutes
            TimeinMins?.text=difference.toString()
        },year,month,day).show()
    }
}