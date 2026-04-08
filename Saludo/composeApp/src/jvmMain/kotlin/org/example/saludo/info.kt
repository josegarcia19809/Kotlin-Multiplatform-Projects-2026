package org.example.saludo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun info() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Hola Mundo!",
            fontSize = 24.sp
        )

        Text(
            text = "Mi nombre es José L García Morales",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Mi carrera es Ingeniería en Computación",
            fontSize = 18.sp,
            fontWeight = FontWeight.Thin,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "En el Centro Universitario UAEM Atlacomulco",
            fontSize = 18.sp,
            fontWeight = FontWeight.Thin,
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Bienvenidos al curso de Programación",
            fontSize = 18.sp,
            fontWeight = FontWeight.Thin,
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
    }
}