package com.example.lab02carritokotlin

// 1. CLASE PRODUCTO (Encapsulamiento de datos)
data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int,
    val categoria: String
) {
    fun calcularSubtotal(): Double = precio * cantidad
}

// 2. ASISTENTE DE IA (Módulo de recomendación)
class AsistenteIA {
    fun recomendarProducto(subtotal: Double): String {
        return when {
            subtotal < 100.0 -> "Agrega productos por S/ ${String.format("%.2f", 100.0 - subtotal)} más para obtener envío gratis."
            subtotal in 1000.0..2000.0 -> "¡Estás cerca de un súper descuento! Supera los S/ 2000 para obtener un 10% OFF."
            else -> "¡Felicidades! Calificas para el descuento máximo del 10% y envío VIP."
        }
    }
}

// 3. CLASE CARRITO (Lógica principal con POO)
class Carrito(val cliente: String) {
    private val productos = mutableListOf<Producto>()
    private val ia = AsistenteIA()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
        println("Producto agregado: ${producto.nombre}")
    }

    fun calcularSubtotal(): Double = productos.sumOf { it.calcularSubtotal() }

    fun calcularDescuento(porcentaje: Double = 10.0): Double {
        val subtotal = calcularSubtotal()
        return if (subtotal > 2000) subtotal * (porcentaje / 100) else 0.0
    }

    fun calcularTotal(): Double = calcularSubtotal() - calcularDescuento()

    fun mostrarResumen() {
        println("\n========================================")
        println("   CARRITO DE COMPRAS CON IA - TECSUP   ")
        println("========================================")
        println("Cliente: $cliente\n")

        println("--- DETALLE DEL CARRITO ---")
        productos.forEach { p ->
            println("- [${p.categoria}] ${p.nombre} x${p.cantidad}: S/ ${String.format("%.2f", p.calcularSubtotal())}")
        }

        val subtotal = calcularSubtotal()
        val descuento = calcularDescuento()
        val total = calcularTotal()

        println("\n----------------------------------------")
        println("Subtotal:       S/ ${String.format("%.2f", subtotal)}")
        println("Descuento(10%): S/ ${String.format("%.2f", descuento)}")
        println("TOTAL FINAL:    S/ ${String.format("%.2f", total)}")
        println("----------------------------------------")

        println(ia.recomendarProducto(subtotal))
        println("========================================\n")
    }
}

// 4. FUNCIÓN PRINCIPAL
fun main() {
    val miCarrito = Carrito("Kiara Alburqueque")

    miCarrito.agregarProducto(Producto("Laptop HP", 2500.0, 1, "Tecnología"))
    miCarrito.agregarProducto(Producto("Mouse Logitech", 45.5, 2, "Accesorios"))
    miCarrito.agregarProducto(Producto("Audifonos Sony", 120.0, 1, "Audio"))

    miCarrito.mostrarResumen()
}

