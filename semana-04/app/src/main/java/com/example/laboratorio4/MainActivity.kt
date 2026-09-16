package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaTareasApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListaTareasApp(modifier: Modifier = Modifier) {
    var textoTarea by remember { mutableStateOf("") }
    val listaTareas = remember { mutableStateListOf<Tarea>() }
    var idCounter by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lista de tareas - Tecsup",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = textoTarea,
            onValueChange = { textoTarea = it },
            label = { Text("¿Qué tarea tienes pendiente?") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (textoTarea.isNotBlank()) {
                    listaTareas.add(Tarea(id = idCounter++, nombre = textoTarea.trim()))
                    textoTarea = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar tarea")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total de tareas: ${listaTareas.size}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(listaTareas, key = { it.id }) { tarea ->
                ItemTarea(
                    tarea = tarea,
                    onEliminar = { listaTareas.remove(tarea) },
                    onCambiarEstado = { nuevoEstado ->
                        val index = listaTareas.indexOf(tarea)
                        if (index != -1) {
                            listaTareas[index] = tarea.copy(completada = nuevoEstado)
                        }
                    }
                )
            }
        }
    }
}