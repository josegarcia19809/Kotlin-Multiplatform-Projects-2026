package org.example.huespedes

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    HuespedService.leerArchivo()
    Window(
        onCloseRequest = ::exitApplication,
        title = "HuespedesV",
        state = rememberWindowState(
            width = 1080.dp,
            height = 768.dp
        )
    ) {
        VentanaPrincipal()
    }
}