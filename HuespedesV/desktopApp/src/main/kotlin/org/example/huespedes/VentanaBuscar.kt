package org.example.huespedes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text("🔍 Buscar huésped")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nombreBuscar,
            onValueChange = {
                nombreBuscar = it
            },
            label = {
                Text("Nombre")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val resultado =
                    HuespedService.huespedes.find {
                        it.nombre.contains(nombreBuscar, true)
                    }

                if (resultado != null) {
                    huespedEncontrado = resultado
                    mensaje = "✅ Huésped encontrado"
                } else {
                    huespedEncontrado = null
                    mensaje = "❌ No encontrado"
                }
            }
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(mensaje)

        Spacer(modifier = Modifier.height(10.dp))

        huespedEncontrado?.let { huesped ->

            Text("Nombre: ${huesped.nombre}")
            Text("Teléfono: ${huesped.telefono}")
            Text("Días: ${huesped.dias}")
            Text("Nacionalidad: ${huesped.nacionalidad}")
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