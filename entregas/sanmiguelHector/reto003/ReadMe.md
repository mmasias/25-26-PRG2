# Desarrollo del juego "Buscaminas"

## Pautas a seguir

1.  **Matriz del tablero real**
    -   Dimensión: 5x7
    -   Contiene minas o casillas vacías.
2.  **Matriz del tablero visible**
    -   Dimensión: 5x7
    -   Muestra lo que el jugador ha descubierto:
        -   '.' si está libre
        -   '\*' si hay mina
        -   Valor inicial oculto (por ejemplo '-')
3.  **Contadores**
    -   Número de explosiones (inicia en 0).
    -   Número de casillas liberadas.
    -   Total de casillas seguras (5x7 - 5 minas = 30)

## Inicialización del juego

1.  Crear matriz de 5x7.
2.  Colocar 5 minas aleatoriamente asegurando que no se repitan
    posiciones.
3.  Inicializar tablero visible con casillas ocultas.
4.  Inicializar contador de explosiones en 0.

## Bucle principal del juego

Mientras que no haya 3 minas descubiertas o mientras no se hayan encontrado todas las casillas seguras:

    - Se pedirán coordenadas x e y al usuario.
    - Se validarán los datos entregados por el usuario.
    - Se comprobará si es una casilla segura o si es una mina.
    1. En caso de ser una mina: se mostrará un * y se sumará al contador de minas encontradas.
    2. En caso de ser una casilla segura: se mostrará un . y se sumará al contador de casillas seguras.

## ¿Por qué he decidido desarrollarlo por mi cuenta?

Se me ha hecho difícil entender los códigos presentados porque considero que están mal propuestos y enrevesados. Crear un código yo mismo desde cero hace  que sepa qué y cómo funciona cada parte del programa.