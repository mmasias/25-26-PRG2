# Memoria de Diseño: Reto 003 - Buscaminas

## 1. Por qué empiezo de cero
He decidido no refactorizar los códigos originales porque presentan muchos errores de lógica y una estructura desordenada. Me resulta **más fácil y rápido** aplicar la lógica que ya desarrollé en mi proyecto **"Rescate"**, ya que es un código que entiendo perfectamente y que funciona de manera robusta.

## 2. Similitud con el proyecto "Rescate"
Mi código de Rescate ya resuelve el problema central del Buscaminas:
* **Matrices (Array de Arrays):** Uso una matriz bidimensional para representar el terreno.
* **Sistema de Estados:** Utilizo valores positivos y negativos para manejar la "niebla" (casillas ocultas y descubiertas).
* **Modularidad:** Mi código ya está separado en métodos como `imprimir()`, `mapear()` y `colocarObjetos()`, lo que lo hace mucho más limpio que los ejemplos dados.

## 3. Cambios principales a realizar
Para adaptar "Rescate" al enunciado del Reto 003, solo necesito ajustar:
1. **Dimensiones:** Cambiar el tablero a 5 filas x 7 columnas.
2. **Símbolos:** Ajustar el método `mapear` para mostrar `-`, `.` y `*`.
3. **Condición de Fin:** En lugar de buscar un soldado, el juego termina al encontrar 3 minas (pierde) o despejar todas las casillas libres (gana).