package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

@Composable
fun ComboBoxEjemplo() {

    var expanded by remember {
        mutableStateOf(false)
    }

    val opciones = listOf(
        "Perfil",
        "Configuración",
        "Cerrar sesión"
    )

    var opcionSeleccionada by remember {
        mutableStateOf(opciones[0])
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {

                OutlinedTextField(
                    value = opcionSeleccionada,
                    onValueChange = {},
                    readOnly = true,
                    label = {
                        Text("Opciones")
                    },
                    modifier = Modifier.width(250.dp)
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {

                    opciones.forEach { opcion ->

                        DropdownMenuItem(
                            text = {
                                Text(opcion)
                            },
                            onClick = {
                                opcionSeleccionada = opcion
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(5.dp))

            IconButton(
                onClick = {
                    expanded = true
                }
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Expandir menú"
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Seleccionaste: $opcionSeleccionada")
    }
}