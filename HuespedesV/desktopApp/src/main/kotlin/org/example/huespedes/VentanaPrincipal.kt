package org.example.huespedes


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState

private val FondoPrincipal = Color(0xFFEAF6F6)
private val SidebarColor = Color(0xFF17323B)

private val FondoCard = Color.White
private val VerdePrincipal = Color(0xFF2EC4B6)

private val GrisSuave = Color(0xFFF4F7F8)
private val TextoOscuro = Color(0xFF1E293B)

private val TextoSecundario = Color(0xFF7B8794)
private val Rojo = Color(0xFFE53935)


@Composable
fun VentanaPrincipal() {

    var mostrarVentanaAgregar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaBuscar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaOrdenar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaFiltrar by remember {
        mutableStateOf(false)
    }

    var mostrarVentanaEditar by remember {
        mutableStateOf(false)
    }

    var indiceEditar by remember {
        mutableStateOf(-1)
    }

    var mostrarConfirmacionEliminar by remember {
        mutableStateOf(false)
    }

    var indiceEliminar by remember {
        mutableStateOf(-1)
    }

    Row {

        Sidebar(

            onAgregar = {
                mostrarVentanaAgregar = true
            },

            onBuscar = {
                mostrarVentanaBuscar = true
            },

            onOrdenar = {
                mostrarVentanaOrdenar = true
            },

            onFiltrar = {
                mostrarVentanaFiltrar = true
            }
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            TopBar()

            Spacer(modifier = Modifier.height(20.dp))

            TablaHuespedes(

                onEditar = { index ->

                    indiceEditar = index

                    mostrarVentanaEditar = true
                },

                onEliminar = { index ->

                    indiceEliminar = index

                    mostrarConfirmacionEliminar = true
                }
            )
        }
    }

    // =========================
    // VENTANAS
    // =========================

    if (mostrarVentanaAgregar) {

        Window(
            onCloseRequest = {
                mostrarVentanaAgregar = false
            },

            title = "Agregar huésped"
        ) {

            VentanaAgregar(
                onCerrar = {
                    mostrarVentanaAgregar = false
                }
            )
        }
    }

    if (mostrarVentanaBuscar) {

        Window(
            onCloseRequest = {
                mostrarVentanaBuscar = false
            },

            title = "Buscar huésped"
        ) {

            VentanaBuscar(
                onCerrar = {
                    mostrarVentanaBuscar = false
                }
            )
        }
    }

    if (mostrarVentanaOrdenar) {

        Window(
            onCloseRequest = {
                mostrarVentanaOrdenar = false
            },

            title = "Ordenar huéspedes"
        ) {

            VentanaOrdenar(
                onCerrar = {
                    mostrarVentanaOrdenar = false
                }
            )
        }
    }

    if (mostrarVentanaFiltrar) {

        Window(
            onCloseRequest = {
                mostrarVentanaFiltrar = false
            },

            title = "Filtrar huéspedes"
        ) {

            VentanaFiltrar(
                onCerrar = {
                    mostrarVentanaFiltrar = false
                }
            )
        }
    }
    // =========================
    // VENTANA EDITAR
    // =========================

    if (
        mostrarVentanaEditar &&
        indiceEditar != -1
    ) {

        Window(
            onCloseRequest = {
                mostrarVentanaEditar = false
            },
            title = "Editar huésped"
        ) {

            VentanaEditar(
                indice = indiceEditar,
                huesped = HuespedService.huespedes[indiceEditar],
                onCerrar = {
                    mostrarVentanaEditar = false
                }
            )
        }
    }

    // =========================
    // CONFIRMAR ELIMINAR
    // =========================

    if (
        mostrarConfirmacionEliminar &&
        indiceEliminar != -1
    ) {

        Window(
            onCloseRequest = {
                mostrarConfirmacionEliminar = false
            },
            title = "Eliminar huésped",
            state = rememberWindowState(
                width = 420.dp,
                height = 220.dp
            )
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(FondoPrincipal)
                    .padding(25.dp)
            ) {

                Column {

                    Text(
                        text = "⚠️ Confirmar eliminación",
                        color = TextoOscuro,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "¿Deseas eliminar a ${HuespedService.huespedes[indiceEliminar].nombre}?",
                        color = TextoSecundario
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Button(
                            onClick = {

                                HuespedService.huespedes.removeAt(indiceEliminar)

                                HuespedService.guardarArchivo()

                                mostrarConfirmacionEliminar = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = VerdePrincipal,
                                contentColor = Color.White
                            )
                        ) {

                            Text("Sí")
                        }

                        Button(
                            onClick = {
                                mostrarConfirmacionEliminar = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Rojo,
                                contentColor = Color.White
                            )
                        ) {

                            Text("Cancelar")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Sidebar(
    onAgregar: () -> Unit,
    onBuscar: () -> Unit,
    onOrdenar: () -> Unit,
    onFiltrar: () -> Unit
) {

    Column(
        modifier = Modifier
            .width(90.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(30.dp))
            .background(SidebarColor)
            .padding(vertical = 25.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // BOTONES SUPERIORES

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {

            // SidebarButton(Icons.Default.Home)

            SidebarButton(Icons.Default.PersonAdd) {
                onAgregar()
            }

            SidebarButton(Icons.Default.Search) {
                onBuscar()
            }

            SidebarButton(Icons.AutoMirrored.Filled.Sort) {
                onOrdenar()
            }

            SidebarButton(Icons.Default.FilterList) {
                onFiltrar()
            }
        }

        // BOTÓN INFERIOR

        SidebarButton(Icons.AutoMirrored.Filled.ExitToApp) {
            System.exit(0)
        }
    }
}

@Composable
fun SidebarButton(
    icono: ImageVector,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier.size(58.dp),

        shape = RoundedCornerShape(18.dp),

        backgroundColor = Color.White.copy(alpha = 0.08f),

        elevation = 0.dp
    ) {

        IconButton(
            onClick = {
                onClick()
            },

            modifier = Modifier.fillMaxSize()
        ) {

            Icon(
                imageVector = icono,
                contentDescription = "",

                tint = Color.White,

                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun TarjetaInfo(
    emoji: String,
    numero: String,
    titulo: String
) {

    Card(
        backgroundColor = FondoCard,
        shape = RoundedCornerShape(22.dp),
        elevation = 5.dp,
        modifier = Modifier.width(180.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = emoji,
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = numero,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextoOscuro
            )

            Text(
                text = titulo,
                color = TextoSecundario
            )
        }
    }
}


@Composable
fun DialogoEliminar(
    nombre: String,
    onAceptar: () -> Unit,
    onCancelar: () -> Unit
) {

    Column {

        Text(
            text = "⚠️ Confirmar eliminación"
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "¿Deseas eliminar a $nombre?"
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row {

            Button(
                onClick = onAceptar
            ) {

                Text("Sí")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = onCancelar
            ) {

                Text("Cancelar")
            }
        }
    }
}

@Composable
fun TablaHuespedes(
    onEditar: (Int) -> Unit,
    onEliminar: (Int) -> Unit
) {

    Card(
        backgroundColor = FondoCard,
        shape = RoundedCornerShape(25.dp),
        elevation = 6.dp,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "Lista de huéspedes",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ENCABEZADOS

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(SidebarColor)
                    .padding(vertical = 16.dp, horizontal = 18.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(80.dp))

                Text(
                    text = "Nombre",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(180.dp)
                )

                Text(
                    text = "Teléfono",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(180.dp)
                )

                Text(
                    text = "Días",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = "Nacionalidad",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(180.dp)
                )


                Text(
                    text = "Acciones",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(180.dp)
                )

                Spacer(modifier = Modifier.width(100.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn  {

                itemsIndexed(HuespedService.huespedes) { index, huesped ->

                    FilaHuesped(
                        huesped = huesped,

                        onEditar = {
                            onEditar(index)
                        },

                        onEliminar = {
                            onEliminar(index)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun FilaHuesped(
    huesped: Huesped,
    onEditar: () -> Unit,
    onEliminar: () -> Unit
) {

    Card(
        backgroundColor = GrisSuave,
        shape = RoundedCornerShape(18.dp),
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            // ICONO / AVATAR

            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(SidebarColor),

                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Persona",

                    tint = Color.White,

                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(35.dp))


            Text(
                text = huesped.nombre,
                modifier = Modifier.width(180.dp)
            )

            Text(
                text = huesped.telefono,
                modifier = Modifier.width(180.dp)
            )

            Text(
                text = "${huesped.dias}",
                modifier = Modifier.width(100.dp)
            )

            Text(
                text = huesped.nacionalidad,
                modifier = Modifier.width(180.dp)
            )

            Button(
                onClick = onEditar,

                shape = CircleShape,

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = SidebarColor,
                    contentColor = Color.White
                ),

                modifier = Modifier.size(45.dp),

                contentPadding = PaddingValues(0.dp)
            ) {

                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Editar",
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = onEliminar,

                shape = CircleShape,

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = SidebarColor,
                    contentColor = Color.White
                ),

                modifier = Modifier.size(45.dp),

                contentPadding = PaddingValues(0.dp)
            ) {

                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun TopBar() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .clip(RoundedCornerShape(30.dp))
    ) {

        // IMAGEN DE FONDO

        Image(
            painter = painterResource("imagenes/hotel.jpg"),
            contentDescription = "Hotel",

            contentScale = ContentScale.Crop,

            modifier = Modifier.fillMaxSize()
        )

        // CAPA OSCURA ENCIMA

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Black.copy(alpha = 0.35f)
                )
        )

        // TEXO ABAJO

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(25.dp)
        ) {

            Text(
                text = "Sistema Hotel",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Administración moderna de huéspedes",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 16.sp
            )
        }
    }
}