# pyEdlin
## Reto-002

- Clases 
Mostrar:
```
-------------------------------------------------
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

Funcionamiento
```
switch (comando) {
    case "L" -> listarFichero();
    case "E" -> editarLineaActiva();
    case "D" -> eliminarLinea();
    case "Q" -> salir();
    default  -> System.out.println("Comando no reconocido");
}
```