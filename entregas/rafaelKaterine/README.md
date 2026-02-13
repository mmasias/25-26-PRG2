***Katerine Lisbeth Rafael Bourdierd***

# Planteaminto del codigo:

**Variables** 

- Array de String: Longitud de 9 porque son 10 lineas y empieza desde 0
- Lineas (Cada punto en el array)
- PunteroLinea: Posicion en el array (Se pocisiona al principio en el 1)
- Historial: Copia del arrays

**Inicializacion de lineas (Tomando en cuenta el reto):**
-linea[0] = "Bienvenidos al editor de texto JEdlin";
-linea[1] = "Utilice el menu inferior para editar el texto";
-linea[2] = " ------------------------------------";
-linea[3] = "[L] permite definir la linea activa";
-linea[4] = "[E] permite editar la linea activa";
-linea[5] = "[I] permite intercambiar dos lineas";
-linea[6] = "[B] borra el contenido de la linea activa";
-linea[7] = "[D] deshace la última acción realizada";
-linea[8] = "[S] sale del programa";
-linea[9] = " ------------------------------------";

**Creacion de metodos:**

- imprimirArray();
- 
- asignarLineaActiva();
- editarLinea();
- intercambiarLinea();
- borrarContenido();
- deshacerAccion();
- salirDelPrograma();

**Creacion de switch**
- Caso L -> asignarLineaActiva();
- Caso E -> editarLinea();
- Caso I -> intercambiarLinea();
- Caso B -> borrarContenido();
- Caso D -> deshacerAccion();
- Caso S -> salirDelPrograma();

***Notas:***
- Hacer que el sistema lea la letra independientemente si en mayuscula o no
- Establecer Signo para cuando estoy en la linea activa (Que se vea visiblemente)


## Camino feliz

1. El usuario inicia el programa.
2. Se muestra el array: 
- linea[0] = "Bienvenidos al editor de texto JEdlin";
- linea[1] = "Utilice el menu inferior para editar el texto";
- linea[2] = " ------------------------------------";
- linea[3] = "[L] permite definir la linea activa";
- linea[4] = "[E] permite editar la linea activa";
- linea[5] = "[I] permite intercambiar dos lineas";
- linea[6] = "[B] borra el contenido de la linea activa";
- linea[7] = "[D] deshace la última acción realizada";
- linea[8] = "[S] sale del programa";
- linea[9] = " ------------------------------------";
3. El usuario se encuentra es la linea activa que es la 1:
- linea[1] = "Utilice el menu inferior para editar el texto";
4. El usuario escribe una letra dependiendo la opcion, al escribirla se debe ejecutar el metodo: 
- L -> asignarLineaActiva();
- E -> editarLinea();
- I -> intercambiarLinea();
- B -> borrarContenido();
- D -> deshacerAccion();
5. El usuario termina y escribe S
- S -> salirDelPrograma();


