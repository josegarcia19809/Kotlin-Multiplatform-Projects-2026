package org.example.saludo

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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font


data class UsuarioSimple(
    val nombre: String,
    val descripcion: String
)

val usuariosSimples = listOf(
    UsuarioSimple("José", "Usuario activo"),
    UsuarioSimple("María", "Nuevo registro"),
    UsuarioSimple("Juan", "Cliente frecuente"),
    UsuarioSimple("Ana", "Invitado"),
    UsuarioSimple("Luis", "Cuenta verificada"),
    UsuarioSimple("Carlos", "Sin actividad reciente"),
    UsuarioSimple("Laura", "Usuario activo"),
    UsuarioSimple("Miguel", "Cliente frecuente"),
    UsuarioSimple("Sofía", "Nuevo registro"),
    UsuarioSimple("Jorge", "Invitado"),
    UsuarioSimple("Lucía", "Usuario activo"),
    UsuarioSimple("Pedro", "Cuenta verificada"),
    UsuarioSimple("Elena", "Sin actividad reciente"),
    UsuarioSimple("Diego", "Cliente frecuente"),
    UsuarioSimple("Valeria", "Usuario activo"),
    UsuarioSimple("Andrés", "Nuevo registro"),
    UsuarioSimple("Fernanda", "Invitado"),
    UsuarioSimple("Ricardo", "Cuenta verificada"),
    UsuarioSimple("Daniela", "Cliente frecuente"),
    UsuarioSimple("Hugo", "Usuario activo")
)

val Bonbon = FontFamily(
    Font("fonts/Bonbon-Regular.ttf", FontWeight.Normal),
)

val Ubuntu = FontFamily(
    Font("fonts/Ubuntu-Bold.ttf", FontWeight.Normal),
)

@Composable
fun ListaUsuariosSimple() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(usuariosSimples) { usuario ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                Text(
                    text = usuario.nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Ubuntu,
                )

                Text(
                    text = usuario.descripcion,
                    fontSize = 14.sp
                )

                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}