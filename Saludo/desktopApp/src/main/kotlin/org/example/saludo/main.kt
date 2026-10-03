package org.example.saludo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Saludo",
    ) {
<<<<<<< Updated upstream
        mensajes()
=======
<<<<<<< Updated upstream
        sumarNumeros()
=======
        MotionAnimationView()
>>>>>>> Stashed changes
>>>>>>> Stashed changes
    }
}