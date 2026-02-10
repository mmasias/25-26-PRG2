# Mapa Mental

Voy a usar este mapa para saber que debo hacer

## LO QUE ME PIDEN

### RETO

Implementar una primera versión de edlin, que pueda gestionar un fichero de 10 líneas

#### RETOS BASE

1. Defina e implemente una manera de representar la información a almacenar, teniendo en cuenta que gestionará un fichero de texto de hasta 10 líneas.
1. Implemente la salida de información en pantalla, mostrando el fichero y las líneas que lo conforman.
1. Agregue a su versión de edlin la capacidad de especificar la línea activa.
1. Agregue a su versión de edlin la capacidad de editar el contenido de la línea activa.
1. Agregue a su versión de edlin la capacidad de eliminar el contenido de una línea.

#### MEJORAS – PARTE 1

Agregue a su versión de edlin la capacidad de intercambiar el contenido de dos líneas.

#### MEJORAS – PARTE 2

En base a lo definido arriba, plantee como implementaría la opción de deshacer (CTRL+Z).

Impleméntelo.

### Sugerencias de presentación

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

## Que elementos debo usar

Para representar la información debo usar `arrays`
luego debo declarar las variables , más adelante inicializarlo en un static main , usar whiles y switches para la correcta funcionalidad del programa
