# Entrega Reto 005

Esta rama y directorio incluye la entrega del **reto 005** para la materia de **Programación 2**.

## Sobre el reto

El reto, de forma similar al [Reto 004](https://github.com/fogg928s4/25-26-PRG1/tree/reto-004/entregas) de la materia de **Programación 1**.

## Consideraciones sobre el reto

### Punto de partida

```java
class Juego {
    public static void main(String[] args) {
        new Carrera.jugar();
    }
}
```

### Reglas

- La carrera se disputa en una pista de 40 posiciones.
- Al inicio empieza el caballo (por azar).
- El caballo en juego avanza 0, 1 o 2 casillas.
- Cada turno muestra el estado de la pista.
- El juego termina cuando uno de los caballos llega al final de la pista.
- Al final de la carrera puede haber empate.

