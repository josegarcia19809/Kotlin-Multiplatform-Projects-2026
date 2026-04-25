package org.example.saludo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

data class PersonaBasica(
    val nombre: String,
    val descripcion: String
)

val personasLista = listOf(
    PersonaBasica("José", "Usuario activo"),
    PersonaBasica("María", "Nuevo registro"),
    PersonaBasica("Juan", "Cliente frecuente"),
    PersonaBasica("Ana", "Invitado"),
    PersonaBasica("Luis", "Cuenta verificada"),
    PersonaBasica("Carlos", "Sin actividad reciente")
)

@Composable
fun MyBasicList1() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(personasLista) { persona ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                Text(
                    text = persona.nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = persona.descripcion,
                    fontSize = 14.sp
                )

                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}