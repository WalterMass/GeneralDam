package com.example.holamundoproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.holamundoproject.ui.theme.HolamundoprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            PantallaPrincipal()
        }
    }
}

@Composable
fun PantallaPrincipal(){
    Column {
        Text(text = "Hola, Mundo!")
        var pedirNombre = "Dime tu nombre"

        var pedirEdad = "Dime tu edad"


    }
}
