package org.example.huespedes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState

private val FondoPrincipal = Color(0xFF121212)
private val FondoCard = Color(0xFF1E1E1E)

private val VerdeBoton = Color(0xFF4CAF50)
private val GrisTenue = Color(0xFF3A3A3A)

private val Rojo = Color(0xFFE53935)

private val TextoClaro = Color(0xFFF5F5F5)
private val TextoSecundario = Color(0xFFBDBDBD)

@Composable
fun VentanaPrincipal() {

    LaunchedEffect(Unit) {
        HuespedService.leerArchivo()
    }

    var mostrarVentanaAgregar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaEditar by remember {
        mutableStateOf(false)
    }

    var indiceEditar by remember {
        mutableStateOf(-1)
    }

    var mostrarConfirmacionEliminar by remember {
        mutableStateOf(false)
    }

    var indiceEliminar by remember {
        mutableStateOf(-1)
    }

    var mostrarVentanaBuscar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaFiltrar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaOrdenar by remember {
        mutableStateOf(false)
    }

    MaterialTheme(
        colors = darkColors(
            primary = VerdeBoton,
            background = FondoPrincipal,
            surface = FondoCard,
            onPrimary = Color.White,
            onBackground = TextoClaro,
            onSurface = TextoClaro
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(FondoPrincipal)
                .padding(20.dp)
        ) {

            Column {

                Card(
                    backgroundColor = FondoCard,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 12.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(25.dp)
                    ) {

                        Text(
                            text = "🏨 SISTEMA DE HUÉSPEDES",
                            color = TextoClaro,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Administración moderna de huéspedes",
                            color = TextoSecundario,
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Button(
                        onClick = {
                            mostrarVentanaAgregar = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = VerdeBoton,
                            contentColor = Color.White
                        )
                    ) {

                        Text("➕ Agregar")
                    }

                    Button(
                        onClick = {
                            mostrarVentanaBuscar = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = GrisTenue,
                            contentColor = Color.White
                        )
                    ) {

                        Text("🔍 Buscar")
                    }

                    Button(
                        onClick = {
                            mostrarVentanaFiltrar = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = GrisTenue,
                            contentColor = Color.White
                        )
                    ) {

                        Text("🌎 Filtrar")
                    }

                    Button(
                        onClick = {
                            mostrarVentanaOrdenar = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = GrisTenue,
                            contentColor = Color.White
                        )
                    ) {

                        Text("📅 Ordenar")
                    }

                    Button(
                        onClick = {
                            System.exit(0)
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Rojo,
                            contentColor = Color.White
                        )
                    ) {

                        Text("🚪 Salir")
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Card(
                    backgroundColor = FondoCard,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 10.dp,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(GrisTenue)
                                .padding(12.dp)
                        ) {

                            Text(
                                text = "Nombre",
                                color = TextoClaro,
                                modifier = Modifier.width(220.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Teléfono",
                                color = TextoClaro,
                                modifier = Modifier.width(180.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Días",
                                color = TextoClaro,
                                modifier = Modifier.width(100.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Nacionalidad",
                                color = TextoClaro,
                                modifier = Modifier.width(180.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Acciones",
                                color = TextoClaro,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        LazyColumn {

                            itemsIndexed(HuespedService.huespedes) { index, huesped ->

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
                                            .padding(15.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Text(
                                            text = huesped.nombre,
                                            color = TextoClaro,
                                            modifier = Modifier.width(220.dp)
                                        )

                                        Text(
                                            text = huesped.telefono,
                                            color = TextoClaro,
                                            modifier = Modifier.width(180.dp)
                                        )

                                        Text(
                                            text = huesped.dias.toString(),
                                            color = TextoClaro,
                                            modifier = Modifier.width(100.dp)
                                        )

                                        Text(
                                            text = huesped.nacionalidad,
                                            color = TextoClaro,
                                            modifier = Modifier.width(180.dp)
                                        )

                                        Button(
                                            onClick = {

                                                indiceEditar = index
                                                mostrarVentanaEditar = true
                                            },
                                            shape = RoundedCornerShape(10.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = VerdeBoton,
                                                contentColor = Color.White
                                            )
                                        ) {

                                            Text("✏️ Editar")
                                        }

                                        Spacer(
                                            modifier = Modifier.width(10.dp)
                                        )

                                        Button(
                                            onClick = {

                                                indiceEliminar = index
                                                mostrarConfirmacionEliminar = true
                                            },
                                            shape = RoundedCornerShape(10.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = Rojo,
                                                contentColor = Color.White
                                            )
                                        ) {

                                            Text("🗑️ Borrar")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (mostrarVentanaAgregar) {

            Window(
                onCloseRequest = {
                    mostrarVentanaAgregar = false
                },
                title = "Agregar huésped"
            ) {

                VentanaAgregar(
                    onCerrar = {
                        mostrarVentanaAgregar = false
                    }
                )
            }
        }

        if (
            mostrarVentanaEditar &&
            indiceEditar != -1
        ) {

            Window(
                onCloseRequest = {
                    mostrarVentanaEditar = false
                },
                title = "Editar huésped"
            ) {

                VentanaEditar(
                    indice = indiceEditar,
                    huesped = HuespedService.huespedes[indiceEditar],
                    onCerrar = {
                        mostrarVentanaEditar = false
                    }
                )
            }
        }

        if (
            mostrarConfirmacionEliminar &&
            indiceEliminar != -1
        ) {

            Window(
                onCloseRequest = {
                    mostrarConfirmacionEliminar = false
                },
                title = "Confirmar eliminación",
                state = rememberWindowState(
                    width = 400.dp,
                    height = 220.dp
                )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(FondoPrincipal)
                        .padding(20.dp)
                ) {

                    Column {

                        Text(
                            text = "⚠️ Confirmar eliminación",
                            color = TextoClaro,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "¿Deseas eliminar a ${HuespedService.huespedes[indiceEliminar].nombre}?",
                            color = TextoSecundario,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(25.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Button(
                                onClick = {

                                    HuespedService.huespedes.removeAt(
                                        indiceEliminar
                                    )

                                    HuespedService.guardarArchivo()

                                    mostrarConfirmacionEliminar = false
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = VerdeBoton,
                                    contentColor = Color.White
                                )
                            ) {

                                Text("✅ Sí")
                            }

                            Button(
                                onClick = {

                                    mostrarConfirmacionEliminar = false
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Rojo,
                                    contentColor = Color.White
                                )
                            ) {

                                Text("❌ Cancelar")
                            }
                        }
                    }
                }
            }
        }

        if (mostrarVentanaBuscar) {

            Window(
                onCloseRequest = {
                    mostrarVentanaBuscar = false
                },
                title = "Buscar huésped"
            ) {

                VentanaBuscar(
                    onCerrar = {
                        mostrarVentanaBuscar = false
                    }
                )
            }
        }

        if (mostrarVentanaFiltrar) {

            Window(
                onCloseRequest = {
                    mostrarVentanaFiltrar = false
                },
                title = "Filtrar huéspedes"
            ) {

                VentanaFiltrar(
                    onCerrar = {
                        mostrarVentanaFiltrar = false
                    }
                )
            }
        }

        if (mostrarVentanaOrdenar) {

            Window(
                onCloseRequest = {
                    mostrarVentanaOrdenar = false
                },
                title = "Ordenar huéspedes"
            ) {

                VentanaOrdenar(
                    onCerrar = {
                        mostrarVentanaOrdenar = false
                    }
                )
            }
        }
    }
}