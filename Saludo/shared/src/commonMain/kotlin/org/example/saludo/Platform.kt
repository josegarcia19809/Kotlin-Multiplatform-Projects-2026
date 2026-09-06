package org.example.saludo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform