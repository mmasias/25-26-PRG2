# Mindmap

## Idea principal
Crear un editor sencillo que simule un archivo de texto con líneas editables.

↓

1. Pensar cómo guardar la información

→ Necesitamos almacenar texto
→ El archivo tiene máximo 10 líneas
→ Usamos un arreglo de Strings

## Resultado:
Tenemos una estructura fija donde cada posición representa una línea.

↓

2. Control del estado del editor

→ El editor debe saber dónde estamos trabajando
→ Creamos una variable que indique la línea activa

## Resultado:
Podemos dirigir las operaciones a una línea concreta.

↓

3. Mostrar el contenido

→ El usuario necesita ver el estado del archivo
→ Recorremos el arreglo
→ Mostramos número + contenido

## Resultado:
Visualización clara del texto almacenado.

↓

4. Operaciones básicas sobre datos
Editar

→ Reemplazar contenido de la línea activa

Borrar

→ Vaciar una línea sin eliminarla

## Resultado:
Manipulación directa del arreglo.

↓

5. Operaciones de organización

→ Intercambiar líneas
→ Reordenar información

## Resultado:
Mayor control sobre el texto.

↓

6. Interacción con el usuario

→ Crear un menú simple
→ Leer opciones
→ Ejecutar acciones

## Resultado:
El programa se vuelve interactivo.

↓

7. Estructura general del programa

Inicializar datos
→ Bucle principal
→ Mostrar estado
→ Leer acción
→ Ejecutar cambios

## Resultado:
Flujo continuo de edición.

↓

Concepto de mejora futura

→ Guardar estados previos
→ Implementar deshacer
→ Usar pila de memoria

## Resultado:
Editor más robusto.

## Resumen mental del proceso

Idea → estructura de datos → control → operaciones → interacción → mejora

Este orden guía toda la construcción del programa.