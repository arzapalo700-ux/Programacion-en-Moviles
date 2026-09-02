# Programacion-en-Moviles

**Alumno:** Kiara Paola Alburqueque Arzapalo  
**Curso:** Programación en Móviles  
**Laboratorio:** Lab 03 - Registro de Producto con Jetpack Compose

---

## Pregunta del Laboratorio 03: ¿Qué pasaría si declaras las variables de los campos SIN `remember`?

Si declaramos las variables de estado (`nombre`, `precio`, `cantidad`) usando únicamente `mutableStateOf("")` sin envolverlas en `remember`, el valor guardado se reiniciará a su estado inicial vacío (`""`) en cada recomposición.

En Jetpack Compose, cada vez que el usuario escribe un carácter en un `OutlinedTextField`, se activa una recomposición de la pantalla. Sin `remember`, la función composable vuelve a ejecutarse desde el principio y crea una nueva variable vacía, haciendo que el texto escrito desaparezca al instante. `remember` permite almacenar el valor en memoria y conservarlo a través de las recomposiciones.
