package org.example.saludo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import saludo.composeapp.generated.resources.Res
import saludo.composeapp.generated.resources.pedro

@Composable
fun formularioEstudiante() {

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var carrera by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    val coloresMorado = TextFieldDefaults.textFieldColors(
        backgroundColor = Color(0xFFA970F6),
        textColor = Color.White,
        cursorColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )

    MaterialTheme {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Card(
                elevation = 10.dp,
                modifier = Modifier.padding(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(Res.drawable.pedro),
                        contentDescription = "Venado",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(2.dp, MaterialTheme.colors.primary, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Formulario de Estudiante",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.primary
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre", color = Color.White) },
                        textStyle = LocalTextStyle.current.copy(color = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        colors = coloresMorado
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    TextField(
                        value = edad,
                        onValueChange = { edad = it },
                        label = { Text("Edad", color = Color.White) },
                        textStyle = LocalTextStyle.current.copy(color = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        colors = coloresMorado
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    TextField(
                        value = carrera,
                        onValueChange = { carrera = it },
                        label = { Text("Carrera", color = Color.White) },
                        textStyle = LocalTextStyle.current.copy(color = Color.White),
                        modifier = Modifier.fillMaxWidth(),
                        colors = coloresMorado
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            resultado = """
Nombre: $nombre
Edad: $edad
Carrera: $carrera
""".trimIndent()
                        },
                        //modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Guardar")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (resultado.isNotEmpty()) {
                        Text(
                            "Datos capturados:",
                            style = MaterialTheme.typography.subtitle1
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(resultado)
                    }
                }
            }
        }
    }
}