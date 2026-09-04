# Programación en Móviles - Lab 03 (Registro de Producto)

**Alumno:** Kiara Paola Alburqueque Arzapalo  
**Curso:** Programación en Móviles  
**Laboratorio:** Lab 03 - Registro de Producto con Jetpack Compose  

---

## Descripción del Proyecto

Aplicación móvil desarrollada en **Android / Kotlin con Jetpack Compose** para el registro, cálculo de costos e inventario de productos.

La interfaz permite al usuario ingresar el nombre del producto, su precio unitario y la cantidad deseada mediante campos de texto (`OutlinedTextField`), calcular el monto total a pagar de forma dinámica y visualizar un resumen detallado de la transacción.

---

## Capturas del Aplicativo

<!-- Pega o arrastra tus fotos justo debajo de esta línea -->
<img width="884" height="488" alt="image" src="https://github.com/user-attachments/assets/8e50c363-f210-4b55-99c2-d3b9a2ad3119" />
<img width="855" height="1458" alt="image" src="https://github.com/user-attachments/assets/ef8ada5c-fe7f-4232-876b-77bf70a957b7" />
<img width="840" height="1229" alt="image" src="https://github.com/user-attachments/assets/ecf723a1-14e1-424b-b31b-8e385e024c68" />
<img width="884" height="542" alt="image" src="https://github.com/user-attachments/assets/e38a7d3b-02f1-47ce-ab44-ae6456443515" />

---

## Componentes Utilizados

| Componente | Función en la Aplicación |
| :--- | :--- |
| **OutlinedTextField** | Captura de texto para nombre, precio y cantidad del producto. |
| **Button** | Ejecuta la lógica de cálculo y validación de campos. |
| **Card / Surface** | Muestra la tarjeta del resumen con el total calculado. |
| **Text** | Etiquetas explicativas e indicadores visuales de respuesta. |

---

## Pregunta de Reflexión: ¿Qué pasaría si declaras las variables SIN `remember`?

En **Jetpack Compose**, la interfaz de usuario realiza una recomposición cada vez que cambia el estado o interactúas con los campos de texto.

Si declaras las variables de estado (`nombre`, `precio`, `cantidad`) usando únicamente `mutableStateOf("")` **sin envolverlas en `remember`**, la variable se reiniciará a su valor inicial vacío en cada recomposición. Como resultado, cada vez que el usuario escriba un carácter en un `OutlinedTextField`, el texto ingresado **desaparecerá al instante**. El uso de `remember` permite almacenar el valor en memoria y conservarlo a través de las recomposiciones.
