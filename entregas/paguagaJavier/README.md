# Reto 006

## Objectivo

### XXI o blackjack

1- El juego empieza sacando dos cartas de la baraja
2- Se cuentan los puntos. Si no se ha pasado de 21, sigue jugando.
3- El jugador puede: pedir otra carta o plantarse. Si pide otra carta, vuelve a 2

## Requerimientos

#### Conteo de puntos

- Las cartas de 2 a 10 valen lo que valen
- Las cartas superiores a 10 valen 10
- El as puede valer 1 u 11, siempre a favor el jugador

### Propuesta de interfaz

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

## Commits

1. Se ha creado las clases iniciales con las que se trabajara unos metodos iniciales (Console.java esta siendo reutilizaddo de trabajos anteriores), se tiene planeado primero tener en trabajo sin herencia para luego analizar bien que se conectada para un uso de herencia eficiente. Por ahora se ha terminado Menu y XII con los otros pendientes.

2. Se ha avanzado y refactorizado varias de las metodos que tenian las clases a punto y se ha probado que es funciona, el siguiente paso sera mirar si hay caso donde se pueda usar herencia para que este mejor escrito.

3. Se creado la clase de herencia Participante el cual ayuda a eliminar la redudaccion de poner manos en el dealer y el jugador ya que ambos son participantes, tambien añade falicidad en la escalabilidad si luego se desearia añadir algo mas al trabajo, con ello el trabajo se reconoce concluido por ahora.

4. Se cambio el nombre de un objecto para definir mejor