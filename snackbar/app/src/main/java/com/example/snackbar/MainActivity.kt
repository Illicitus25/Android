package com.example.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun Snackbar11(view: View)
    {
        val snackbar_layout:View=findViewById(R.id.main)
        val Snakebar = Snackbar.make(snackbar_layout,"this is my new Snackbar",Snackbar.LENGTH_INDEFINITE)
        Snakebar.setAction("close") {
            Log.e("MainActivity_Snackbar", "YOu have successfully closed the app")
        }
        Snakebar.setBackgroundTint(Color.YELLOW)
        Snakebar.setActionTextColor(Color.MAGENTA)
        Snakebar.show()
    }
}