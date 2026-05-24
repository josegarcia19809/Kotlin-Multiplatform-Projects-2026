package org.example.huespedes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FondoVentana = Color(0xFF121212)
private val FondoCard = Color(0xFF1E1E1E)

private val VerdeBoton = Color(0xFF4CAF50)
private val GrisTextField = Color(0xFF2C2C2C)

private val TextoClaro = Color(0xFFF5F5F5)
private val TextoSecundario = Color(0xFFBDBDBD)

private val RojoError = Color(0xFFE53935)

@Composable
fun VentanaEditar(
    indice: Int,
    huesped: Huesped,
    onCerrar: () -> Unit
) {

    var nombre by remember {
        mutableStateOf(huesped.nombre)
    }

    var telefono by remember {
        mutableStateOf(huesped.telefono)
    }

    var dias by remember {
        mutableStateOf(huesped.dias.toString())
    }

    var nacionalidad by remember {
        mutableStateOf(huesped.nacionalidad)
    }

    var mensajeError by remember {
        mutableStateOf("")
    }

    MaterialTheme(
        colors = darkColors(
            primary = VerdeBoton,
            background = FondoVentana,
            surface = FondoCard,
            onPrimary = Color.White,
            onBackground = TextoClaro,
            onSurface = TextoClaro
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(FondoVentana)
                .padding(25.dp)
        ) {

            Card(
                backgroundColor = FondoCard,
                shape = RoundedCornerShape(20.dp),
                elevation = 10.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .padding(25.dp)
                ) {

                    Text(
                        text = "✏️ Editar huésped",
                        color = TextoClaro,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Actualiza la información del huésped",
                        color = TextoSecundario,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = nombre,
                        onValueChange = {
                            nombre = it
                        },
                        label = {
                            Text("Nombre")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrisTextField,
                            textColor = TextoClaro,
                            focusedIndicatorColor = VerdeBoton,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = VerdeBoton,
                            unfocusedLabelColor = TextoSecundario,
                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    TextField(
                        value = telefono,
                        onValueChange = {
                            telefono = it
                        },
                        label = {
                            Text("Teléfono")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrisTextField,
                            textColor = TextoClaro,
                            focusedIndicatorColor = VerdeBoton,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = VerdeBoton,
                            unfocusedLabelColor = TextoSecundario,
                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    TextField(
                        value = dias,
                        onValueChange = {
                            dias = it
                        },
                        label = {
                            Text("Días")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrisTextField,
                            textColor = TextoClaro,
                            focusedIndicatorColor = VerdeBoton,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = VerdeBoton,
                            unfocusedLabelColor = TextoSecundario,
                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    TextField(
                        value = nacionalidad,
                        onValueChange = {
                            nacionalidad = it
                        },
                        label = {
                            Text("Nacionalidad")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrisTextField,
                            textColor = TextoClaro,
                            focusedIndicatorColor = VerdeBoton,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = VerdeBoton,
                            unfocusedLabelColor = TextoSecundario,
                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    if (mensajeError.isNotEmpty()) {

                        Card(
                            backgroundColor = Color(0xFF2A1A1A),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = mensajeError,
                                color = RojoError,
                                modifier = Modifier.padding(12.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Button(
                            onClick = {

                                if (
                                    nombre.isBlank() ||
                                    telefono.isBlank() ||
                                    dias.isBlank() ||
                                    nacionalidad.isBlank()
                                ) {

                                    mensajeError =
                                        "⚠️ Todos los campos son obligatorios"

                                    return@Button
                                }

                                val diasNumero = dias.toIntOrNull()

                                if (diasNumero == null) {

                                    mensajeError =
                                        "⚠️ Los días deben ser numéricos"

                                    return@Button
                                }

                                if (diasNumero <= 0) {

                                    mensajeError =
                                        "⚠️ Los días deben ser mayores a 0"

                                    return@Button
                                }

                                HuespedService.huespedes[indice] =
                                    Huesped(
                                        nombre,
                                        telefono,
                                        diasNumero,
                                        nacionalidad
                                    )

                                HuespedService.guardarArchivo()

                                onCerrar()
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = VerdeBoton,
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                "💾 Guardar cambios",
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = {
                                onCerrar()
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF3A3A3A),
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                "❌ Cancelar",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}