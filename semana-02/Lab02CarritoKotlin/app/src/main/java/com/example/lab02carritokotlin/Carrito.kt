package com.example.lab02carritokotlin

data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)
fun main() {
    println("=========================================")
    println("   CARRITO DE COMPRAS - TIENDA TECSUP    ")
    println("=========================================")

    val nombreCliente = "Kiara Alburqueque"
    val carrito = mutableListOf<Producto>()

    println("Cliente: $nombreCliente\n")

    val p1 = Producto("Laptop HP", 2500.0, 1)
    val p2 = Producto("Mouse Logitech", 45.5, 2)
    val p3 = Producto("Audifonos Sony", 120.0, 1)
    val p4 = Producto("USB Kingston 64GB", 25.0, 3)

    carrito.add(p1)
    carrito.add(p2)
    carrito.add(p3)
    carrito.add(p4)

    for (producto in carrito) {
        println("Producto agregado: ${producto.nombre}")
    }

    println("Se agregaron ${carrito.size} productos al carrito con exito.\n")

    println("--- DETALLE DEL CARRITO ---")
    var totalGeneral = 0.0

    for (item in carrito) {
        val subtotal = item.precio * item.cantidad
        totalGeneral += subtotal
        println("- ${item.nombre} x${item.cantidad}: S/ ${String.format("%.2f", subtotal)}")
    }

    println("\nTOTAL A PAGAR: S/ ${String.format("%.2f", totalGeneral)}")

}