# pyEdlin
## Reto-002

## Variables principales

- `String[] lineas` - array de 10 posiciones para guardar el texto del fichero
- `int lineaActiva` - guarda qué línea tiene el asterisco (*)
- `boolean usuarioActivo` - controla si el bucle sigue o termina (true = sigue, false = sale)
- `String comando` - guarda la letra que escribe el usuario (L, E, I, B, S)
- `Scanner scanner` - para leer lo que escribe el usuario

## Métodos / Clases

### main()
Variables:
- scanner, lineas, lineaActiva, usuarioActivo, comando
Qué hace:
- Inicializa el array con el texto de bienvenida
- Bucle do-while que muestra fichero, lee comando y ejecuta acción
- Cierra scanner al terminar

### mostrarFichero()
Variables:
- i (contador del for)
- asterisco (String con * o espacio)
- contenido (String con el texto de la línea)
Qué hace:
- Recorre las 10 líneas y las imprime con formato
- Pone * en la línea activa
- Muestra menú de comandos

### cambiarLineaActiva() 
Variables:
- numero (int que lee del usuario)
Qué hace???
- Pide número de línea al usuario
- Lee 
- Retorna el número para la nueva lineaActiva

### editarLineaActiva()

Qué hace??
- Pide nuevo texto
- Lo guarda en lineas[lineaActiva]

### borrarLinea()
borra

### intercambiarLineas()
Variables:
- lineaInicial (primera línea a intercambiar)
- lineaAIntercambiar (segunda línea)
- temporal (String para guardar contenido temporalmente)
Qué hace??
- Pide dos números de línea
-  variable temporal para intercambiar contenidos
- Algoritmo: guardar la info de la primera para intercambiar segu

## Lo que hay que mostrar:
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

## El Switch
```java
switch (comando) {
    case "L" -> lineaActiva = cambiarLineaActiva(scanner);
    case "E" -> editarLineaActiva(scanner, lineas, lineaActiva);
    case "I" -> intercambiarLineas(scanner, lineas);
    case "B" -> borrarLinea(lineas, lineaActiva);
    case "S" -> usuarioActivo = false;
    default  -> System.out.println("Comando no reconocido");
}
```

## Notas técnicas
- scanner.nextLine() después de nextInt() para limpiar la terminal
- Operador ternario ? para decidir * o espacio y null o "", acordate que es igual que el if solo te cuesta mas verlo
- Switch usa flechas -> en vez de : y break
