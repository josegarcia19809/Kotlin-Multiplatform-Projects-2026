package org.example.saludo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun sumarNumeros() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Numero 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Numero 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val n1 = numero1.toIntOrNull() ?: 0
            val n2 = numero2.toIntOrNull() ?: 0
            resultado = n1 + n2
        }) {
            Text("Sumar")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Resultado: $resultado")
    }
}