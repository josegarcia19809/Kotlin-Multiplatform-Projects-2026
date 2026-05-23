package org.example.huespedes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.window.application

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

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text("🏨 SISTEMA DE HUÉSPEDES")

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Button(
                    onClick = {
                        mostrarVentanaAgregar = true
                    }
                ) {
                    Text("➕ Agregar huésped")
                }

                Button(
                    onClick = {
                        mostrarVentanaBuscar = true
                    }
                ) {

                    Text("🔍 Buscar huésped")
                }

                Button(
                    onClick = {
                        mostrarVentanaFiltrar = true
                    }
                ) {

                    Text("🌎 Filtrar por nacionalidad")
                }

                Button(
                    onClick = {
                        mostrarVentanaOrdenar = true
                    }
                ) {

                    Text("📅 Ordenar por días")
                }

                Button(
                    onClick = {
                        System.exit(0)
                    }
                ) {

                    Text("🚪 Salir")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Nombre",
                    modifier = Modifier.width(200.dp)
                )

                Text(
                    text = "Teléfono",
                    modifier = Modifier.width(150.dp)
                )

                Text(
                    text = "Días",
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = "Nacionalidad"
                )


            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {

                itemsIndexed(HuespedService.huespedes) { index, huesped ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {

                        Text(
                            text = huesped.nombre,
                            modifier = Modifier.width(200.dp)
                        )

                        Text(
                            text = huesped.telefono,
                            modifier = Modifier.width(150.dp)
                        )

                        Text(
                            text = huesped.dias.toString(),
                            modifier = Modifier.width(100.dp)
                        )

                        Text(
                            text = huesped.nacionalidad
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        Button(
                            onClick = {

                                indiceEditar = index

                                mostrarVentanaEditar = true
                            }
                        ) {

                            Text("✏️ Editar")
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(
                            onClick = {

                                indiceEliminar = index

                                mostrarConfirmacionEliminar = true
                            }
                        ) {

                            Text("🗑️ Borrar")
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
                    width = 350.dp,
                    height = 180.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {

                    Text(
                        "⚠️ ¿Deseas eliminar a ${
                            HuespedService.huespedes[indiceEliminar].nombre
                        }?"
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Button(
                            onClick = {

                                HuespedService.huespedes.removeAt(
                                    indiceEliminar
                                )

                                HuespedService.guardarArchivo()

                                mostrarConfirmacionEliminar = false
                            }
                        ) {

                            Text("✅ Sí")
                        }

                        Button(
                            onClick = {

                                mostrarConfirmacionEliminar = false
                            }
                        ) {

                            Text("❌ Cancelar")
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
                title = "Filtrar por nacionalidad"
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
                title = "Ordenar por días"
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