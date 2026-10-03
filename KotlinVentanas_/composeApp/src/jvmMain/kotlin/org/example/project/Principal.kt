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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
fun Principal() {

    MaterialTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFDDEEEF),
                            Color(0xFFA8C4C9)
                        )
                    )
                )
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxSize()
            ) {

                // ================= SIDEBAR =================
                Sidebar()

                Spacer(modifier = Modifier.width(20.dp))

                // ================= MAIN CONTENT =================
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    TopBar()

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.weight(1f)
                    ) {

                        // LEFT SIDE
                        Column(
                            modifier = Modifier.weight(2f)
                        ) {

                            StatsSection()

                            Spacer(modifier = Modifier.height(20.dp))

                            BookingCard()

                            Spacer(modifier = Modifier.height(20.dp))

                            ScheduleCard()
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        // RIGHT SIDE
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            DoctorCard()

                            Spacer(modifier = Modifier.height(20.dp))

                            PatientsCard()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Sidebar() {

    Card(
        modifier = Modifier
            .fillMaxHeight()
            .width(90.dp),
        backgroundColor = Color(0xFF13242E),
        shape = RoundedCornerShape(30.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                Icons.Default.Dashboard,
                contentDescription = null,
                tint = Color.White
            )

            Icon(
                Icons.Default.People,
                contentDescription = null,
                tint = Color.White
            )

            Icon(
                Icons.Default.Email,
                contentDescription = null,
                tint = Color.White
            )

            Icon(
                Icons.Default.CalendarMonth,
                contentDescription = null,
                tint = Color.White
            )

            Icon(
                Icons.Default.Settings,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun TopBar() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFF4F7F7),
        elevation = 0.dp,
        shape = RoundedCornerShape(20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.width(300.dp),
                placeholder = {
                    Text("Search")
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, null)
                },
                shape = RoundedCornerShape(50.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(Icons.Default.Email, null)

                Spacer(modifier = Modifier.width(15.dp))

                Icon(Icons.Default.Notifications, null)

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    "Dr. John Jacob",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun StatsSection() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFF4F7F7),
        shape = RoundedCornerShape(25.dp),
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "Incoming Patient History",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                StatItem("1215", "Consultation")
                StatItem("345", "In Progress", true)
                StatItem("93", "In Review")
                StatItem("71", "In Pending")
            }
        }
    }
}

@Composable
fun StatItem(
    number: String,
    label: String,
    selected: Boolean = false
) {

    Card(
        backgroundColor = if (selected)
            Color(0xFFD9F0F0)
        else
            Color.White,
        shape = RoundedCornerShape(18.dp),
        elevation = 0.dp,
        modifier = Modifier.width(140.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                number,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(label)
        }
    }
}

@Composable
fun BookingCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFF4F7F7),
        shape = RoundedCornerShape(25.dp),
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "Booking Rate",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "58%",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00A9A5)
            )

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = 0.58f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                color = Color(0xFF00A9A5)
            )
        }
    }
}

@Composable
fun ScheduleCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFF4F7F7),
        shape = RoundedCornerShape(25.dp),
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "My Schedule",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                listOf(
                    "12", "13", "14",
                    "15", "16", "17", "18"
                ).forEach {

                    Card(
                        backgroundColor = if (it == "15")
                            Color(0xFFD9F0F0)
                        else
                            Color.White,
                        shape = RoundedCornerShape(15.dp),
                        elevation = 0.dp
                    ) {

                        Column(
                            modifier = Modifier.padding(15.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                it,
                                fontWeight = FontWeight.Bold
                            )

                            Text("DAY")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DoctorCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFF4F7F7),
        shape = RoundedCornerShape(25.dp),
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "Good Morning!",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Dr. John Jacob",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(
                "Orthodontist",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD9F0F0)),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    "784\nPatients",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class Patient(
    val hour: String,
    val name: String
)

@Composable
fun PatientsCard() {

    val patients = listOf(
        Patient("08:00", "Sarah Hosten"),
        Patient("09:00", "Angela John"),
        Patient("10:00", "Meghan Mathew"),
        Patient("11:00", "John Jacob"),
        Patient("12:00", "Sara Watson"),
        Patient("14:00", "Tresa Tiffany"),
        Patient("16:00", "Meghan Morse"),
        Patient("17:00", "Wallace Stone")
    )

    Card(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color(0xFFF4F7F7),
        shape = RoundedCornerShape(25.dp),
        elevation = 0.dp
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "Your Patients Today",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {

                items(patients) { patient ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        backgroundColor = Color.White,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(15.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(patient.hour)

                            Text(patient.name)

                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}