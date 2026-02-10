
## PLANTEAMIENTO DE LA SOLUCIÓN EN JAVA

### Estructura de Datos
- **Array de Strings**: `String[] lineas = new String[10]` para almacenar las 10 líneas del editor
- **Variable de línea activa**: `int lineaActiva` para trackear qué línea está seleccionada
- **Constante**: `MAX_LINEAS = 10` para definir el tamaño fijo del editor

### Arquitectura
La implementación sigue un patrón simple de bucle principal con menú de comandos:
1. **Inicialización**: Cargar el contenido inicial de ejemplo
2. **Bucle principal**: Mostrar editor → Leer comando → Ejecutar acción → Repetir
3. **Métodos independientes**: Cada comando tiene su propio método privado estático

### Comandos Implementados
- `[L]` Línea activa: Permite seleccionar cualquier línea (0-9) con validación
- `[E]` Editar: Modifica el contenido de la línea activa
- `[B]` Borrar: Vacía el contenido de la línea activa
- `[I]` Intercambiar: Swappea el contenido de dos líneas especificadas
- `[S]` Salir: Termina el programa

### Validaciones
- Entrada numérica con manejo de `NumberFormatException`
- Rango válido de líneas (0-9)
- Mensajes de error claros para el usuario
