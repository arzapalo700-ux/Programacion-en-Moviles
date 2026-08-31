package com.example.biblioteca

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    println("=================================")
    println("   SISTEMA DE PRESTAMO DE LIBROS")
    println("=================================")

    print("Titulo del libro: ")
    val tituloLibro = readln()

    print("Tipo de usuario (Alumno/Profesor): ")
    val tipoUsuarioInput = readln().trim()

    val tarifaMulta = if (tipoUsuarioInput.contains("prof", ignoreCase = true) ||
        tipoUsuarioInput.contains("doc", ignoreCase = true)) {
        2.00
    } else {
        1.50
    }

    print("Fecha de prestamo (dd/mm/aaaa): ")
    val fechaPrestamoStr = readln().trim()
    val fechaPrestamo = LocalDate.parse(fechaPrestamoStr, formatter)

    val fechaEntrega = fechaPrestamo.plusDays(4)
    println("--> Fecha de entrega limite: ${fechaEntrega.format(formatter)}")

    print("Fecha de devolucion (dd/mm/aaaa): ")
    val fechaDevolucionStr = readln().trim()
    val fechaDevolucion = LocalDate.parse(fechaDevolucionStr, formatter)

    val diasAtraso = ChronoUnit.DAYS.between(fechaEntrega, fechaDevolucion).toInt()

    println("\n=================================")
    println("      RESUMEN DEL PRESTAMO")
    println("=================================")
    println("Libro: $tituloLibro")
    println("Usuario: $tipoUsuarioInput")
    println("Fecha de prestamo: ${fechaPrestamo.format(formatter)}")
    println("Fecha de entrega limite: ${fechaEntrega.format(formatter)}")
    println("Fecha de devolucion: ${fechaDevolucion.format(formatter)}")

    if (diasAtraso > 0) {
        println("Estado: Devuelto con $diasAtraso dia(s) de atraso.\n")
        println("--------------------------------------------------")
        println("%-5s %-14s %-12s %-12s".format("DIA", "FECHA", "MULTA DIA", "ACUMULADO"))
        println("--------------------------------------------------")

        var acumulado = 0.0
        var fechaMora = fechaEntrega

        for (dia in 1..diasAtraso) {
            fechaMora = fechaMora.plusDays(1)
            acumulado += tarifaMulta

            val fechaStr = fechaMora.format(formatter)
            val multaDiaStr = "S/ %.2f".format(tarifaMulta)
            val acumuladoStr = "S/ %.2f".format(acumulado)

            println("%-5d %-14s %-12s %-12s".format(dia, fechaStr, multaDiaStr, acumuladoStr))
        }

        println("--------------------------------------------------")
        println("MULTA TOTAL: S/ %.2f".format(acumulado))
        println("--------------------------------------------------")
    } else {
        println("Estado: Devuelto a tiempo (Sin atraso).")
        println("--------------------------------------------------")
        println("MULTA TOTAL: S/ 0.00")
        println("--------------------------------------------------")
    }
}

