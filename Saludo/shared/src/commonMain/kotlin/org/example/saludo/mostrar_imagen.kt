package org.example.saludo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import org.jetbrains.compose.resources.painterResource

// Importación auto-generada del recurso
import saludo.shared.generated.resources.Res
import saludo.shared.generated.resources.rana

@Composable
fun mostrarImagen() {
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

        Image(
            painter = painterResource(Res.drawable.rana),
            contentDescription = "Rana"
        )
    }
}
