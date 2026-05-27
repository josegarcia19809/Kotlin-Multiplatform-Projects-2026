package org.example.project


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Fondo = Color(0xFFEAF6F6)
private val Sidebar = Color(0xFF16323B)

private val CardColor = Color.White
private val Verde = Color(0xFF28C7B7)

private val Texto = Color(0xFF1F2937)
private val TextoSuave = Color(0xFF7B8794)

@Composable
fun DashboardMedico() {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(20.dp)
    ) {

        // =========================
        // SIDEBAR
        // =========================

        Column(
            modifier = Modifier
                .width(90.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(30.dp))
                .background(Sidebar)
                .padding(vertical = 30.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {

            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.DateRange,
                    contentDescription = "",
                    tint = Color.White
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.width(20.dp))

        // =========================
        // CONTENIDO
        // =========================

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // TOP BAR

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text("Buscar...")
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier.width(300.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "",
                        tint = TextoSuave
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(
                        "Dr. John Jacob",
                        color = Texto,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                // PANEL IZQUIERDO

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Estadisticas()

                    Spacer(modifier = Modifier.height(20.dp))

                    BookingRate()

                    Spacer(modifier = Modifier.height(20.dp))

                    Schedule()
                }

                Spacer(modifier = Modifier.width(20.dp))

                // PANEL DERECHO

                Column(
                    modifier = Modifier.width(320.dp)
                ) {

                    PerfilDoctor()

                    Spacer(modifier = Modifier.height(20.dp))

                    PacientesHoy()
                }
            }
        }
    }
}

@Composable
fun Estadisticas() {

    Card(
        shape = RoundedCornerShape(25.dp),
        backgroundColor = CardColor,
        elevation = 5.dp,
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            TarjetaMini("1215", "Consultas")
            TarjetaMini("345", "En progreso")
            TarjetaMini("93", "En revisión")
            TarjetaMini("71", "Pendientes")
        }
    }
}

@Composable
fun TarjetaMini(
    numero: String,
    texto: String
) {

    Card(
        backgroundColor = Fondo,
        shape = RoundedCornerShape(18.dp),
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier
                .padding(20.dp)
                .width(120.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                numero,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Texto
            )

            Text(
                texto,
                color = TextoSuave
            )
        }
    }
}

@Composable
fun BookingRate() {

    Card(
        shape = RoundedCornerShape(25.dp),
        backgroundColor = CardColor,
        elevation = 5.dp,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(25.dp)
        ) {

            Text(
                "Booking Rate",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Texto
            )

            Spacer(modifier = Modifier.height(20.dp))

            LinearProgressIndicator(
                progress = 0.58f,
                color = Verde,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .clip(RoundedCornerShape(50.dp))
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "58% de reservaciones",
                color = TextoSuave
            )
        }
    }
}

@Composable
fun Schedule() {

    Card(
        shape = RoundedCornerShape(25.dp),
        backgroundColor = CardColor,
        elevation = 5.dp,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(25.dp)
        ) {

            Text(
                "Mi horario",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Texto
            )

            Spacer(modifier = Modifier.height(20.dp))

            repeat(6) {

                Divider()

                Spacer(modifier = Modifier.height(18.dp))
            }
        }
    }
}

@Composable
fun PerfilDoctor() {

    Card(
        shape = RoundedCornerShape(25.dp),
        backgroundColor = CardColor,
        elevation = 5.dp
    ) {

        Column(
            modifier = Modifier.padding(25.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Verde)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                "Dr. John Jacob",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Texto
            )

            Text(
                "Ortodontista",
                color = TextoSuave
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "784 pacientes",
                color = Verde,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PacientesHoy() {

    val pacientes = listOf(
        "Sarah Hosten",
        "Angela John",
        "Meghan Mathew",
        "Sara Watson",
        "Jane Andrews"
    )

    Card(
        shape = RoundedCornerShape(25.dp),
        backgroundColor = CardColor,
        elevation = 5.dp,
        modifier = Modifier.fillMaxHeight()
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "Pacientes de hoy",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Texto
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {

                items(pacientes) { paciente ->

                    Card(
                        backgroundColor = Fondo,
                        shape = RoundedCornerShape(16.dp),
                        elevation = 0.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Row(
                            modifier = Modifier.padding(15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(45.dp)
                                    .clip(CircleShape)
                                    .background(Verde)
                            )

                            Spacer(modifier = Modifier.width(15.dp))

                            Text(
                                paciente,
                                color = Texto,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    }
}