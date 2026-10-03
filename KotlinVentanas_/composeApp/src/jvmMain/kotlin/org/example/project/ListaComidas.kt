package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Clase Comida
data class Comida(
    val nombre: String,
    val tipo: String,
    val precio: Int
) {
}

// ArrayList con objetos
val comidasLista = arrayListOf(

    Comida("Taco", "Mex", 15),
    Comida("Hotdog", "Fast", 20),
    Comida("Pizza", "Ital", 30),
    Comida("Burger", "Fast", 25),
    // Nuevos objetos
    Comida("Burrito", "Mex", 35),
    Comida("Nachos", "Mex", 40),
    Comida("Papas Fritas", "Fast", 18),
    Comida("Alitas", "Fast", 50),
    Comida("Lasagna", "Ital", 60),
    Comida("Spaghetti", "Ital", 45),
    Comida("Quesadilla", "Mex", 22),
    Comida("Sandwich", "Fast", 28),
    Comida("Calzone", "Ital", 55),
    Comida("Hamburguesa Doble", "Fast", 48),
    Comida("Torta", "Mex", 32),
    Comida("Enchiladas", "Mex", 38),
    Comida("Ravioles", "Ital", 52),
    Comida("Pizza Pepperoni", "Ital", 70),
    Comida("Nuggets", "Fast", 26),
    Comida("Chilaquiles", "Mex", 44)
)

@Composable
fun ListaComidas() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Recorrido con for usando items
        items(comidasLista) { comida ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                Text(
                    text = comida.nombre,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "🧾 Tipo: ${comida.tipo}",
                    fontSize = 16.sp
                )

                Text(
                    text = "💲 Precio: $${comida.precio}",
                    fontSize = 14.sp
                )

                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}