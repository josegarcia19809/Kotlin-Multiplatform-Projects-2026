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

private val VerdeExito = Color(0xFF66BB6A)
private val RojoError = Color(0xFFE53935)

@Composable
fun VentanaBuscar(
    onCerrar: () -> Unit
) {

    var nombreBuscar by remember {
        mutableStateOf("")
    }

    var huespedEncontrado by remember {
        mutableStateOf<Huesped?>(null)
    }

    var mensaje by remember {
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
                        text = "🔍 Buscar huésped",
                        color = TextoClaro,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Busca huéspedes por nombre",
                        color = TextoSecundario,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = nombreBuscar,
                        onValueChange = {
                            nombreBuscar = it
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

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Button(
                            onClick = {

                                if (nombreBuscar.isBlank()) {

                                    mensaje =
                                        "⚠️ Debes escribir un nombre"

                                    huespedEncontrado = null

                                    return@Button
                                }

                                val resultado =
                                    HuespedService.huespedes.find {

                                        it.nombre.contains(
                                            nombreBuscar,
                                            true
                                        )
                                    }

                                if (resultado != null) {

                                    huespedEncontrado = resultado

                                    mensaje =
                                        "✅ Huésped encontrado"

                                } else {

                                    huespedEncontrado = null

                                    mensaje =
                                        "❌ No se encontró el huésped"
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = VerdeBoton,
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                "🔍 Buscar",
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
                                "❌ Cerrar",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (mensaje.isNotEmpty()) {

                        Card(
                            backgroundColor =
                                if (huespedEncontrado != null)
                                    Color(0xFF1E2B1E)
                                else
                                    Color(0xFF2A1A1A),

                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = mensaje,
                                color =
                                    if (huespedEncontrado != null)
                                        VerdeExito
                                    else
                                        RojoError,

                                modifier = Modifier.padding(12.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    huespedEncontrado?.let { huesped ->

                        Card(
                            backgroundColor = Color(0xFF252525),
                            shape = RoundedCornerShape(15.dp),
                            elevation = 6.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier.padding(20.dp)
                            ) {

                                Text(
                                    text = "📋 Información del huésped",
                                    color = TextoClaro,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "👤 Nombre: ${huesped.nombre}",
                                    color = TextoClaro,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "📞 Teléfono: ${huesped.telefono}",
                                    color = TextoClaro,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "📅 Días: ${huesped.dias}",
                                    color = TextoClaro,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "🌎 Nacionalidad: ${huesped.nacionalidad}",
                                    color = TextoClaro,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}