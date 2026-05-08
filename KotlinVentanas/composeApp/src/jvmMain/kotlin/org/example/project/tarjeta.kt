package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val playFont = FontFamily(
    Font("fonts/PlaywriteARGuides-Regular.ttf")
)

@Composable
fun Tarjeta() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Texto con fuente personalizada
            Text(
                text = "Uso de fuentes en Compose Desktop",
                fontFamily = playFont,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Texto con fuente por default
            Text(
                text = "Texto con fuente predeterminada",
                fontSize = 26.sp
            )
        }
    }
}
