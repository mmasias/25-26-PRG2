# pyEdlin 🖥️  
Mini implementación del editor de líneas **EDLIN** en Python.

Proyecto educativo que reproduce el comportamiento básico del editor clásico de MS-DOS, con desarrollo organizado por commits reales.

---

## 📁 Estructura del proyecto

**Objetivo:** representar un fichero de 10 líneas

**Código:**
```python
MAX_LINES = 10
file_lines = ["" for _ in range(MAX_LINES)]
active_line = 0
