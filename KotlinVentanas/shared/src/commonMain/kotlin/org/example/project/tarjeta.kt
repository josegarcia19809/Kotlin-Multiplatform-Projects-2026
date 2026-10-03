package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 1. Permite usar recursos de Compose Multiplatform en la función Font
import org.jetbrains.compose.resources.Font

// 2. TUS IMPORTS REALES (checa que empieza con el nombre del proyecto en minúsculas)
// Si el nombre de la fuente lleva guiones medios, cambiar aquí por guiones bajos
import kotlinventanas.shared.generated.resources.Res
import kotlinventanas.shared.generated.resources.PlaywriteARGuides_Regular



@Composable
fun Tarjeta() {

    // Aquí se define la fuente que se ha descargado
    val playFont = FontFamily(
        Font(
            resource = Res.font.PlaywriteARGuides_Regular
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Uso de fuentes en Compose Desktop",
                fontFamily = playFont,
                fontSize = 26.sp
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Texto con fuente predeterminada",
                fontSize = 26.sp
            )
        }
    }
}
