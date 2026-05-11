# Reto 006

## XXI o blackjack

1- El juego empieza sacando dos cartas de la baraja
2- Se cuentan los puntos. Si no se ha pasado de 21, sigue jugando.
3- El jugador puede: pedir otra carta o plantarse. Si pide otra carta, vuelve a 2

### Conteo de puntos

- Las cartas de 2 a 10 valen lo que valen
- Las cartas superiores a 10 valen 10
- El as puede valer 1 u 11, siempre a favor el jugador

## Propuesta de interfaz

```console
--------------------
Mano: [9 ♥][4 ♣] - Puntaje: 13 ==> Sigue jugando
--------------------
1. Pedir
2. Empezar de nuevo
3. Salir
--------------------
1
--------------------
Mano: [9 ♥][4 ♣][A ♦] - Puntaje: 14 ==> Sigue jugando
--------------------
1. Pedir
2. Empezar de nuevo
3. Salir
--------------------
1
--------------------
Mano: [9 ♥][4 ♣][A ♦][9 ♦] - Puntaje: 23 ==> Perdió
--------------------
1. Pedir
2. Empezar de nuevo
3. Salir
--------------------
2
--------------------
Mano: [8 ♦][8 ♥] - Puntaje: 16 ==> Sigue jugando
--------------------
1. Pedir
2. Empezar de nuevo
3. Salir
--------------------
1
--------------------
Mano: [8 ♦][8 ♥][Q ♥] - Puntaje: 26 ==> Perdió
--------------------
1. Pedir
2. Empezar de nuevo
3. Salir
--------------------
2
--------------------
Mano: [J ♣][A ♣] - Puntaje: 21 ==> Ganó
--------------------
1. Pedir
2. Empezar de nuevo
3. Salir
--------------------
```