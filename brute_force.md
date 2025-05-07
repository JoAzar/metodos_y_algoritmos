# 🧨 Fuerza Bruta (Brute Force)

## ¿Qué es?

El algoritmo de **fuerza bruta** consiste en **probar todas las combinaciones posibles** hasta encontrar una solución válida.  
No utiliza lógica avanzada ni atajos: simplemente recorre exhaustivamente el espacio de búsqueda.

## Características

- 🔁 Explora **todo el espacio de soluciones** posibles.
- ✅ **Garantiza** encontrar una solución si existe.
- 🐌 Es **costoso en tiempo y recursos** para entradas grandes.
- 🤖 **Muy fácil de implementar**, pero poco eficiente.

## ¿Cuándo usarlo?

- Cuando el espacio de búsqueda es **pequeño** o **acotado**.
- Para obtener una **solución exacta**, sin importar el tiempo.
- Como herramienta de prueba para validar otros algoritmos.
- Para resolver problemas donde no se conocen buenas heurísticas.

## Ejemplos

- Buscar un valor en una lista desordenada → `O(n)`
- Forzar claves probando todas las combinaciones → `O(n^k)`
- Resolver un Sudoku con prueba y error → `O(9^81)`
- Encontrar un subconjunto de números que sumen un valor → `O(2^n)`

## Complejidad típica

| Problema                               | Complejidad     |
|----------------------------------------|-----------------|
| Búsqueda lineal                        | `O(n)`          |
| Generación de subconjuntos             | `O(2^n)`        |
| Permutaciones de `n` elementos         | `O(n!)`         |
| Combinaciones con `k` elementos        | `O(n^k)`        |

---
