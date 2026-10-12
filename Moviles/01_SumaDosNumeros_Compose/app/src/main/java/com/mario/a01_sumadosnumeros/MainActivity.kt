package com.mario.a01_sumadosnumeros

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalculadoraSuma()
        }
    }
}

@Composable
fun CalculadoraSuma() {

    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Primer número") },

            // Mostrar teclado numérico
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Segundo número") },

            // Mostrar teclado numérico
           /* keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )*/
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {

                // Comprobamos que los campos no estén vacíos
                if (numero1.isBlank() || numero2.isBlank()) {
                    resultado = "Debes introducir los dos números"
                } else {

                    val n1 = numero1.toIntOrNull()
                    val n2 = numero2.toIntOrNull()

                    if (n1 != null && n2 != null) {
                        resultado = "Resultado: ${sumar(n1, n2)}"
                    } else {
                        resultado = "Los valores no son válidos"
                    }
                }
            }
        ) {
            Text("Sumar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = resultado)
    }
}
fun sumar(numero1: Int, numero2: Int): Int {
    return numero1 + numero2
}

// Preview de Android Studio
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CalculadoraSumaPreview() {
    CalculadoraSuma()
}