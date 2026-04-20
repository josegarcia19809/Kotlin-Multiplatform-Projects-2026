package org.example.saludo

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun sumarNumeros() {

    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0) }

    // 🎨 Paleta roja
    val rojoPrincipal = Color(0xFFD32F2F)
    val rojoClaro = Color(0xFFFFCDD2)
    val rojoOscuro = Color(0xFFB71C1C)

    MaterialTheme {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Card(
                elevation = 12.dp,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(20.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .width(300.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Sumar Números",
                        style = MaterialTheme.typography.h6,
                        color = rojoPrincipal
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = numero1,
                        onValueChange = { numero1 = it },
                        label = { Text("Número 1") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = rojoPrincipal,
                            unfocusedBorderColor = rojoClaro,
                            textColor = rojoOscuro,
                            cursorColor = rojoPrincipal
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = numero2,
                        onValueChange = { numero2 = it },
                        label = { Text("Número 2") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = rojoPrincipal,
                            unfocusedBorderColor = rojoClaro,
                            textColor = rojoOscuro,
                            cursorColor = rojoPrincipal
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            val n1 = numero1.toIntOrNull() ?: 0
                            val n2 = numero2.toIntOrNull() ?: 0
                            resultado = n1 + n2
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = rojoPrincipal,
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.elevation(8.dp)
                    ) {
                        Text("Sumar")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        "Resultado",
                        style = MaterialTheme.typography.subtitle1,
                        color = rojoPrincipal
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "$resultado",
                        style = MaterialTheme.typography.h5,
                        color = rojoOscuro
                    )
                }
            }
        }
    }
}