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

    println("Se agregaron ${carrito.size} productos al carrito con exito.\n")

}