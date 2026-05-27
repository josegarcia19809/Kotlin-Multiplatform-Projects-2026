package org.example.huespedes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FondoVentana = Color(0xFFEAF6F6)



private val VerdeBoton = Color(0xFF2EC4B6)

private val GrisTextField = Color(0xFFF4F7F8)

private val RojoError = Color(0xFFE53935)

private val FondoPrincipal = Color(0xFFEAF6F6)
private val SidebarColor = Color(0xFF17323B)

private val FondoCard = Color.White
private val VerdePrincipal = Color(0xFF2EC4B6)

private val GrisSuave = Color(0xFFF4F7F8)
private val TextoOscuro = Color(0xFF1E293B)

private val TextoSecundario = Color(0xFF7B8794)
private val Rojo = Color(0xFFE53935)

@Composable
fun VentanaAgregar(
    onCerrar: () -> Unit
) {

    var nombre by remember {
        mutableStateOf("")
    }

    var telefono by remember {
        mutableStateOf("")
    }

    var dias by remember {
        mutableStateOf("")
    }

    var nacionalidad by remember {
        mutableStateOf("")
    }

    var mensajeError by remember {
        mutableStateOf("")
    }

    MaterialTheme(
        colors = lightColors(
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
                shape = RoundedCornerShape(25.dp),
                elevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(25.dp)
                ) {

                    Text(
                        text = "➕ Agregar huésped",
                        color = TextoOscuro,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Completa la información del huésped",
                        color = TextoSecundario,
                        fontSize = 15.sp
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // =========================
                    // NOMBRE
                    // =========================

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = {
                            nombre = it
                        },

                        label = {
                            Text("Nombre")
                        },

                        leadingIcon = {

                            Icon(
                                Icons.Default.Badge,
                                contentDescription = "",
                                tint = VerdeBoton
                            )
                        },

                        singleLine = true,

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(18.dp),

                        colors = TextFieldDefaults.outlinedTextFieldColors(

                            backgroundColor = GrisTextField,

                            textColor = TextoOscuro,

                            focusedBorderColor = VerdeBoton,

                            unfocusedBorderColor = Color.Transparent,

                            focusedLabelColor = VerdeBoton,

                            unfocusedLabelColor = TextoSecundario,

                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // =========================
                    // TELÉFONO
                    // =========================

                    OutlinedTextField(
                        value = telefono,
                        onValueChange = {
                            telefono = it
                        },

                        label = {
                            Text("Teléfono")
                        },

                        leadingIcon = {

                            Icon(
                                Icons.Default.Phone,
                                contentDescription = "",
                                tint = VerdeBoton
                            )
                        },

                        singleLine = true,

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(18.dp),

                        colors = TextFieldDefaults.outlinedTextFieldColors(

                            backgroundColor = GrisTextField,

                            textColor = TextoOscuro,

                            focusedBorderColor = VerdeBoton,

                            unfocusedBorderColor = Color.Transparent,

                            focusedLabelColor = VerdeBoton,

                            unfocusedLabelColor = TextoSecundario,

                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // =========================
                    // DÍAS
                    // =========================

                    OutlinedTextField(
                        value = dias,
                        onValueChange = {
                            dias = it
                        },

                        label = {
                            Text("Días")
                        },

                        leadingIcon = {

                            Icon(
                                Icons.Default.CalendarMonth,
                                contentDescription = "",
                                tint = VerdeBoton
                            )
                        },

                        singleLine = true,

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(18.dp),

                        colors = TextFieldDefaults.outlinedTextFieldColors(

                            backgroundColor = GrisTextField,

                            textColor = TextoOscuro,

                            focusedBorderColor = VerdeBoton,

                            unfocusedBorderColor = Color.Transparent,

                            focusedLabelColor = VerdeBoton,

                            unfocusedLabelColor = TextoSecundario,

                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // =========================
                    // NACIONALIDAD
                    // =========================

                    OutlinedTextField(
                        value = nacionalidad,
                        onValueChange = {
                            nacionalidad = it
                        },

                        label = {
                            Text("Nacionalidad")
                        },

                        leadingIcon = {

                            Icon(
                                Icons.Default.Flag,
                                contentDescription = "",
                                tint = VerdeBoton
                            )
                        },

                        singleLine = true,

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(18.dp),

                        colors = TextFieldDefaults.outlinedTextFieldColors(

                            backgroundColor = GrisTextField,

                            textColor = TextoOscuro,

                            focusedBorderColor = VerdeBoton,

                            unfocusedBorderColor = Color.Transparent,

                            focusedLabelColor = VerdeBoton,

                            unfocusedLabelColor = TextoSecundario,

                            cursorColor = VerdeBoton
                        )
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    // =========================
                    // ERROR
                    // =========================

                    if (mensajeError.isNotEmpty()) {

                        Card(
                            backgroundColor = Color(0xFFFFEBEE),

                            shape = RoundedCornerShape(14.dp),

                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = mensajeError,

                                color = RojoError,

                                fontWeight = FontWeight.Bold,

                                modifier = Modifier.padding(14.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))
                    }

                    // =========================
                    // BOTONES
                    // =========================

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

                                HuespedService.agregar(
                                    nombre,
                                    telefono,
                                    diasNumero,
                                    nacionalidad
                                )

                                onCerrar()
                            },

                            shape = RoundedCornerShape(16.dp),

                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = VerdeBoton,
                                contentColor = Color.White
                            )
                        ) {

                            Text(
                                "💾 Guardar",
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = {
                                onCerrar()
                            },

                            shape = RoundedCornerShape(16.dp),

                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = SidebarColor,
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