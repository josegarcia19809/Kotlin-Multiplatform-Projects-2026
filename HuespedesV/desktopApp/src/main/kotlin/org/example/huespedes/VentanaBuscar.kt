package org.example.huespedes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FondoVentana = Color(0xFFEAF6F6)

private val FondoCard = Color.White

private val VerdeBoton = Color(0xFF2EC4B6)

private val GrisTextField = Color(0xFFF4F7F8)

private val TextoOscuro = Color(0xFF1E293B)

private val TextoSecundario = Color(0xFF7B8794)

private val VerdeExito = Color(0xFF43A047)

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
            onBackground = TextoOscuro,
            onSurface = TextoOscuro
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
                        color = TextoOscuro,
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

                    OutlinedTextField(
                        value = nombreBuscar,
                        onValueChange = {
                            nombreBuscar = it
                        },

                        placeholder = {
                            Text(
                                text = "Buscar huésped...",
                                color = TextoSecundario
                            )
                        },

                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = VerdeBoton
                            )
                        },

                        singleLine = true,

                        shape = RoundedCornerShape(50.dp),

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),

                        colors = TextFieldDefaults.outlinedTextFieldColors(

                            backgroundColor = Color(0xFFF4F7F8),

                            textColor = TextoOscuro,

                            focusedBorderColor = VerdeBoton,

                            unfocusedBorderColor = Color.Transparent,

                            cursorColor = VerdeBoton,

                            focusedLabelColor = VerdeBoton
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
                                    color = TextoOscuro,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "👤 Nombre: ${huesped.nombre}",
                                    color = TextoOscuro,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "📞 Teléfono: ${huesped.telefono}",
                                    color = TextoOscuro,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "📅 Días: ${huesped.dias}",
                                    color = TextoOscuro,
                                    fontSize = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "🌎 Nacionalidad: ${huesped.nacionalidad}",
                                    color = TextoOscuro,
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