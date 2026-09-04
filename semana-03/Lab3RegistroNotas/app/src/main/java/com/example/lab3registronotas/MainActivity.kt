package com.example.lab3registronotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab3registronotas.ui.theme.Lab3RegistroNotasTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3RegistroNotasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF3E8FF)
                ) {
                    RegistroNotasScreen()
                }
            }
        }
    }
}

@Composable
fun RegistroNotasScreen() {
    var notaFundamentos by remember { mutableFloatStateOf(0f) }
    var notaPoo by remember { mutableFloatStateOf(0f) }
    var notaMoviles by remember { mutableFloatStateOf(0f) }
    var notaBaseDatos by remember { mutableFloatStateOf(0f) }

    var redondear by remember { mutableStateOf(false) }
    var confirmado by remember { mutableStateOf(false) }

    var promedioPonderado by remember { mutableDoubleStateOf(0.0) }
    var promedioFinalTexto by remember { mutableStateOf("") }
    var calculado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF5B3E96), Color(0xFF6B4FA0))
                    )
                )
                .statusBarsPadding()
                .padding(vertical = 20.dp, horizontal = 24.dp)
        ) {
            Text(
                text = "Registro de Notas",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Notas del ciclo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C1B4D)
            )
            Text(
                text = "Desliza para asignar cada nota (0 a 20)",
                fontSize = 13.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            CursoItem("Fundamentos de Programación", "(20%)", notaFundamentos) { notaFundamentos = it }
            CursoItem("Programación Orientada a Objetos", "(25%)", notaPoo) { notaPoo = it }
            CursoItem("Programación en Móviles", "(30%)", notaMoviles) { notaMoviles = it }
            CursoItem("Base de Datos", "(25%)", notaBaseDatos) { notaBaseDatos = it }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Redondear promedio final", fontSize = 15.sp, color = Color(0xFF2C1B4D))
                Switch(
                    checked = redondear,
                    onCheckedChange = { redondear = it }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = confirmado,
                    onCheckedChange = { confirmado = it }
                )
                Text(
                    text = "Confirmo que las notas son correctas",
                    fontSize = 14.sp,
                    color = Color(0xFF2C1B4D)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val n1 = notaFundamentos.roundToInt()
                    val n2 = notaPoo.roundToInt()
                    val n3 = notaMoviles.roundToInt()
                    val n4 = notaBaseDatos.roundToInt()

                    val promPond = (n1 * 0.20) + (n2 * 0.25) + (n3 * 0.30) + (n4 * 0.25)
                    promedioPonderado = promPond

                    promedioFinalTexto = if (redondear) {
                        "${promPond.roundToInt()}"
                    } else {
                        String.format("%.2f", promPond)
                    }
                    calculado = true
                },
                enabled = confirmado,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text("CALCULAR PROMEDIO", fontWeight = FontWeight.Bold, color = Color.White)
            }

            if (calculado) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Promedio final: $promedioFinalTexto", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CursoItem(
    nombre: String,
    peso: String,
    nota: Float,
    onNotaChange: (Float) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = nombre, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = peso, fontSize = 12.sp, color = Color(0xFF7E57C2))
            }
            Surface(
                color = Color(0xFFEDE7F6),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "${nota.roundToInt()}",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5B3E96),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }
        }
        Slider(
            value = nota,
            onValueChange = onNotaChange,
            valueRange = 0f..20f,
            steps = 19
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroNotasScreenPreview() {
    Lab3RegistroNotasTheme {
        RegistroNotasScreen()
    }
}