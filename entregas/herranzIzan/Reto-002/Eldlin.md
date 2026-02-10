# 🧠 Proyecto EDLIN en Java

`pyEdlin` es una versión simplificada en Java del editor de líneas **EDLIN** de MS-DOS.  
Permite gestionar un fichero de hasta **10 líneas**, con línea activa, edición, borrado, intercambio de líneas y deshacer acciones.

Este documento incluye **mapa mental**, **retos base**, **mejoras**, **flujo del programa**, **menú visual** y **commits paso a paso**.

---

## 1️⃣ RETO PRINCIPAL
Implementar una primera versión de EDLIN capaz de gestionar un fichero de **10 líneas de texto**.

---

## 2️⃣ RETOS BASE

### 2.1 Representación de la información
- Usar un **array de Strings** para almacenar hasta 10 líneas.
- Inicializar el array en `main`.

```java
private static final int MAX_LINES = 10;
private static String[] file = new String[MAX_LINES];

for(int i = 0; i < MAX_LINES; i++) {
    file[i] = "";
}

```
### 2.2 Mostrar fichero en pantalla

Función para imprimir todas las líneas, indicando la línea activa.
```java
private static int activeLine = 1; // Línea activa por defecto

private static void printFile() {
    System.out.println("--------------------------------------------------");
    System.out.println("0: | Bienvenidos al editor EDLIN");
    System.out.println("1:*| Utilice el menu inferior para editar el texto");
    System.out.println("2: | ------");
    System.out.println("3: | [L] permite definir la linea activa");
    System.out.println("4: | [E] permite editar la linea activa");
    System.out.println("5: | [I] permite intercambiar dos lineas");
    System.out.println("6: | [B] borra el contenido de la linea activa");
    System.out.println("7: | [D] deshace la última acción realizada");
    System.out.println("8: | [S] sale del programa");
    System.out.println("9: | ");
    System.out.println("--------------------------------------------------");
    System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
}
```
### 2.3 Línea activa

Variable activeLine para almacenar la línea seleccionada.

Comando para cambiar la línea activa dentro del menú: [L].

### 2.4 Editar línea activa

Permitir al usuario modificar el contenido de la línea seleccionada con [E].

### 2.5 Borrar contenido de una línea

Borrar el contenido de la línea activa con [B].

## 3️⃣ MEJORAS
3.1 Intercambiar contenido de dos líneas

Seleccionar dos líneas y cambiar sus contenidos con [I].

### 3.2 Deshacer (CTRL+Z)

Implementación sugerida con pila (Stack<String[]>) y comando [D].

## 4️⃣ Flujo del programa

Inicializar array de 10 líneas y variables.

Mostrar menú visual y bienvenida.

Usar un bucle while(true) para leer comandos del usuario.

Usar switch para ejecutar cada comando:
[L] -> Definir línea activa
[E] -> Editar línea activa
[I] -> Intercambiar dos líneas
[B] -> Borrar línea activa
[D] -> Deshacer última acción
[S] -> Salir del programa
