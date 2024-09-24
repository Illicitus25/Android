package com.example.unitconvertor

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconvertor.ui.theme.UnitConvertorTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}
@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Select")}
    var outputUnit by remember { mutableStateOf("Select")}
    var iExpanded by remember { mutableStateOf(false)}
    var oExpanded by remember { mutableStateOf(false)}
    var iConversionFactor by remember { mutableStateOf(1.0)}
    var oConversionFactor by remember { mutableStateOf(1.0)}
    var oSelected by remember { mutableStateOf("")}

    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull()?: 0.0
        val result = (inputValueDouble*iConversionFactor*100.0/ oConversionFactor).roundToInt()/100.0
        outputValue=result.toString()
    }

    Column(modifier = Modifier.fillMaxSize().offset(y=(-100.dp)),verticalArrangement= Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Unit Convertor", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {inputValue=it
                convertUnits()},
            label = { Text(text = "Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "From:")
            Spacer(modifier = Modifier.width(8.dp))

            Box{
                Button(onClick = { iExpanded=true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
                    DropdownMenuItem(text ={ Text(text = "Meters")},
                        onClick = {
                            inputUnit="Meters"
                            iExpanded=false
                            iConversionFactor=1.0
                            convertUnits()
                    })
                    DropdownMenuItem(text ={ Text(text = "Centimeters")},
                        onClick = {
                        inputUnit="Centimeters"
                        iExpanded=false
                            iConversionFactor=0.01
                            convertUnits()
                    })
                    DropdownMenuItem(text ={ Text(text = "Feet")},
                        onClick = {
                        inputUnit="Feet"
                        iExpanded=false
                            iConversionFactor=0.3048
                            convertUnits()
                    })
                    DropdownMenuItem(text ={ Text(text = "Millimeters")},
                        onClick = {
                            inputUnit="Feet"
                            iExpanded=false
                            iConversionFactor=0.001
                            convertUnits()
                        })
                }
                Spacer(modifier = Modifier.width(128.dp))
            }
            Text(text = "To:")
            Spacer(modifier = Modifier.width(8.dp))
            Box{
                Button(onClick = { oExpanded=true}) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded=false}) {
                    DropdownMenuItem(text ={ Text(text = "Meters")},
                        onClick = {
                            outputUnit="Meters"
                            oExpanded=false
                            oConversionFactor=1.0
                            oSelected="Meters"
                            convertUnits()
                        })
                    DropdownMenuItem(text ={ Text(text = "Centimeters")},
                        onClick = {
                            outputUnit="Centimeters"
                            oExpanded=false
                            oConversionFactor=0.01
                            oSelected="Centimeters"
                            convertUnits()
                        })
                    DropdownMenuItem(text ={ Text(text = "Feet")},
                        onClick = {
                            outputUnit="Feet"
                            oExpanded=false
                            oConversionFactor=0.3048
                            oSelected="Feet"
                            convertUnits()
                        })
                    DropdownMenuItem(text ={ Text(text = "Millimeters")},
                        onClick = {
                            outputUnit="Millimeters"
                            oExpanded=false
                            oConversionFactor=0.001
                            oSelected="Millimeters"
                            convertUnits()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: $outputValue $oSelected", style=MaterialTheme.typography.headlineMedium)
    }
}


@Preview
    (showBackground = true)
@Composable
fun UnitConvertorPreview(){
    UnitConverter()
}