Reto 003 — Refactoring Buscaminas y ExamenMina 
¿Qué es este reto?
Dado un código con errores funcionales y malas prácticas, el objetivo es obtener una versión correcta y limpia del mismo. Los códigos implementan una versión del juego Buscaminas en Java.

¿Por qué refactorizar y no reescribir desde cero?
Decidí hacer refactoring incremental en lugar de reescribir desde cero porque me parece la decisión más honesta y más útil como aprendizaje.
Reescribir desde cero es más fácil en cierto sentido: empiezas con una hoja en blanco y no tienes que entender lo que hizo otra persona. Pero eso es exactamente el problema, porque en el mundo real casi nunca vas a trabajar con código que escribiste tú desde el principio. La mayor parte del tiempo vas a llegar a un proyecto que ya existe, con decisiones que ya se tomaron, y tu trabajo va a ser mejorarlo sin romperlo.
Refactorizar me obligó primero a leer el código con atención, entender qué intentaba hacer, identificar qué estaba mal y por qué, y solo entonces tocar algo. Ese proceso de análisis es una habilidad en sí misma, y hacerlo en baby steps hace que cada cambio sea justificable y reversible.
Además, el historial de commits que genera el refactoring incremental documenta solo las decisiones tomadas y los problemas encontrados, que es exactamente lo que pide el reto.

Plan de refactoring
La idea general es ir de lo más superficial a lo más profundo: primero los nombres, luego los tipos de datos, luego los bugs de lógica, y por último la estructura del código. Así cada paso tiene sentido por sí solo sin depender de los siguientes.
Para los dos archivos el orden es el mismo: mejorar la nomenclatura, corregir los tipos de datos mal usados, arreglar los bugs que rompían el juego, añadir validaciones que faltaban y por último separar el código en métodos con una sola responsabilidad cada uno para que el main sea legible de un vistazo.