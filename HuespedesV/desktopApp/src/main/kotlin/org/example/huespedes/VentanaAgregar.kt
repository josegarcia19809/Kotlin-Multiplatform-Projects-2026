package org.example.huespedes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun VentanaAgregar(
    onCerrar: () -> Unit
) {

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var dias by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val focusTelefono = remember { FocusRequester() }
    val focusDias = remember { FocusRequester() }
    val focusNacionalidad = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        TextField(
            value = nombre,
            onValueChange = {
                nombre = it
            },
            label = {
                Text("Nombre")
            },
            modifier = Modifier.focusRequester(FocusRequester()),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                onNext = {
                    focusTelefono.requestFocus()
                }
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = telefono,
            onValueChange = {
                telefono = it
            },
            label = {
                Text("Teléfono")
            },
            modifier = Modifier.focusRequester(focusTelefono),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                onNext = {
                    focusDias.requestFocus()
                }
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = dias,
            onValueChange = {
                dias = it
            },
            label = {
                Text("Días")
            },
            modifier = Modifier.focusRequester(focusDias),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                onNext = {
                    focusNacionalidad.requestFocus()
                }
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nacionalidad,
            onValueChange = {
                nacionalidad = it
            },
            label = {
                Text("Nacionalidad")
            },
            modifier = Modifier.focusRequester(focusNacionalidad),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                HuespedService.agregar(
                    nombre,
                    telefono,
                    dias.toInt(),
                    nacionalidad
                )

                onCerrar()
            }
        ) {

            Text("Guardar")
        }
    }
}