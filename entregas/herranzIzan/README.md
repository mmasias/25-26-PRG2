## Por que se cambia el codigo original
Este commit guarda el codigo tal cual fue entregado como **punto de partida** (baseline) para poder comparar cambios y justificar cada decision en commits posteriores.

## Problemas detectados

### Errores funcionales
- Lectura de coordenada **Y** incorrecta: se crea `sc2` pero se lee con `sc`.
- Comparacion de Strings con `==` en lugar de `.equals(...)` (puede fallar aunque el texto sea igual).
- Falta de validacion de rangos: entrada fuera de `1..5` / `1..7` puede provocar `ArrayIndexOutOfBoundsException`.
- Colocacion de minas con posible **solapamiento**: se pueden colocar menos minas reales de las esperadas.
- Se puede contar la misma casilla varias veces, alterando la condicion de victoria/derrota.

### Malas practicas / diseño
- Inicializacion manual repetitiva de `tablero` y `tablero2` (dificil de mantener).
- Duplicacion de logica de impresion del tablero.
- Uso de varios `Scanner` sobre `System.in` y recreacion dentro del bucle.
- Numeros magicos (6, 8, 5, 7, 30, 3...) repartidos por el codigo.
- Nombres de variables poco expresivos.

## Plan
A partir de aqui se aplicara **refactorizacion incremental (baby steps)**:
- 1 cambio logico por commit (fix o mejora).
- Mantener el programa ejecutable en cada paso.
- Cada commit justificara el por que del cambio."
