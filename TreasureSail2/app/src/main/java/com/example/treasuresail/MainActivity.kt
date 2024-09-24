package com.example.treasuresail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.treasuresail.ui.theme.TreasureSailTheme
import kotlin.math.max
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
    var hp by remember{ mutableStateOf(5)}
    var highScore by remember { mutableStateOf(0) }
    var currentScore by remember { mutableStateOf(0)}
    val TreasureCount=remember{mutableStateOf(0)}
    val Direction=remember{ mutableStateOf("North")}
    val context= LocalContext.current
    val stormOrTreasure = remember { mutableStateOf("") }
    var showReset by remember {
        mutableStateOf(false)
    }
    if(!showReset) {
        if (hp == 0) {
            Toast.makeText(context, "GAME OVER!", Toast.LENGTH_SHORT).show()
            highScore = max(highScore, TreasureCount.value)
            currentScore = TreasureCount.value
            showReset = true
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hp: $hp",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "HighScore: $highScore",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Treasure Found: ${TreasureCount.value}",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Current Direction: ${Direction.value}",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(4.dp)
            )
            Button(onClick = {
                Direction.value = "East"
                if (Random.nextBoolean()) {
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    TreasureCount.value += 1
                } else {
                    if (hp > 0) {
                        Toast.makeText(context, "Ran into a Storm!", Toast.LENGTH_SHORT).show()
                        hp--
                    }

                }
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = "Sail East")
            }
            Button(onClick = {
                Direction.value = "West"
                if (Random.nextBoolean()) {
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    TreasureCount.value += 1
                } else {
                    if (hp > 0) {
                        Toast.makeText(context, "Ran into a Storm!", Toast.LENGTH_SHORT).show()
                        hp--
                    }

                }
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = "Sail West")
            }
            Button(onClick = {
                Direction.value = "South"
                if (Random.nextBoolean()) {
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    TreasureCount.value += 1
                } else {
                    if (hp > 0) {
                        Toast.makeText(context, "Ran into a Storm!", Toast.LENGTH_SHORT).show()
                        hp--
                    }

                }
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = "Sail South")
            }
            Button(onClick = {
                Direction.value = "North"
                if (Random.nextBoolean()) {
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    TreasureCount.value += 1
                } else {
                    if (hp > 0) {
                        Toast.makeText(context, "Ran into a Storm!", Toast.LENGTH_SHORT).show()
                        hp--
                    }

                }
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = "Sail North")
            }
        }
    }
    else{
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "HighScore: $highScore",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Your Score: $currentScore",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(4.dp)
            )
            Button(onClick = {
                hp = 5
                TreasureCount.value = 0
                showReset = false
            }, modifier = Modifier.wrapContentSize()) {
                Text(text = "Reset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TreasureHuntPreview() {
    TreasureSailTheme {
        TreasureHunt()
    }
}