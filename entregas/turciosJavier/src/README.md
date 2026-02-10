# pyEdlin
## planteacion del proyecto

1. Defina e implemente una manera de representar la información a almacenar, teniendo en cuenta que gestionará un fichero de texto de hasta 10 líneas.

para esto creare un array de 10 espacios cada espacio contendra una linea 

2. Implemente la salida de información en pantalla, mostrando el fichero y las líneas que lo conforman.

 para esto hare un bucle do while que vaya mostrando todo el array 


3. Agregue a su versión de edlin la capacidad de especificar la línea activa.

aqui hare un puntero que apunte al numero de posicion de la linea activa que elija el usuario

4. Agregue a su versión de edlin la capacidad de editar el contenido de la línea activa.

en esta parte el usuario editara la posicion del array de la linea activa

5. Agregue a su versión de edlin la capacidad de eliminar el contenido de una línea.

en esta hago que el espacio en el array de la linea activa sea igual a null


MEJORAS – PARTE 1
Agregue a su versión de edlin la capacidad de intercambiar el contenido de dos líneas

aqui creo al elegir intercambiar el usuario elige las dos linea, se usa una variable temporal que contenga la primera linea y hago que la primera linea sea igual a la segunda luego la segunda linea sera igual a la temporal


MEJORAS – PARTE 2
En base a lo definido arriba, plantee como implementaría la opción de deshacer (CTRL+Z).

en esta parte creo un array que guarde un historial del codigo original y que al elegir la opcion d cargue ese historial
