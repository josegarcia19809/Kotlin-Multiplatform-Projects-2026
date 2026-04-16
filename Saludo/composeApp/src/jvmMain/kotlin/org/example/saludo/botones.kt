package org.example.saludo


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Botones() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 🏷️ TÍTULO ARRIBA
        Text(
            text = "Ejemplo de Botones",
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // 🔘 FILA DE BOTONES CENTRADA
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BotonElevado()
            SpaceHorizontal()
            BotonSecundario()
            SpaceHorizontal()
            BotonOutlined()
            SpaceHorizontal()
            BotonTexto()
        }
    }
}

@Composable
fun BotonConIcono() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6200EE),
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Carrito",
            modifier = Modifier.padding(end = 8.dp)
        )
        Text("Comprar", fontSize = 18.sp)
    }
}

@Composable
fun SpaceHorizontal() {
    Spacer(modifier = Modifier.width(10.dp))
}

@Composable
fun BotonIcono() {
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorito",
            tint = Color(0xFFE53935)
        )
    }
}

@Composable
fun BotonElevado() {
    ElevatedButton(
        onClick = {},
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xFF1976D2),
            contentColor = Color.White
        )
    ) {
        Text("Primario", fontSize = 20.sp)
    }
}

@Composable
fun BotonSecundario() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF388E3C),
            contentColor = Color.White
        )
    ) {
        Text("Secundario", fontSize = 20.sp)
    }
}

@Composable
fun BotonOutlined() {
    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFFD32F2F)
        ),
        border = BorderStroke(2.dp, Color(0xFFD32F2F))
    ) {
        Text("Outlined", fontSize = 20.sp)
    }
}

@Composable
fun BotonTexto() {
    TextButton(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color(0xFF7B1FA2)
        )
    ) {
        Text("Text Button", fontSize = 20.sp)
    }
}

