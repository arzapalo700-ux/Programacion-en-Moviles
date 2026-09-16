# Laboratorio 04: Carrito de Compras en Jetpack Compose

**Alumno/a:** Alburqueque Arzapalo Kiara Paola
**Curso:** Programación en Móviles

---

## Cuestionario / Preguntas del Laboratorio

### 1. ¿Qué función cumple remember y mutableStateListOf en Jetpack Compose?
- **remember**: Almacena y preserva una variable o estado durante las recomposiciones de la interfaz para que los datos no se reinicien o se pierdan al redibujar la pantalla.
- **mutableStateListOf**: Crea una lista dinámicamente observable. Al agregar, modificar o eliminar elementos de esta lista, Jetpack Compose detecta el cambio de forma automática y actualiza la pantalla en tiempo real.

### 2. ¿Cómo se calcula el total y subtotal dinámicamente en el carrito?
El cálculo se realiza mediante funciones de extensión sobre la lista observable de productos:
- **Subtotal:** Se calcula multiplicando el precio de un producto por su cantidad: `it.precio * it.cantidad`.
- **Total:** Se obtiene sumando el subtotal de cada elemento presente en la lista:
  `val total = productos.sumOf { it.precio * it.cantidad }`
Al estar vinculado a la lista observable, cada vez que se agrega un producto o cambia una cantidad, el valor del total se recalcula automáticamente en la interfaz.

### 3. ¿Por qué es adecuado utilizar LazyColumn para mostrar la lista de productos?
Se utiliza `LazyColumn` porque implementa un renderizado eficiente. A diferencia de un `Column` tradicional que dibuja todos los elementos al mismo tiempo en memoria, `LazyColumn` solo renderiza en pantalla los elementos que son actualmente visibles para el usuario. Esto garantiza un desplazamiento fluido y optimiza el uso de memoria en el dispositivo móvil.
