# Propuesta: Implementación de Deshacer (CTRL+Z)

## Problema
Permitir al usuario deshacer las operaciones realizadas en el editor (editar, borrar, intercambiar líneas).

## Solución Propuesta

### Estructura de Datos

Utilizar una **pila (Stack)** para almacenar los estados previos del editor:

```java
import java.util.Stack;

private static Stack<EstadoEditor> historial = new Stack<>();
private static final int MAX_HISTORIAL = 20; 
```

Crear una clase interna para guardar cada estado:

```java
static class EstadoEditor {
    String[] lineas;
    int lineaActiva;
    
    EstadoEditor(String[] lineas, int lineaActiva) {
        this.lineas = new String[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            this.lineas[i] = lineas[i];
        }
        this.lineaActiva = lineaActiva;
    }
}
```

### Funcionamiento

1. **Antes de cada operación modificadora** (editar, borrar, intercambiar):
   ```java
   historial.push(new EstadoEditor(lineas, lineaActiva));
   ```

2. **Al ejecutar deshacer** (nuevo comando `Z`):
   ```java
   if (!historial.isEmpty()) {
       EstadoEditor estadoPrevio = historial.pop();
       lineas = estadoPrevio.lineas;
       lineaActiva = estadoPrevio.lineaActiva;
   }
   ```

3. **Control de límite** (opcional):
   ```java
   if (historial.size() >= MAX_HISTORIAL) {
       historial.remove(0); 
   }
   ```

### Cambios Necesarios

- Agregar `Stack<EstadoEditor> historial` como atributo estático
- Crear clase interna `EstadoEditor`
- Modificar métodos `editarLinea()`, `borrarLinea()`, `intercambiarLineas()` para guardar estado antes de modificar
- Agregar nuevo método `deshacerOperacion()`
- Agregar comando `[Z]` al switch del menú principal

### Ventajas
- Implementación simple con estructuras estándar de Java
- Control de memoria con límite de historial
- Permite deshacer múltiples operaciones consecutivas

### Limitaciones
- Consume memoria proporcional al historial guardado
- No permite "rehacer" (CTRL+Y) - requeriría una pila adicional
