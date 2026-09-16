package com.example.laboratorio4

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TemperatureDisplay() {
    var temperatura by remember { mutableStateOf(20) }

    // Bonus: Determinar el color del texto según la temperatura
    val colorTexto = when {
        temperatura >= 25 -> Color.Red
        temperatura <= 15 -> Color.Blue
        else -> Color.Unspecified
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Temperatura: $temperatura °C",
            style = MaterialTheme.typography.headlineMedium,
            color = colorTexto
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { temperatura++ }) {
                Text("Subir")
            }
            Button(onClick = { temperatura-- }) {
                Text("Bajar")
            }
            Button(onClick = { temperatura = 20 }) {
                Text("Resetear")
            }
        }
    }
}
