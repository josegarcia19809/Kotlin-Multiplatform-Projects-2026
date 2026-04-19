package org.example.saludo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun mensajes() {
    var textoEntrada by remember { mutableStateOf("") }
    var textoSalida by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(), // ocupa toda la ventana
        verticalArrangement = Arrangement.Center, // centra vertical
        horizontalAlignment = Alignment.CenterHorizontally // centra horizontal
    ) {
        TextField(
            value = textoEntrada,
            onValueChange = { textoEntrada = it },
            label = { Text("Escribe algo") }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            textoSalida = textoEntrada
        }) {
            Text("Enviar")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text("Salida: $textoSalida")
    }
}