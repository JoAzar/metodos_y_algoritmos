# Complejidad del algoritmo de Backtracking en el problema de las 8 reinas

El **problema de las 8 reinas** consiste en colocar 8 reinas en un tablero de ajedrez de 8x8 de forma que ninguna se ataque entre sí (ni en la misma fila, columna ni diagonal). Una solución común es usar **backtracking**.

## Complejidad del algoritmo

### Peor caso (teórico)
En el peor de los casos, el algoritmo intenta colocar una reina en cada fila (8 filas), y en cada fila puede intentar hasta 8 columnas, aunque descarta rápidamente configuraciones inválidas.

- Esto da una complejidad teórica de: O(8!) = O(40320)

### Con backtracking (poda incluida)
El algoritmo evita muchas configuraciones inválidas mediante poda, pero aún así, la complejidad general para el problema de **N reinas** es:

- Complejidad general: `O(N!)`

Esto es porque se intenta una colocación en cada fila, probando columnas válidas y retrocediendo si se detectan conflictos.

## Resumen
- Para 8 reinas: `O(8!) = O(40320)`
- Para N reinas: `O(N!)`
- Aunque es una complejidad exponencial, para valores pequeños como 8, el algoritmo se ejecuta muy rápidamente.

---

## Fin del análisis
