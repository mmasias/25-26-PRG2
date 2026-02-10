
## Estructura
- **Data**: Usaremos una lista simple de strings para representar las 10 líneas.
- **Estado**: Una variable entera `active_line` para saber dónde estamos operando.
- **Historial**: Para el "Deshacer", guardaremos una copia del estado anterior antes de cada cambio.

## Plan de Ejecución
1. **Fase 1**: Renderizado básico y estructura de datos .
2. **Fase 2**: Selección de línea activa y edición simple de texto.
3. **Fase 3**: Implementación de borrado e intercambio de líneas.
4. **Fase 4**: Sistema de Deshacer (Undo) usando una pila (stack) de estados.
