package com.example.treasuresail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.treasuresail.ui.theme.TreasureSailTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureSailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TreasureHunt()
                }
            }
        }
    }
}

@Composable
fun TreasureHunt(){
    val TreasureCount=remember{mutableStateOf(0)}
    val Direction=remember{ mutableStateOf("North")}
    val context= LocalContext.current
    val stormOrTreasure = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(text = "Treasure Found: ${TreasureCount.value}")
        Text(text = "Current Direction: ${Direction.value}")
        Button(onClick = {Direction.value="West"
            if(Random.nextBoolean()){
                Toast.makeText(context,"Treasure Found!",Toast.LENGTH_SHORT).show()
                TreasureCount.value+=1
            }
            else{
                Toast.makeText(context,"Ran into a Storm!",Toast.LENGTH_SHORT).show()
            }}) {
            Text(text = "Sail East")
        }
        Button(onClick = {Direction.value="West"
            if(Random.nextBoolean()){
                Toast.makeText(context,"Treasure Found!",Toast.LENGTH_SHORT).show()
                TreasureCount.value+=1
            }
        else{
                Toast.makeText(context,"Ran into a Storm!",Toast.LENGTH_SHORT).show()
        }}) {
            Text(text = "Sail West")
        }
        Button(onClick = {Direction.value="West"
            if(Random.nextBoolean()){
                Toast.makeText(context,"Treasure Found!",Toast.LENGTH_SHORT).show()
                TreasureCount.value+=1
            }
            else{
                Toast.makeText(context,"Ran into a Storm!",Toast.LENGTH_SHORT).show()
            }}) {
            Text(text = "Sail South")
        }
        Button(onClick = {Direction.value="West"
            if(Random.nextBoolean()){
                Toast.makeText(context,"Treasure Found!",Toast.LENGTH_SHORT).show()
                TreasureCount.value+=1
            }
            else{
                Toast.makeText(context,"Ran into a Storm!",Toast.LENGTH_SHORT).show()
            }}) {
            Text(text = "Sail North")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TreasureSailTheme {
        TreasureHunt()
    }
}