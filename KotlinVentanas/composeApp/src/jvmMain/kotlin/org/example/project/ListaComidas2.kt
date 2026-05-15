package org.example.project


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Clase ComidaE
data class ComidaE(
    val emoji: String,
    val nombre: String,
    val tipo: String,
    val precio: Int
)

// ArrayList con objetos
val comidasListaE = arrayListOf(

    ComidaE("🌮", "Taco", "Mex", 15),
    ComidaE("🌭", "Hotdog", "Fast", 20),
    ComidaE("🍕", "Pizza", "Ital", 30),
    ComidaE("🍔", "Burger", "Fast", 25),
    ComidaE("🌯", "Burrito", "Mex", 35),
    ComidaE("🧀", "Nachos", "Mex", 40),
    ComidaE("🍟", "Papas Fritas", "Fast", 18),
    ComidaE("🍗", "Alitas", "Fast", 50),
    ComidaE("🍝", "Lasagna", "Ital", 60),
    ComidaE("🍜", "Spaghetti", "Ital", 45),
    ComidaE("🥙", "Quesadilla", "Mex", 22),
    ComidaE("🥪", "Sandwich", "Fast", 28),
    ComidaE("🥟", "Calzone", "Ital", 55),
    ComidaE("🍔", "Hamburguesa Doble", "Fast", 48),
    ComidaE("🥖", "Torta", "Mex", 32),
    ComidaE("🌶️", "Enchiladas", "Mex", 38),
    ComidaE("🍝", "Ravioles", "Ital", 52),
    ComidaE("🍕", "Pizza Pepperoni", "Ital", 70),
    ComidaE("🍗", "Nuggets", "Fast", 26),
    ComidaE("🍳", "Chilaquiles", "Mex", 44)
)

@Composable
fun ListaComidas2() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFF3E0),
                        Color(0xFFFFE0B2)
                    )
                )
            )
            .padding(16.dp)
    ) {

        // TÍTULO
        Text(
            text = "🍔 Comida Rápida",
            fontSize = 30.sp,
            fontFamily = mozillaText,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = "¡Arma tu menú digital! 😋",
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(comidasListaE) { comida ->

                Card(
                    modifier = Modifier.fillMaxWidth(),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),

                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // EMOJI
                        Text(
                            text = comida.emoji,
                            fontSize = 42.sp
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = comida.nombre,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "🧾 Tipo: ${comida.tipo}",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                        }

                        // PRECIO
                        Text(
                            text = "$${comida.precio}",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}