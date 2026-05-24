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
fun VentanaAgregar(onCerrar: () -> Unit) {

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

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Text("➕ Agregar huésped")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = dias,
            onValueChange = { dias = it },
            label = { Text("Días") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nacionalidad,
            onValueChange = { nacionalidad = it },
            label = { Text("Nacionalidad") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (mensajeError.isNotEmpty()) {
            Text(mensajeError)
            Spacer(modifier = Modifier.height(10.dp))
        }

        Button(
            onClick = {
                if (
                    nombre.isBlank() ||
                    telefono.isBlank() ||
                    dias.isBlank() ||
                    nacionalidad.isBlank()
                ) {
                    mensajeError = "⚠️ Todos los campos son obligatorios"

                    return@Button
                }

                val diasNumero = dias.toIntOrNull()

                if (diasNumero == null) {
                    mensajeError = "⚠️ Los días deben ser numéricos"
                    return@Button
                }

                if (diasNumero <= 0) {
                    mensajeError = "⚠️ Los días deben ser mayores a 0"
                    return@Button
                }

                HuespedService.agregar(nombre, telefono, diasNumero, nacionalidad)

                onCerrar()
            }
        ) {
            Text("Guardar")
        }
    }
}