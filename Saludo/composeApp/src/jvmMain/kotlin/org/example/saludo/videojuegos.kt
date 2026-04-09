package org.example.saludo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import saludo.composeapp.generated.resources.Res
import saludo.composeapp.generated.resources.fortnite
import saludo.composeapp.generated.resources.god_of_war
import saludo.composeapp.generated.resources.halo_infinite
import saludo.composeapp.generated.resources.minecraft

@OptIn(ExperimentalResourceApi::class)
@Composable
fun VentanaGaleria() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // 🏷️ Título
        Text(
            text = "Galería de imágenes de videojuegos",
            style = MaterialTheme.typography.h5
        )

        // 🔲 Cuadrícula que ocupa TODO el espacio restante
        Column(
            modifier = Modifier.weight(1f), // 🔥 ocupa todo el espacio disponible
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Image(
                    painter = painterResource(Res.drawable.fortnite),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )

                Image(
                    painter = painterResource(Res.drawable.god_of_war),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
            }

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Image(
                    painter = painterResource(Res.drawable.halo_infinite),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )

                Image(
                    painter = painterResource(Res.drawable.minecraft),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
            }
        }
    }
}
