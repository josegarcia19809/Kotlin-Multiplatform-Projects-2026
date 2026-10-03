package org.example.project



import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
fun PantallaCheckBox() {

    // Estado del CheckBox normal
    var activado by remember {
        mutableStateOf(false)
    }

    // Estado del CheckBox con iconos
    var activadoIcono by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // CHECKBOX NORMAL
        Text(
            text = "Checkbox normal",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = activado,
                onCheckedChange = {
                    activado = it
                }
            )

            Text(
                text =
                    if (activado)
                        "✅ ACTIVADO"
                    else
                        "❌ DESACTIVADO"
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // CHECKBOX CON ICONOS
        Text(
            text = "Checkbox con iconos",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = activadoIcono,
                onCheckedChange = {
                    activadoIcono = it
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector =
                    if (activadoIcono)
                        Icons.Default.Check
                    else
                        Icons.Default.Close,

                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text =
                    if (activadoIcono)
                        "🌙 Modo activado"
                    else
                        "☀️ Modo desactivado"
            )
        }
    }
}