# ♟️ Solución Alternativa al Problema de las N Reinas (sin Backtracking)

> ⚡ **Enfoque determinista O(n)** para tableros N×N, aplicable cuando **N es múltiplo de 8**.

---

## 🧠 Idea Principal

En lugar de usar backtracking, este enfoque utiliza una **estrategia modular y constructiva**:

- Se parte de una solución conocida del tablero 8x8,
- Se replica el patrón en bloques de 8×8 dentro del tablero más grande,
- Cada bloque se desplaza en filas y columnas para evitar conflictos,
- **Resultado:** Se colocan N reinas en un tablero de N×N sin amenazas entre sí.

---

## 📦 Patrón Base (8 reinas)

Una solución válida para el problema de las 8 reinas es:

python
solucion_8 = [1, 5, 8, 6, 3, 7, 2, 4]

## Complejidad

- Tiempo: O(n), ya que se coloca una reina por fila en forma directa sin búsqueda.
- Espacio: O(n²), por el almacenamiento del tablero completo.

## Conclusión

- Este método proporciona una solución rápida y escalable al problema de las N reinas para valores de N que sean múltiplos de 8, evitando completamente las técnicas de backtracking y haciendo uso de la estructura repetitiva del patrón base.
