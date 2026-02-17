# Plan de Desarrollo: Buscaminas (Versión Estructurada)

Este documento describe la estrategia paso a paso para implementar el juego de Buscaminas en Java, siguiendo un enfoque de programación modular y evolutiva. Se hace asi en pasos pequenos justo por lo mencionado de baby steps. 

## Fase 1: Definición de Estructura y Constantes
* **Paso 1.1:** Definir constantes para el tamaño del tablero (5x7), la cantidad de minas (5) y el límite de explosiones (3).
* **Paso 1.2:** Declarar la matriz del "tablero lógico" (donde están las minas) y el "tablero visual" (lo que se imprime en pantalla).

## Fase 2: Inicialización y Preparación
* **Paso 2.1:** Crear un método para llenar el tablero visual con caracteres iniciales (`-`).
* **Paso 2.2:** Crear un método de generación aleatoria para colocar exactamente 5 minas en el tablero lógico, asegurando que no se repitan posiciones.

## Fase 3: El Ciclo de Juego (Game Loop)
* **Paso 3.1:** Implementar la estructura `while` principal basada en el estado de las explosiones y las casillas restantes.
* **Paso 3.2:** Diseñar el método de renderizado que imprime el tablero con el formato requerido (números de guía en filas y columnas).

## Fase 4: Interacción y Validación
* **Paso 4.1:** Crear métodos para solicitar X e Y.
* **Paso 4.2:** Validar que las coordenadas estén dentro del rango (1-5 para filas, 1-7 para columnas).

## Fase 5: Lógica de Impacto y Actualización
* **Paso 5.1:** Crear un método que verifique si en la coordenada elegida hay una mina.
* **Paso 5.2:** Actualizar el tablero visual: colocar un punto `.` si está libre o un asterisco `*` si hay mina.
* **Paso 5.3:** Gestionar los contadores de explosiones y de casillas liberadas.

## Fase 6: Finalización y Mensajes
* **Paso 6.1:** Crear un método que verifique si el jugador ganó (todas las casillas sin mina liberadas) o perdió (3 explosiones).
* **Paso 6.2:** Mostrar el mensaje final y el estado definitivo del tablero.