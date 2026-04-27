# Diseño del ejercicio de carrera de caballos

## Objetivo
Crear una simulación simple de una carrera entre dos caballos, donde cada caballo avanza en turnos hasta que uno alcanza la meta.

## Componentes

- `Carrera`: controla la lógica de la carrera.
  - Inicializa dos instancias de `Caballo`.
  - Muestra el estado de la pista en cada turno.
  - Alterna el avance entre los caballos.
  - Determina el ganador cuando alguno alcanza la meta.

- `Caballo`: representa a un caballo participante.
  - Mantiene su posición actual.
  - Realiza un avance aleatorio en cada turno.
  - Expone su posición y su número.

- `Juego`: clase con el método `main` que arranca la carrera.

## Flujo de ejecución

1. `Juego.main()` crea una instancia de `Carrera`.
2. Se llama a `carrera.jugar()`.
3. En cada iteración:
   - Se decide qué caballo avanza.
   - Se actualiza la posición del caballo en turno.
   - Se imprime la pista con la posición de ambos caballos.
   - Se espera brevemente antes del siguiente turno.
4. Cuando uno de los caballos alcanza la meta, se muestra el resultado.

## Detalles de diseño

- `META` se define como una constante en `Carrera`.
- La visualización de la pista se hace con espacios y un símbolo de caballo ficticio `;-;'`.
- Se usa `Math.random()` para alternar el turno inicial y para calcular el avance de cada caballo.

## Correcciones realizadas

- Se cerró correctamente el método `dibujarCarril()` en `Carrera.java`.
- Se cerró correctamente el método `jugar()` y la clase `Carrera`.
- Se corrigió el nombre del constructor en `Caballo.java` de `Caaballo` a `Caballo`.
- Se mejoró la indentación y la estructura de los bloques `try/catch` y `while`.
