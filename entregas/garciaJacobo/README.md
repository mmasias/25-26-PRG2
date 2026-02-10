
# Boceto de implementación – pyEdlin en Java

## 1. Objetivo del proyecto
Implementar una versión básica del editor de líneas **EDLIN** que permita:
- Gestionar un fichero de texto de hasta **10 líneas**
- Mostrar el contenido del fichero en pantalla
- Definir una **línea activa**
- Editar el contenido de la línea activa
- Eliminar el contenido de una línea


---

## 2. Representación de la información

### 2.1 Almacenamiento del texto
El contenido del fichero se almacenará mediante un **array de String** con un tamaño máximo de 10 líneas:

- `String[] lineas = new String[10]`
- Cada posición del array representa una línea del fichero
- Las líneas vacías se inicializarán como cadenas vacías (`""`)

---

## 3. Menú principal del editor

### 3.1 Método estático para mostrar el menú
Se implementará un **método estático** encargado de mostrar el menú principal del editor EDLIN por pantalla.

Este método no modificará datos, únicamente mostrará información al usuario.

**Firma prevista del método:**
- `static void mostrarMenuPrincipal()`

---

### 3.2 Diseño del menú principal
El menú que se mostrará al usuario será el siguiente:

```
--------------------------------------------------
0: | Bienvenidos al editor EDLIN
1:*| Utilice el menu inferior para editar el texto
2: | ------
3: | [L] permite definir la linea activa
4: | [E] permite editar la linea activa
5: | [I] permite intercambiar dos lineas
6: | [B] borra el contenido de la linea activa
7: | [D] deshace la última acción realizada
8: | [S] sale del programa
9: | 
--------------------------------------------------
Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir
```
