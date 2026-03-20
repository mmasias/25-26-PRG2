Diseño y Arquitectura del Proyecto

## 1. Descripción general

Este proyecto consiste en implementar una versión simplificada del editor de líneas **EDLIN**, inspirado en el editor clásico incluido en MS-DOS.  
La aplicación funcionará en **modo consola** y permitirá editar un fichero de texto **limitado a 10 líneas**, utilizando comandos de una sola letra.

El objetivo principal es comprender cómo diseñar un editor básico, gestionando el estado del texto, las operaciones de edición y el control de cambios.

---

## 2. Qué se va a implementar

La primera versión de pyEdlin permitirá:

- Gestionar un fichero de texto de hasta **10 líneas**
- Mostrar el contenido completo del fichero en pantalla
- Editar el contenido de una línea
- Borrar el contenido de una línea
- Intercambiar el contenido entre dos líneas
- Deshacer la última acción realizada
- Interactuar mediante comandos simples introducidos por el usuario

No se implementará almacenamiento en disco ni edición a pantalla completa.

---

## 3. Arquitectura general

La arquitectura del programa será **simple y monolítica**, adecuada para un proyecto pequeño y didáctico.

### 3.1 Componentes principales

El sistema estará compuesto por los siguientes elementos lógicos:

#### a) Motor de datos
- Mantiene en memoria el fichero de texto
- El fichero se representa como una estructura de datos fija de 10 posiciones
- Cada posición almacena el contenido de una línea

#### b) Gestor de operaciones
- Contiene la lógica para:
  - Editar líneas
  - Borrar líneas
  - Intercambiar líneas
- Todas las modificaciones pasan por este componente

#### c) Gestor de historial
- Almacena el estado anterior del fichero
- Permite restaurar el estado previo para implementar la opción **Deshacer**
- Se manejará un único nivel de deshacer

#### d) Interfaz de consola
- Muestra el contenido del fichero en pantalla
- Presenta el menú de comandos disponibles
- Solicita y recibe la entrada del usuario

---

## 4. Flujo de ejecución

1. Inicializar la estructura que contiene las 10 líneas
2. Mostrar el contenido del editor en pantalla
3. Mostrar los comandos disponibles
4. Leer el comando ingresado por el usuario
5. Ejecutar la operación correspondiente
6. Actualizar el estado del fichero
7. Repetir el ciclo hasta que el usuario decida salir

---

## 5. Estrategia para la opción Deshacer

Para implementar la funcionalidad de deshacer:

- Antes de cada operación que modifique el contenido del fichero:
  - Se guarda una copia completa del estado actual
- Al ejecutar el comando de deshacer:
  - Se restaura el último estado guardado
- Solo se permitirá deshacer **la última acción**

---

## 6. Consideraciones de diseño

- El límite de 10 líneas simplifica la gestión de memoria
- El uso de comandos de una sola letra replica el estilo clásico de EDLIN
- El diseño prioriza claridad y facilidad de comprensión sobre eficiencia
- El código se escribirá de forma modular para facilitar futuras mejoras

---

## 7. Posibles extensiones futuras

- Guardar y cargar archivos desde disco
- Soportar más de un nivel de deshacer
- Insertar nuevas líneas
- Navegación más avanzada entre líneas
- Interfaz a pantalla completa

---
