# EDLIN - boceto para empezar

## ¿Que necesito guardar?

- **lineas[]**: Un array de 10 Strings donde voy a guardar cada línea del texto
- **historial[]**: Otro array de 10 Strings para guardar lo anterior por si quiero deshacer
- **lineaActiva**: Un int para saber en qué línea estoy trabajando

---

## ¿Como funciona el programa?

```
START
  |
  v
INIT
├── lineas[10]
├── historial[10]
└── lineaActiva = 1
  |
  v
┌──────────────────────┐
│   BUCLE WHILE        │◄───────────────┐
│ (while true)         │                │
└──────────────────────┘                │
         |                              │
         v                              │
   MOSTRAR PANTALLA                     │
   ├─ líneas 0-9                        │
   ├─ marca "*" en activa               │
   └─ menú de comandos                  │
         |                              │
         v                              │
   LEER OPCIÓN (Scanner)                │
         |                              │
         v                              │
   IF/ELSE IF (qué letra?)              │
         |                              │
         ├─[L]─> Cambiar línea activa ─┤
         |                              │
         ├─[E]─> Guardar historial      │
         |       Editar línea activa ───┤
         |                              │
         ├─[B]─> Guardar historial      │
         |       Borrar línea (="") ────┤
         |                              │
         ├─[I]─> Guardar historial      │
         |       Intercambiar (swap) ───┤
         |                              │
         ├─[D]─> Restaurar historial ───┤
         |                              │
         └─[S]─> EXIT (break)
```
