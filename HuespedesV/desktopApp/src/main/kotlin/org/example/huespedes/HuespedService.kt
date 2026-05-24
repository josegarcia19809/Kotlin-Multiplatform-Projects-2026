package org.example.huespedes

import androidx.compose.runtime.mutableStateListOf
import java.io.File

object HuespedService {

    val huespedes = mutableStateListOf<Huesped>()

    private val nombreArchivo = "huespedes.txt"

    fun agregar(nombre: String, telefono: String, dias: Int, nacionalidad: String) {
        val nuevo = Huesped(nombre, telefono, dias, nacionalidad)
        huespedes.add(nuevo)
        guardarArchivo()
    }

    fun guardarArchivo() {
        val archivo = File(nombreArchivo)
        archivo.writeText("")
        for (huesped in huespedes) {
            val texto =
                "${huesped.nombre}|" +
                        "${huesped.telefono}|" +
                        "${huesped.dias}|" +
                        "${huesped.nacionalidad}\n"

            archivo.appendText(texto)
        }
    }

    fun leerArchivo() {
        val archivo = File(nombreArchivo)
        if (!archivo.exists()) {
            archivo.createNewFile()
        }

        val lineas = archivo.readLines()
        huespedes.clear()

        for (linea in lineas) {
            val campos = linea.split("|")
            if (campos.size == 4) {
                val nuevo = Huesped(
                    campos[0],
                    campos[1],
                    campos[2].toInt(),
                    campos[3]
                )
                huespedes.add(nuevo)
            }
        }
    }
}