# Preámbulo

Debido a que ambas versiones presentan malas prácticas, código complejo y algoritmos ineficientes, he determinado que tardaría menos tiempo realizando mi propia implementación del reto en lugar de refactorizar el código original.

# Funciones principales

## generarTablero

Devuelve la matriz con el tablero.

## generarIndicesAleatorios

Genera una posición aleatoria para la mina.

## mostrarTableroYMenu

Muestra el tablero completo y el menú.

## verificar(int posicionX, int posicionY)

Recibe las posiciones, verifica que estén dentro del rango y luego comprueba si hay una mina.
En caso de haberla, devuelve `true`.

## verificarEstado

Verifica si el juego continúa o si ha terminado.
Comprueba si el jugador ganó o perdió.
Si el juego continúa, devuelve `true`.

---

# Variables importantes

* `listaMinas`: lista con las posiciones de las minas.
* `numMinasActivas`: número de minas que se activaron.
* `continuarJuego`: booleano, por defecto `true`.
* `minasAGenerar` (final): 5
* `minasParaPerder` (final): 3
* `numColumnasDelTablero` (final): 7
* `numFilasDelTablero` (final): 5
* `numeroDePosicionesRevisadas`: 0

---

# Lógica especial

El jugador gana cuando el número de posiciones revisadas es igual al número total de posiciones seguras.

Este valor se calcula previamente en función de las columnas y filas (posiciones totales del tablero menos las minas).

**Fórmula conceptual:**

```
posicionesTotales - minas
```

---

# Consideraciones extra

* Se debe usar gestión basada en estados.
* Se deben usar dos arreglos: uno para almacenar las posiciones en X y otro para las posiciones en Y.
* Se debe implementar una función auxiliar que verifique si un número está en la lista y que devuelva `true` o `false`.
