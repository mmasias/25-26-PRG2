# Carpeta de entregas

Para cada entrega, cree en esta carpeta su carpeta personal usando el estándar `apellidoNombre`.

## Estructura

```
/entregas/apellidoNombre/README.md   <-- Presentación de la entrega
                        /src         <-- Código fuente
                        /modelosUML  <-- Modelos en plantUML
                        /docs        <-- Documentación adicional
                        /images      <-- Imágenes, diagramas...
```

## Artefactos habituales

||||
|-|-|-|
|1|**README.md**|Presentación de la entrega, con explicación de la solución y referencias al resto de artefactos. ¡Navegabilidad!|
|2|**Código fuente**|Proyecto ordenado dentro de `/src`.|
|3|**Diagramas**|Fuente en `/modelosUML`, exportado en `/images`, referenciado en los .md pertinentes.|
|4|**Documentación adicional**|En `/docs`, en formato markdown (u otro formato, solo si se solicita explícitamente).|

> Cada reto indicará qué artefactos son obligatorios y cuáles opcionales.

## Criterios de valoración

- **Proceso de creación** — commits bien descritos, un cambio por commit.
- **Código limpio** — innegociable.
- **Adecuado reparto de responsabilidades** entre módulos.
- **Aplicación de lo visto en la vida, en el grado, en la asignatura y en las clases**, en ese orden.

## Tenga en cuenta

- **Planificar** antes de codificar (diagramas, esquemas, pseudocódigo).
- **Construir código que se autoexplique**.
- **Usar los commits** para documentar el proceso.


---
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