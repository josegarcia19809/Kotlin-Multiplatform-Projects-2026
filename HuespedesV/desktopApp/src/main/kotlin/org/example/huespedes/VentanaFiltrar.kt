package org.example.huespedes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
private val GrisHeader = Color(0xFF3A3A3A)

private val TextoClaro = Color(0xFFF5F5F5)
private val TextoSecundario = Color(0xFFBDBDBD)

private val VerdeExito = Color(0xFF66BB6A)
private val RojoError = Color(0xFFE53935)

@Composable
fun VentanaFiltrar(
    onCerrar: () -> Unit
) {

    var nacionalidadBuscar by remember {
        mutableStateOf("")
    }

    var resultados by remember {
        mutableStateOf(listOf<Huesped>())
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
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .padding(25.dp)
                ) {

                    Text(
                        text = "🌎 Filtrar huéspedes",
                        color = TextoClaro,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Filtra huéspedes por nacionalidad",
                        color = TextoSecundario,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = nacionalidadBuscar,
                        onValueChange = {
                            nacionalidadBuscar = it
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

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Button(
                            onClick = {

                                if (nacionalidadBuscar.isBlank()) {

                                    mensaje =
                                        "⚠️ Debes escribir una nacionalidad"

                                    resultados = emptyList()

                                    return@Button
                                }

                                resultados =
                                    HuespedService.huespedes.filter {

                                        it.nacionalidad.contains(
                                            nacionalidadBuscar,
                                            true
                                        )
                                    }

                                mensaje =
                                    if (resultados.isEmpty()) {

                                        "❌ No se encontraron huéspedes"

                                    } else {

                                        "✅ ${resultados.size} huéspedes encontrados"
                                    }
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = VerdeBoton,
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                "🌎 Filtrar",
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = {
                                onCerrar()
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = GrisHeader,
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
                                if (resultados.isNotEmpty())
                                    Color(0xFF1E2B1E)
                                else
                                    Color(0xFF2A1A1A),

                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = mensaje,
                                color =
                                    if (resultados.isNotEmpty())
                                        VerdeExito
                                    else
                                        RojoError,

                                modifier = Modifier.padding(12.dp),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    if (resultados.isNotEmpty()) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(GrisHeader)
                                .padding(12.dp)
                        ) {

                            Text(
                                text = "Nombre",
                                color = TextoClaro,
                                modifier = Modifier.width(180.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Teléfono",
                                color = TextoClaro,
                                modifier = Modifier.width(150.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Días",
                                color = TextoClaro,
                                modifier = Modifier.width(80.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Nacionalidad",
                                color = TextoClaro,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    LazyColumn {

                        items(resultados) { huesped ->

                            Card(
                                backgroundColor = Color(0xFF252525),
                                shape = RoundedCornerShape(15.dp),
                                elevation = 6.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                            ) {

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(15.dp)
                                ) {

                                    Text(
                                        text = huesped.nombre,
                                        color = TextoClaro,
                                        modifier = Modifier.width(180.dp)
                                    )

                                    Text(
                                        text = huesped.telefono,
                                        color = TextoClaro,
                                        modifier = Modifier.width(150.dp)
                                    )

                                    Text(
                                        text = huesped.dias.toString(),
                                        color = TextoClaro,
                                        modifier = Modifier.width(80.dp)
                                    )

                                    Text(
                                        text = huesped.nacionalidad,
                                        color = TextoClaro
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}