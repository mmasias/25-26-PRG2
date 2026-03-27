# Reto 003

Esta rama incluye los cambios hechos para la refactorización del código de [Buscaminas.java](https://github.com/mmasias/25-26-PRG2/blob/main/evaluaciones/retos/reto003/buscaminas.java). Abajo se incluye el **Changelog** de cada cambio en la refactorización.

## ⌛ Changelog 

### 🔨 FIX: Cambio de nombre de clase

El primer cambio fue el nombre de la clase de `buscaminas` a `Buscaminas`. Siguiendo así la convención de nomenclatura.

### 🔨 FIX: Indentación

Se mejora la indentación y formato para una mejor lectura.

### 🛟 REFACTOR: Declaración de matrices de tableros

Se han refactorizado la declaración de los valores de las matrices, por una forma más legible. En vez de declarar cada elemento individualmente por su índice, se declaran dentro de la notación de **llaves** para arreglos y matrices.

### 🔨 FIX: Comentarios innecesarios

Elimina comentarios innecesarios dentro del código intentando justificar malas prácticas.

### 🛟 REFACTOR: Colocar Minas

Los bucles consecutivos que se utilizaban para colocar las minas en su posición inicial han sido removidos, y se han reemplazado por un método estático `colocarMinas`. Este realiza un ciclo según la cantidad de minas y les da una posición **X** e **Y** de manera aleatoria.

### 🛟 REFACTOR: Declaración e inicialización de tablero

Este refactor pretende cambiar la forma en la que el campo minado y el tablero de juego interactuán. Para ambos se han creado métodos estáticos para inicializarlos respectivamente. A su vez, el campo minado (anteriormente `tablero`) ha sido cambiado por una matriz de tipo **entero**. Por su parte, el tablero de juego (antes `tablero2`) se mantiene como una matriz de **String**. 

Otro cambio importante, es que se han quitado los números de posición de ambos tableros.

### 🔨 FIX: Eliminar variables innecesarias

Se eliminaron variables innecesarias.

### 🥖 FEAT: Método para imprimir tablero

Se agrega un método estático para imprimir el tablero