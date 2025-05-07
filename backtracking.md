# 🧠 Backtracking (Retroceso)

## ¿Qué es?

El algoritmo de **backtracking** (o retroceso) es una técnica para resolver problemas que construyen soluciones paso a paso,  
**retrocediendo** cuando una decisión lleva a una solución inválida. Es una forma **optimizada de fuerza bruta**, ya que **evita caminos imposibles**.

## Características

- 🔄 Es **recursivo** y trabaja con decisiones sucesivas.
- ✂️ **Descarta caminos inválidos** tan pronto como sea posible.
- ✅ Puede encontrar **una o todas** las soluciones válidas.
- 🧩 Ideal para **problemas combinatorios con restricciones**.

## ¿Cuándo usarlo?

- Cuando el problema requiere probar muchas combinaciones pero **con reglas claras que permiten podar ramas inválidas**.
- Para encontrar soluciones en **rompecabezas, juegos, combinaciones, laberintos**, etc.
- Cuando se desea **minimizar el espacio explorado** aprovechando las restricciones del problema.

## Ejemplos

- Resolver un **Sudoku** con reglas estrictas.
- El clásico problema de las **N reinas**.
- Encontrar **caminos válidos en laberintos**.
- Generar **anagramas válidos** con ciertas letras.
- Resolver **puzzles de lógica**.

## Complejidad típica

| Caso                              | Complejidad (aproximada) |
|-----------------------------------|---------------------------|
| Peor caso (sin poda)              | `O(b^n)`                  |
| Con poda efectiva (caso práctico) | Mucho menor               |
| Problema N-Reinas                 | `O(N!)`                   |
| Sudoku                            | ~`O(9^m)` (`m` = celdas vacías) |

---
