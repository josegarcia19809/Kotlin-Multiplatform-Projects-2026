package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PantallaSwitch() {

    // Estado del Switch normal
    var activado by remember {
        mutableStateOf(false)
    }

    // Estado del Switch con iconos
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

        // SWITCH NORMAL
        Switch(
            checked = activado,
            onCheckedChange = {
                activado = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                if (activado)
                    "✅ Switch activado"
                else
                    "❌ Switch desactivado",

            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // SWITCH CON THUMB CONTENT
        Switch(
            checked = activadoIcono,
            onCheckedChange = {
                activadoIcono = it
            },

            thumbContent = {

                Icon(
                    imageVector =
                        if (activadoIcono)
                            Icons.Default.Check
                        else
                            Icons.Default.Close,

                    contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text =
                if (activadoIcono)
                    "🌙 Modo activado"
                else
                    "☀️ Modo desactivado",

            fontSize = 18.sp
        )
    }
}