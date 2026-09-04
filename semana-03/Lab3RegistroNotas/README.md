# Programación en Móviles - Lab 03

**Alumno:** Kiara Paola Alburqueque Arzapalo  
**Curso:** Programación en Móviles  
**Laboratorio:** Lab 03 - Registro de Notas con Jetpack Compose  

---

## Descripción del Proyecto

Aplicación móvil desarrollada en **Android / Kotlin con Jetpack Compose** para el cálculo y registro de promedios ponderados de un ciclo académico.

La interfaz permite asignar notas de 4 asignaturas usando controles interactivos (`Slider`), formatear/redondear el resultado (`Switch`), pedir confirmación de datos (`Checkbox`) y mostrar el estado del estudiante mediante una tarjeta estilizada (`Card` / `Surface`).

---

## Capturas del Aplicativo

<img width="1739" height="899" alt="Captura de pantalla 2026-09-03 233434" src="https://github.com/user-attachments/assets/1d0eb428-4981-45f8-92e9-371802655071" />
<img width="1773" height="1012" alt="Captura de pantalla 2026-09-03 233645" src="https://github.com/user-attachments/assets/a941eb3e-c6d0-40ea-9e67-e340aee0a8c4" />

---

## Estructura de Cursos y Pesos

| Curso | Peso (%) |
| :--- | :---: |
| **Fundamentos de Programación** | 20% |
| **Programación Orientada a Objetos** | 25% |
| **Programación en Móviles** | 30% |
| **Base de Datos** | 25% |

---

## Criterios de Evaluación y Estados

| Rango de Promedio | Estado / Observación | Color Indicador |
| :--- | :--- | :--- |
| **17.0 a 20.0** | **EXCELENTE** | Verde Oscuro |
| **13.0 a 16.9** | **APROBADO** | Verde Claro |
| **10.0 a 12.9** | **EN RECUPERACIÓN** | Naranja |
| **0.0 a 9.9** | **DESAPROBADO** | Rojo |

---

## Pregunta de Reflexión: ¿Qué pasaría si declaras las variables SIN `remember`?

En **Jetpack Compose**, la interfaz de usuario se vuelve a dibujar (recomposición) cada vez que cambia el estado o interactúas con un componente (por ejemplo, al deslizar un `Slider` o presionar un `Switch`).

Si declaras las variables usando únicamente `mutableStateOf()` o `mutableFloatStateOf()` **sin envolverlas en `remember`**, la variable se volverá a instanciar con su valor inicial en cada recomposición. Como resultado, la pantalla **perderá los datos que el usuario vaya ingresando al instante**. El uso de `remember` le indica a Compose que preserve el valor guardado en memoria a través de las distintas recomposiciones de la interfaz.
