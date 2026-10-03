package org.example.saludo

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset
import kotlin.random.Random
import androidx.compose.animation.core.rememberInfiniteTransition

data class Particle(
    val x: Float,
    val y: Float,
    val size: Float,
    val scale: Float,
    val speed: Float,
    val delay: Float
)

@Composable
fun MotionAnimationView() {

    val randomCircle = remember {
        Random.nextInt(6, 13)
    }

    val particles = remember {
        List(randomCircle) {
            Particle(
                x = Random.nextFloat() * 256f,
                y = Random.nextFloat() * 256f,
                size = Random.nextInt(4, 81).toFloat(),
                scale = Random.nextDouble(0.1, 2.0).toFloat(),
                speed = Random.nextDouble(0.05, 1.0).toFloat(),
                delay = Random.nextDouble(0.0, 2.0).toFloat()
            )
        }
    }

    val scales = particles.map { particle ->

        val transition = rememberInfiniteTransition()

        transition.animateFloat(
            initialValue = 1f,
            targetValue = particle.scale,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = (1500 / particle.speed).toInt(),
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Canvas(
        modifier = Modifier
            .size(256.dp)
            .clip(CircleShape)
            .background(Color(0xFF00897B))
    ) {

        particles.forEachIndexed { index, particle ->

            val scale = scales[index].value

            drawCircle(
                color = Color.White.copy(alpha = 0.25f),
                radius = (particle.size / 2) * scale,
                center = Offset(
                    particle.x,
                    particle.y
                )
            )
        }
    }
}