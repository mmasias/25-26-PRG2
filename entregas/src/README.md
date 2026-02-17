# Reto 003

## Refactoring, corrección de errores y/o reescritura

Dado el código a continuación, que puede contener errores funcionales además de malas prácticas, el objetivo es obtener una versión correcta y limpia del mismo.

### Códigos

- [Examen de minas](ExamenMina.java)
- [Buscaminas](buscaminas.java)

### Opciones de trabajo

Puede abordar este reto de dos formas:

1. **Refactorización incremental**: Modificar el código existente mediante *baby steps*, aplicando una corrección por commit.
1. **Reescritura desde cero**: Partir de la funcionalidad deseada y escribir un nuevo código limpio, documentando cada decisión de diseño.

### Entregables

El trabajo debe construirse **a partir de** la rama `entregas` de este repo, y **enviarse a** la rama reto-003 en este mismo repo.

- [ ] **Código refactorizado/corregido** o **nueva versión**
- [ ] **Historial de commits** visible. Cada commit debe representar un cambio lógico:
  - Si refactoriza: una mejora por commit
  - Si reescribe: cada feature/decisión de diseño por commit
- Este historial de commit, bien hecho, se convierte en:
  - [ ] Documento con las **malas prácticas identificadas** y **errores detectados** en el código original
  - [ ] Breve **memoria** justificando los cambios realizados o las decisiones de diseño

### Nota

A diferencia del reto 001, estos códigos pueden contener errores funcionales que deben ser corregidos además de las malas prácticas de estilo y diseño.

## Enunciado original

Desarrolle la siguiente versión del juego de buscaminas:

Cree un tablero de 5 filas x 7 columnas y asigne cinco minas (de modo aleatorio) sobre su superficie.

El jugador indica las posiciones X e Y y el programa determina si hay una mina en esa casilla. 

- Si no hay mina, el tablero muestra un punto. 
- En caso de haber una mina,  se muestra un asterisco y se suma una explosión.

El juego finaliza al liberar todas las casillas (en  cuyo caso gana) o bien cuando al jugador le explotan tres minas (donde lógicamente pierde).

```
================
  1 2 3 4 5 6 7
1 - - - - - - - 
2 - - - - - - -
3 - - - - - - -
4 - - - - - - -
5 - - - - - - -
================
Ingrese X
2
Ingrese Y
2
----------------
Libre!
================
  1 2 3 4 5 6 7
1 - - - - - - - 
2 - . - - - - -
3 - - - - - - -
4 - - - - - - -
5 - - - - - - -
================
Ingrese X
1
Ingrese Y
5
----------------
Mina!
================
  1 2 3 4 5 6 7
1 - - - - * - - 
2 - . - - - - -
3 - - - - - - -
4 - - - - - - -
5 - - - - - - -
================
Ingrese X
```