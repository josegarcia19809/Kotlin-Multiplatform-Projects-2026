package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListaCheckBox() {

    // Lista de opciones
    val materias = listOf(
        "📘 Matemáticas",
        "🧪 Química",
        "💻 Programación",
        "🌎 Geografía",
        "📚 Historia",
        "🎨 Diseño"
    )

    // Lista de estados
    val estados: SnapshotStateList<Boolean> =
        remember {

            List(materias.size) {
                false
            }.toMutableStateList()
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "✅ Lista de CheckBox",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            itemsIndexed(materias) { indice, materia ->

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(
                        checked = estados[indice],

                        onCheckedChange = {

                            estados[indice] = it
                        }
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text =
                            if (estados[indice])
                                "$materia ✅"
                            else
                                "$materia ❌",

                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}