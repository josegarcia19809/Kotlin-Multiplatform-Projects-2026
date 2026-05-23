package org.example.huespedes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Text("✏️ Editar huésped")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nombre,
            onValueChange = {
                nombre = it
            },
            label = {
                Text("Nombre")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = telefono,
            onValueChange = {
                telefono = it
            },
            label = {
                Text("Teléfono")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = dias,
            onValueChange = {
                dias = it
            },
            label = {
                Text("Días")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nacionalidad,
            onValueChange = {
                nacionalidad = it
            },
            label = {
                Text("Nacionalidad")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                HuespedService.huespedes[indice] =
                    Huesped(
                        nombre,
                        telefono,
                        dias.toInt(),
                        nacionalidad
                    )

                HuespedService.guardarArchivo()
                onCerrar()
            }
        ) {

            Text("Guardar cambios")
        }
    }
}