package org.example.huespedes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Text("🌎 Filtrar por nacionalidad")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nacionalidadBuscar,
            onValueChange = {
                nacionalidadBuscar = it
            },
            label = {
                Text("Nacionalidad")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                resultados =
                    HuespedService.huespedes.filter {

                        it.nacionalidad.lowercase() ==
                                nacionalidadBuscar.lowercase()
                    }

                mensaje =
                    if (resultados.isEmpty()) {
                        "❌ No se encontraron huéspedes"
                    } else {
                        "✅ ${resultados.size} huéspedes encontrados"
                    }
            }
        ) {

            Text("Filtrar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(mensaje)

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                "Nombre",
                modifier = Modifier.width(150.dp)
            )

            Text(
                "Teléfono",
                modifier = Modifier.width(120.dp)
            )

            Text(
                "Días",
                modifier = Modifier.width(80.dp)
            )

            Text("Nacionalidad")
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(resultados) { huesped ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                ) {

                    Text(
                        huesped.nombre,
                        modifier = Modifier.width(150.dp)
                    )

                    Text(
                        huesped.telefono,
                        modifier = Modifier.width(120.dp)
                    )

                    Text(
                        huesped.dias.toString(),
                        modifier = Modifier.width(80.dp)
                    )

                    Text(huesped.nacionalidad)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onCerrar()
            }
        ) {

            Text("Cerrar")
        }
    }
}