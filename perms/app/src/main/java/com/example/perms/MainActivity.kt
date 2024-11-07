package com.example.perms

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val permissions= arrayOf(android.Manifest.permission.CAMERA,
        android.Manifest.permission.ACCESS_FINE_LOCATION)
    val permissionrequestcode=123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        if(!hasPermissions(permissions)){
            ActivityCompat.requestPermissions(this,permissions,permissionrequestcode)
        }
        else{
            Toast.makeText(this,"Permission already granted",Toast.LENGTH_SHORT).show()
        }
    }
    private fun hasPermissions(permissions: Array<String>):Boolean{
        return permissions.all{permission->
            ContextCompat.checkSelfPermission(this,permission)==PackageManager.PERMISSION_GRANTED
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== permissionrequestcode){
            val deniedPermissions= mutableListOf<String>()
            for(i in permissions.indices){
                if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                    deniedPermissions.add(permissions[i])
                }
            }
            if(deniedPermissions.isEmpty()){
                Toast.makeText(this,"All permissions granted",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"The following permissions were not granted: $deniedPermissions",Toast.LENGTH_SHORT).show()
            }
        }
    }
}