package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val mozillaText = FontFamily(
    Font("fonts/MozillaText-Regular.ttf")
)

@Composable
fun FraudAlertCard() {
//
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDEDADA))
            .padding(20.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Column(
            modifier = Modifier
                .width(260.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .padding(20.dp)
        ) {

            // Encabezado
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Warning",
                    tint = Color(0xFFFF7043),
                    modifier = Modifier.size(28.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Alerta de Fraude",
                    fontFamily = mozillaText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Precio
            Row(
                verticalAlignment = Alignment.Bottom
            ) {

                Text(
                    text = "$43.20",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "USD",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fecha
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date",
                    tint = Color.Gray,
                    modifier = Modifier.size(22.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Thu, Oct 6",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Ubicación
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = Color.Gray,
                    modifier = Modifier.size(22.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Caracas, Venezuela",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            // Botón
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFF2F2F2)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp
                )
            ) {

                Text(
                    text = "Details",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }
        }
    }
}