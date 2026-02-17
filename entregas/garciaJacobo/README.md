# Reto 003 – Buscaminas

## 1. Objetivo

Desarrollar una versión simplificada del juego **Buscaminas** con las siguientes características:

- Tablero de **5 filas x 7 columnas**
- Colocar **5 minas** aleatoriamente
- El jugador introduce coordenadas (Y, X)
- Si hay mina → se muestra `*` y se suma una explosión
- Si no hay mina → se muestra `.`
- El juego termina cuando:
  - Se descubren todas las casillas sin mina → **GANA**
  - El jugador acumula **3 explosiones** → **PIERDE**

---

## 2. Enfoque de implementación

El juego se desarrollará utilizando una estructura procedural simple:

- Una única clase principal
- Métodos estáticos auxiliares
- Una matriz bidimensional como superficie de juego
- Un bucle principal `do-while` para controlar la partida

Se busca claridad, separación de responsabilidades y cumplimiento estricto del enunciado.

---

## 3. Representación del tablero

Se utilizará una matriz de enteros:

```java
int[][] superficie;

### Convención de valores internos

| Valor | Significado |
|-------|------------|
| -1    | Casilla oculta sin mina |
| -2    | Casilla oculta con mina |
| 1     | Casilla descubierta sin mina |
| 2     | Casilla descubierta con mina |



