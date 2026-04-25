package org.example.saludo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import saludo.composeapp.generated.resources.*

data class Persona(
    val nombre: String,
    val descripcion: String,
    val imagen: DrawableResource
)

val personas = listOf(
    Persona("Jesús", "Usuario activo", Res.drawable.jesus),
    Persona("Juan", "Nuevo registro", Res.drawable.juan),
    Persona("María", "Cliente frecuente", Res.drawable.maria),
    Persona("Nohemí", "Invitado", Res.drawable.nohemi),
    Persona("Pedro", "Cuenta verificada", Res.drawable.pedro),
    Persona("Ruth", "Sin actividad reciente", Res.drawable.ruth)
)

@Composable
fun MyBasicList2() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        items(personas) { persona ->

            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // 🖼️ Imagen PRO (tu formato correcto)
                    Image(
                        painter = painterResource(persona.imagen),
                        contentDescription = persona.nombre,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .border(
                                2.dp,
                                MaterialTheme.colorScheme.primary,
                                CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {

                        Text(
                            text = persona.nombre,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = persona.descripcion,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                }

                HorizontalDivider()
            }
        }
    }
}