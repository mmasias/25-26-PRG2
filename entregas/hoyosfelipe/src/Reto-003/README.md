# Reto 003 - Buscaminas Refactorizado

## Por que empezar desde cero?

Despues de revisar los dos codigos que nos dieron (ExamenMina.java y buscaminas.java) honestamente estan bastante enredados. No es que esten mal mal pero tienen tantos problemas que arreglarlos todos seria mas horrible que empezar de nuevo.

### Problemas que encontre en ExamenMina.java:
- Esta comparando Strings con == en vez de .equals() (linea 46 62 64)
- Las coordenadas estan super confusas... a veces usa posX para Y y posY para X
- La generacion de minas no funciona bien porque el Math.random() genera numeros muy pequeños
- Usa dos arrays cuando realmente solo necesita uno
- Los indices del array incluyen los headers lo que hace todo mas complicado

### Problemas en buscaminas.java:
- Tiene como 5 bloques de codigo IDENTICOS para colocar las minas
- Inicializa TODO el tablero celda por celda (casi 50 lineas de puro copy-paste)
- Tambien usa dos arrays sin necesidad
- Variables con nombres raros (posa posb posc posd... para que?)

## Que voy a reutilizar?

Basicamente solo las ideas generales:
- El tamaño del tablero (5x7)
- Que haya 5 minas
- La logica de ganar/perder (3 explosiones = pierdes y liberar todo = ganas)
- Mostrar puntos (.) para casillas libres y asteriscos (*) para minas

## Plan de la nueva version

Voy a hacer un codigo limpio desde cero con esta estructura:

```
Buscaminas.java
    ├── main() --> solo coordina el juego
    ├── inicializarTablero() --> crea el tablero vacio
    ├── colocarMinasAleatorias() --> pone las 5 minas random
    ├── mostrarTablero() --> imprime lo que ve el jugador
    ├── pedirCoordenadas() --> pide X e Y y valida que sean correctas
    ├── procesarJugada() --> revisa si hay mina o no
    └── verificarFinDeJuego() --> checa si gano o perdio
```

### Decisiones importantes:
1. **un solo array**: Voy a usar un char[][] con valores:
   - '.' = vacio
   - '*' = mina
   - 'v' = vacio revelado
   - 'x' = mina explotada
   - '?' = sin revelar (para mostrar)
