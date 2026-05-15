package org.example.project


/*
    Creado por Jose Garcia el 08/05/26
    Sistema de pasajeros con Compose Desktop
*/

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File

// DATA CLASS
data class Pasajero(
    var clave: Int,
    var nombre: String,
    var origen: String,
    var destino: String,
    var pasaje: Double
)

// LISTA
val pasajeros = mutableStateListOf<Pasajero>()

val nombreArchivo = "pasajeros3.txt"


@Composable
fun PantallaPasajeros() {

    // Se ejecuta una sola vez
    LaunchedEffect(Unit) {

        crearArchivoSiNoExiste()
        recuperarDeArchivo()
    }

    // ESTADOS
    var clave by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var origen by remember { mutableStateOf("") }
    var destino by remember { mutableStateOf("") }
    var pasaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFDBDEE0),
                        Color(0xFF87929C)
                    )
                )
            )
            .padding(20.dp)
    ) {

        // TITULO
        Text(
            text = "✈️ Sistema de Pasajeros",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        // CONTENEDOR PRINCIPAL
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // =========================
            // IZQUIERDA -> LISTA
            // =========================
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Text(
                    text = "📋 Lista de pasajeros",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    items(pasajeros) { pasajero ->

                        Card(
                            modifier = Modifier.fillMaxWidth(),

                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFD2DADE)
                            )
                        ) {

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = "🆔 Clave: ${pasajero.clave}",
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "👤 Nombre: ${pasajero.nombre}"
                                )

                                Text(
                                    text = "🌎 Origen: ${pasajero.origen}"
                                )

                                Text(
                                    text = "📍 Destino: ${pasajero.destino}"
                                )

                                Text(
                                    text = "💲 Pasaje: $${pasajero.pasaje}"
                                )
                            }
                        }
                    }
                }
            }

            // =========================
            // DERECHA -> FORMULARIO
            // =========================
            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD2DADE)
                )
            ) {

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {

                    Text(
                        text = "➕ Nuevo pasajero",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = clave,
                        onValueChange = { clave = it },
                        label = { Text("Clave") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = origen,
                        onValueChange = { origen = it },
                        label = { Text("Origen") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = destino,
                        onValueChange = { destino = it },
                        label = { Text("Destino") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = pasaje,
                        onValueChange = { pasaje = it },
                        label = { Text("Precio del pasaje") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),

                        onClick = {

                            val nuevo = Pasajero(
                                clave.toInt(),
                                nombre,
                                origen,
                                destino,
                                pasaje.toDouble()
                            )

                            pasajeros.add(nuevo)

                            escribirEnArchivo()

                            // LIMPIAR
                            clave = ""
                            nombre = ""
                            origen = ""
                            destino = ""
                            pasaje = ""
                        }
                    ) {

                        Text("Guardar pasajero")
                    }
                }
            }
        }
    }
}

// CREAR ARCHIVO
fun crearArchivoSiNoExiste() {

    val archivo = File(nombreArchivo)

    if (!archivo.exists()) {
        archivo.createNewFile()
    }
}

// ESCRIBIR
fun escribirEnArchivo() {

    val archivo = File(nombreArchivo)

    archivo.printWriter().use { salida ->

        for (pasajero in pasajeros) {

            salida.println(
                "${pasajero.clave}|${pasajero.nombre}|${pasajero.origen}|${pasajero.destino}|${pasajero.pasaje}"
            )
        }
    }
}

// RECUPERAR
fun recuperarDeArchivo() {

    val archivo = File(nombreArchivo)

    archivo.forEachLine { linea ->

        val campos = linea.split("|")

        if (campos.size == 5) {

            val pasajero = Pasajero(
                campos[0].toInt(),
                campos[1],
                campos[2],
                campos[3],
                campos[4].toDouble()
            )

            pasajeros.add(pasajero)
        }
    }
}