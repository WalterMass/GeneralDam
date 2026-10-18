package com.example.ejercicio_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ejercicio_4.utils.Operacion
import com.example.ejercicio_4.utils.Ops

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiDropdownMenu()
        }
    }
}

@Composable
fun MiDropdownMenu() {
    var num1 by rememberSaveable() { mutableStateOf("") }
    var num2 by rememberSaveable() { mutableStateOf("")}
    var expandido by rememberSaveable() { mutableStateOf(false) }
    var seleccion by remember {
        mutableStateOf(Ops.OPCION)
    }
    var resultado by rememberSaveable() { mutableStateOf(" ")}

    val opciones = listOf(
        Ops.SUMA,
        Ops.RESTA,
        Ops.MULTIPLICACION,
        Ops.DIVISION
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
    ) {

        TextField(
            value = num1,
            label = { Text("NUMERO-1") },
            onValueChange = {
                num1 = it
            }
        )

        TextField(
            value = num2,
            label = { Text("NUMERO-2") },
            onValueChange = {
                num2 = it
            }
        )

        Row(){
            Button(
                onClick = { expandido = true }
            ) {
                Text("${seleccion}...")
            }

            var operador : Operacion;

            DropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false }

            ) {
                opciones.forEach { opcion ->

                    DropdownMenuItem(
                        text = {
                            Text (
                                text = opcion.toString(),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        },
                        onClick = {
                            seleccion = opcion
                            operador = Operacion(seleccion, num1.toInt(), num2.toInt() )
                            resultado = operador.responderOperacion()
                            expandido = false
                        }

                    )
                }
            }

        }
        Text(text = "Resultado: $resultado")


    }

}
