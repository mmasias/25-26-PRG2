# Plan de Diseño: pyEdlin  

## 1. Representación de Datos y Estado 

Para que el editor, definiremos las siguientes variables para gestionar la memoria del programa:

| Componente | Tipo de Dato en Java | Propósito |
| :--- | :--- | :--- |
| **Contenido del fichero** | `String[]` | Arreglo de tamaño 10 para almacenar las líneas de texto. |
| **Línea activa** | `int` | Almacena el índice (0-9) de la línea seleccionada. |
| **Historial (Deshacer)** | `String[]` | Copia del arreglo original para restaurar datos tras un cambio. |

### Detalles:
* **Capacidad:** Fija en 10 posiciones.
* **Estado inicial:** El arreglo se inicializará con cadenas vacías o un marcador como `"[Vacío]"` para facilitar la visualización inicial.
* **Sincronización:** Antes de cualquier edición o borrado, el contenido actual se volcará al arreglo de historial.


## 2. Flujo del Programa (Ciclo Principal) 

Para que el editor se mantenga activo, utilizaremos un ciclo que se repita hasta que el usuario decida finalizar la sesión.

### Pasos de la interacción:
1. **Mostrar estado:** Refrescar la pantalla mostrando las 10 líneas de texto. La **línea activa** se identificará visualmente (con un asterisco `*`).
2. **Desplegar Menú:** Mostrar las opciones de comando disponibles: `[L]`inea, `[E]`ditar, `[I]`ntercambiar, `[B]`orrar, `[D]`eshacer y `[S]`alir.
3. **Leer Comando:** Capturar la entrada del usuario (una letra).
4. **Ejecutar Acción:** Procesar el comando seleccionado mediante una estructura de decisión.
5. **Actualizar Historial:** Antes de modificar el texto en `E`, `B` o `I`, guardar el estado previo para que la opción `D` funcione.
6. **Condición de Salida**: El ciclo se repite siempre, a menos que el usuario elija 'S'.


## 3. Lógica de los Comandos (Control de Decisiones) 

Para procesar las instrucciones del usuario, utilizaremos una estructura **switch-case**. Esto permite ejecutar un bloque de código específico según la letra ingresada:

* **Case 'L'**: Solicitar al usuario el número de línea (0-9) y actualizar la variable de **línea activa**.
* **Case 'E'**: Pedir una nueva cadena de texto y guardarla en la posición actual del arreglo.
* **Case 'I'**: Solicitar dos números de línea e intercambiar sus contenidos.
* **Case 'B'**: Limpiar el contenido de la línea activa (dejarla vacía `""`).
* **Case 'D'**: Ejecutar la lógica de **Deshacer**, recuperando la información del arreglo de historial.
* **Case 'S'**: Cambiar el estado de una variable booleana para terminar el ciclo y salir del programa.


Implementaremos las funciones del editor siguiendo estas reglas lógicas:

* **Intercambiar (I):** Para mover el texto entre dos posiciones sin perder datos, usaremos una variable `String temporal`:
    1. Guardar `lineas[A]` en `temporal`.
    2. Asignar el valor de `lineas[B]` a `lineas[A]`.
    3. Pasar el valor de `temporal` a `lineas[B]`.

* **Deshacer (D):** Esta función restaurará el estado anterior del fichero. 
    * **Mecánica**: Antes de cualquier cambio (Editar, Borrar o Intercambiar), realizaremos una copia de seguridad del arreglo completo en nuestro arreglo de `Historial`.
    * Al ejecutar `D`, el arreglo principal volverá a ser igual al del `Historial`.