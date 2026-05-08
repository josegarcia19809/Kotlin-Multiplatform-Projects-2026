package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RedesSociales() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // -------------------------------
        // Primera fila -> botones completos
        // -------------------------------
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Button(
                onClick = {}
            ) {

                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Facebook"
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text("Facebook")
            }

            Button(
                onClick = {}
            ) {

                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Gmail"
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text("Gmail")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // -------------------------------
        // Segunda fila -> botones redondos
        // -------------------------------
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            // Facebook
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF1877F2))
            ) {

                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Facebook",
                    tint = Color.White
                )
            }

            // WhatsApp
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF25D366))
            ) {

                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "WhatsApp",
                    tint = Color.White
                )
            }

            // Telegram
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0088CC))
            ) {

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Telegram",
                    tint = Color.White
                )
            }

            // Gmail
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEA4335))
            ) {

                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Correo",
                    tint = Color.White
                )
            }
        }
    }
}