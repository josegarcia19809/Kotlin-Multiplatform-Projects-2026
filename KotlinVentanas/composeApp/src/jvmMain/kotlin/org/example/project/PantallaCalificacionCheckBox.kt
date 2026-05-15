package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaCalificacionCheckBox() {

    // Estado del TextField
    var calificacionTexto by remember {
        mutableStateOf("")
    }

    // Estado del CheckBox
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

        // CHECKBOX
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = participacion,
                onCheckedChange = {
                    participacion = it
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text =
                    if (participacion)
                        "✅ Sí participó"
                    else
                        "❌ No participó"
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
