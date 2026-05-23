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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VentanaOrdenar(
    onCerrar: () -> Unit
) {

    val huespedesOrdenados =
        HuespedService.huespedes.sortedBy {
            it.dias
        }

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Text("📅 Huéspedes ordenados por días")

        Spacer(modifier = Modifier.height(20.dp))

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

            items(huespedesOrdenados) { huesped ->

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