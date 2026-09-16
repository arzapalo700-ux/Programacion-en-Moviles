package com.example.laboratorio4

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TemperatureDisplay() {
    // 2. Estado inicializado en 20 con remember y mutableStateOf
    var temperatura by remember { mutableStateOf(20) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 3. Muestra de temperatura en pantalla
        Text(
            text = "Temperatura: $temperatura °C",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 4. Botones Subir (temperatura++) y Bajar (temperatura--)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { temperatura++ }) {
                Text("Subir")
            }
            Button(onClick = { temperatura-- }) {
                Text("Bajar")
            }
            // 5. Botón Resetear que devuelve la temperatura a 20
            Button(onClick = { temperatura = 20 }) {
                Text("Resetear")
            }
        }
    }
}
