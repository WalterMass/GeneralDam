package com.example.ejercicio_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            calculadoraV2()
        }
    }


}

@Composable
fun calculadoraV2(){
    var num1 by rememberSaveable() { mutableStateOf("") }
    var num2 by rememberSaveable() { mutableStateOf("") }
    var resultado by rememberSaveable(){ mutableStateOf("Resultado: ")}
    var operacionSuma by rememberSaveable(){ mutableStateOf(false)}
    var operacionResta by rememberSaveable(){ mutableStateOf(false)}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
    ){
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text(text = "NUMERO 1")}
        )

        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = {Text(text = "NUMERO 2")}
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = operacionSuma,
                onCheckedChange = { operacionSuma = !operacionSuma }
            )
            Text (text = "Sumar")
        }

        Row(verticalAlignment = Alignment.CenterVertically){
            Checkbox(
                checked = operacionResta,
                onCheckedChange = { operacionResta = !operacionResta }
            )
            Text (text = "Restar")
        }


        Button(
            onClick = { resultado = resultadoOperacion(num1.toInt(), num2.toInt(), operacionSuma, operacionResta ) }
        ){
            Text(text = "OPERAR")
        }

        Text( text = resultado )
    }
}

fun resultadoOperacion(num1 : Int, num2 : Int, operacionSuma : Boolean, operacionResta : Boolean ): String {
    return if (operacionSuma  && operacionResta){
        "La suma es: ${num1+num2}, La resta es: ${num1-num2}"
    }else if (operacionSuma){
        "La resta es: ${num1+num2}"
    }else if (operacionResta) {
        "La suma es : ${num1-num2}"
    }else {
        "Marca una de las operaciones para operar"
    }
}

//Ejercicio 3
//Construye un proyecto Kotlin Compose que permita elegir y realizar una o dos operaciones:
