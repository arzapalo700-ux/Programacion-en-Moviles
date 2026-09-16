package com.example.laboratorio4

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Tarea(
    val id: Int,
    val nombre: String,
    val completada: Boolean = false
)

@Composable
fun ItemTarea(
    tarea: Tarea,
    onEliminar: () -> Unit,
    onCambiarEstado: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Checkbox(
                    checked = tarea.completada,
                    onCheckedChange = onCambiarEstado
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = tarea.nombre,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            IconButton(onClick = onEliminar) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar tarea",
                    tint = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}