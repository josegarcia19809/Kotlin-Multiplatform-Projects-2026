package org.example.project


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PantallaCalificacion() {

    // Estado del TextField
    var calificacionTexto by remember {
        mutableStateOf("")
    }

    // Estado del Switch
    var participacion by remember {
        mutableStateOf(false)
    }

    // Resultado final
    var resultado by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🎓 Calificación Final",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Campo de texto
        OutlinedTextField(
            value = calificacionTexto,
            onValueChange = {
                calificacionTexto = it
            },

            label = {
                Text("Ingresa la calificación")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Switch de participación
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("¿Participó?")

            Spacer(modifier = Modifier.width(10.dp))

            Switch(
                checked = participacion,
                onCheckedChange = {
                    participacion = it
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón
        Button(
            onClick = {

                val calificacion =
                    calificacionTexto.toDoubleOrNull() ?: 0.0

                val final =
                    calcularCalificacionFinal(
                        calificacion,
                        participacion
                    )

                resultado =
                    "📚 La calificación final es $final"
            }
        ) {

            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = resultado,
            fontSize = 20.sp
        )
    }
}

// FUNCIÓN
fun calcularCalificacionFinal(
    calificacion: Double,
    participacion: Boolean
): Double {

    var bono: Double

    if (participacion == true) {
        bono = calificacion * 0.10
    } else {
        bono = 0.0
    }

    val calificacionFinal =
        calificacion + bono

    return calificacionFinal
}