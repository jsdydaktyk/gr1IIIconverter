package com.example.gr1iiiconverter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gr1iiiconverter.ui.theme.Gr1IIIconverterTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gr1IIIconverterTheme {
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

    val CENT = "Centimeters"
    val INCHES = "Inches"
    val FEET = "Feet"

    val conversionFactors = mapOf(
        Pair(CENT, INCHES) to 0.393701,
        Pair(INCHES, CENT) to 2.54,
        Pair(FEET, INCHES) to 12.00,
        Pair(FEET, CENT) to 30.48,
        Pair(CENT, FEET) to 0.0328084,
        Pair(INCHES, FEET) to 0.0833333
    )

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inExpended by remember { mutableStateOf(false)   }
    var outExpended by remember { mutableStateOf(false)   }

    var inputNumber by remember {
        mutableStateOf("")
    }




    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Unit Converter")
        
        Spacer(modifier = Modifier.height(20.dp))
        
        OutlinedTextField(value = "coś", onValueChange = { inputNumber=it })
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Row {
            Box{
                Button(onClick = {
                    Log.i("ex", "ok ")
                    inExpended = true

                }) {

                    Text(text="Select")
                    Icon(imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "arrow")
                }

                DropdownMenu(expanded = inExpended, onDismissRequest = { inExpended=false }) {
                    DropdownMenuItem(text = {Text(CENT)},
                                     onClick = {
                                         inputValue = CENT
                                         inExpended=false
                                     })
                    DropdownMenuItem(text = {Text(INCHES)},
                        onClick = {
                            inputValue=INCHES
                            inExpended=false
                        })
                    DropdownMenuItem(text = {Text(FEET)},
                        onClick = {
                            inputValue=FEET
                            inExpended=false
                        })

                }
            }

            Spacer(modifier = Modifier.width(15.dp))
            Box{
                Button(onClick = {
                    Log.i("ex", "ok ")
                    outExpended = true

                }) {

                    Text(text="Select")
                    Icon(imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "arrow")
                }

                DropdownMenu(expanded = outExpended, onDismissRequest = { outExpended=false }) {
                    DropdownMenuItem(text = {Text(CENT)},
                        onClick = {
                            outputValue=CENT
                            outExpended=false
                        })
                    DropdownMenuItem(text = {Text(INCHES)},
                        onClick = {
                            outputValue=INCHES
                            outExpended=false
                        })
                    DropdownMenuItem(text = {Text(FEET)},
                        onClick = {
                            outputValue=FEET
                            outExpended=false
                        })

                }
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text="Result: ")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Gr1IIIconverterTheme {
        UnitConverter()
    }
}