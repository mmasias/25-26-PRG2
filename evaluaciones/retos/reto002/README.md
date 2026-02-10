<img src="https://raw.githubusercontent.com/puntoReflex/.github/9623066ad97481117bf5bef12a500c86488e373d/images/edlin.png" width="40%" align="right"/>

# pyEdlin

EDLIN es un editor de líneas incluido en MS-DOS y más tarde en los sistemas operativos Microsoft. Proporciona capacidades rudimentarias para editar ficheros de texto plano a través de una interfaz de comandos. Los números de línea son especificados usando números, y las operaciones son especificadas usando un sólo carácter alfabético.

EDLIN era el único editor de textos proporcionado con el MS-DOS antes de la versión 5.0 de ese sistema, cuando fue reemplazado por el editor a pantalla completa edit. Fue eliminado en la versión 6, y está probablemente diseñado a partir de los editores de líneas QED o ed.

Edlin fue creado por Tim Paterson en dos semanas en 1980, y se esperaba que tuviese una vida de seis meses. Edlin realmente fue escrito originalmente para el QDOS de Seattle Computer Products, que más tarde fue comprado por Microsoft convirtiéndose finalmente en el MS-DOS.

## RETO

Implementar una primera versión de edlin, que pueda gestionar un fichero de 10 líneas

### RETOS BASE

1. Defina e implemente una manera de representar la información a almacenar, teniendo en cuenta que gestionará un fichero de texto de hasta 10 líneas.
1. Implemente la salida de información en pantalla, mostrando el fichero y las líneas que lo conforman.
1. Agregue a su versión de edlin la capacidad de especificar la línea activa.
1. Agregue a su versión de edlin la capacidad de editar el contenido de la línea activa.
1. Agregue a su versión de edlin la capacidad de eliminar el contenido de una línea.

### MEJORAS – PARTE 1

Agregue a su versión de edlin la capacidad de intercambiar el contenido de dos líneas.

### MEJORAS – PARTE 2

En base a lo definido arriba, plantee como implementaría la opción de deshacer (CTRL+Z). 

Impleméntelo.

## Sugerencias de presentación

```console
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
