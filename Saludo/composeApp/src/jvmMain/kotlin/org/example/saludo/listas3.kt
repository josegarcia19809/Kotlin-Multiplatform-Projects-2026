package org.example.saludo

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import saludo.composeapp.generated.resources.*

/* 🎨 Colores neon */
val neonGreen = Color(0xFF39FF14)
val neonSoft = Color(0xFF7CFF6B)
val darkBackground = Color(0xFF0A0A0A)
val cardBase = Color(0xFF121212)
val cardSelected = Color(0xFF163D16)

/* 🧠 Modelo */
data class Usuario(
    val nombre: String,
    val descripcion: String,
    val imagen: DrawableResource,
    val online: Boolean = true
)

/* 📊 Datos */
val usuarios = listOf(
    Usuario("Jesús", "Usuario activo", Res.drawable.jesus, true),
    Usuario("Juan", "Nuevo registro", Res.drawable.juan, false),
    Usuario("María", "Cliente frecuente", Res.drawable.maria, true),
    Usuario("Nohemí", "Invitado", Res.drawable.nohemi, false),
    Usuario("Pedro", "Cuenta verificada", Res.drawable.pedro, true),
    Usuario("Ruth", "Sin actividad reciente", Res.drawable.ruth, false)
)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ListaUsuariosUltraPro() {

    var search by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<Usuario?>(null) }

    val filtrados = usuarios.filter {
        it.nombre.contains(search, ignoreCase = true)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = darkBackground
    ) {

        Column {

            // 🏷️ HEADER
            Text(
                text = "Usuarios 🚀",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = neonGreen,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    shadow = Shadow(
                        color = neonGreen,
                        blurRadius = 12f
                    )
                )
            )

            // 🔍 BUSCADOR
            BasicTextField(
                value = search,
                onValueChange = { search = it },
                textStyle = TextStyle(color = neonSoft),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(
                        1.dp,
                        neonGreen,
                        RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 📜 LISTA
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(filtrados) { usuario ->

                    var hovered by remember { mutableStateOf(false) }

                    val borderColor by animateColorAsState(
                        if (hovered) neonGreen else Color.Transparent
                    )

                    val elevation by animateDpAsState(
                        if (hovered) 10.dp else 2.dp
                    )

                    val bgColor by animateColorAsState(
                        if (selected == usuario) cardSelected else cardBase
                    )

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .pointerMoveFilter(
                                onEnter = { hovered = true; false },
                                onExit = { hovered = false; false }
                            )
                            .border(
                                2.dp,
                                borderColor,
                                RoundedCornerShape(16.dp)
                            ),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(bgColor),
                        elevation = CardDefaults.cardElevation(elevation),
                        onClick = { selected = usuario }
                    ) {

                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            val glowAlpha by animateFloatAsState(
                                if (hovered) 0.4f else 0.15f
                            )

                            Box(
                                modifier = Modifier.size(60.dp),
                                contentAlignment = Alignment.Center
                            ) {

                                // 🌈 Glow animado
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .background(neonGreen.copy(alpha = glowAlpha))
                                )

                                Image(
                                    painter = painterResource(usuario.imagen),
                                    contentDescription = usuario.nombre,
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clip(CircleShape)
                                        .border(
                                            width = if (hovered) 3.dp else 2.dp,
                                            color = neonGreen,
                                            shape = CircleShape
                                        ),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Column(
                                modifier = Modifier.padding(start = 12.dp)
                            ) {

                                // 🟢 Nombre
                                Text(
                                    text = usuario.nombre,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = neonGreen,
                                    style = TextStyle(
                                        shadow = Shadow(
                                            color = neonGreen,
                                            blurRadius = 8f
                                        )
                                    )
                                )

                                // ⚪ Descripción
                                Text(
                                    text = usuario.descripcion,
                                    fontSize = 14.sp,
                                    color = neonSoft
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}