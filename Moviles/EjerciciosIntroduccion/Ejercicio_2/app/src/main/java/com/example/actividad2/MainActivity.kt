package com.example.actividad2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            calculadora()
        }
    }


}

@Composable
fun calculadora() {
    var num1 by rememberSaveable { mutableStateOf("") }
    var num2 by rememberSaveable { mutableStateOf("") }
    var operacion by rememberSaveable {mutableStateOf("void") }
    var resultado by rememberSaveable { mutableStateOf("resultado: ") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it }
        )

        TextField(
            value = num2,
            onValueChange = { num2 = it }
        )

        RadioButton(
            selected = operacion == "sumar",
            onClick = { operacion = "sumar" }
        )
        RadioButton(
            selected = operacion == "restar",
            onClick = { operacion = "restar" }
        )
        var context = LocalContext.current

        Button(onClick = {
            resultado = "resultado: "+operacion(operacion, num1.toInt(), num2.toInt() )
            Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show()
            }
        ){
            Text (text = "Operar")
        }
        Text(text = resultado)
    }
}
fun operacion (nombreOperacion : String, num1 : Int, num2 : Int) : Int {
    return if (nombreOperacion == "sumar") num1+num2 else num1-num2
}
//Ejercicio 2
//Construye un proyecto Kotlin Compose que permita elegir y realizar una de las dos operaciones:

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloworldTheme {
        Greeting("Android")
    }
}*/

