package org.example.huespedes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform