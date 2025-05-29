# Evaluación de Árboles Booleanos con Path Compression Horizontal

---

## Idea principal

Aplicar **path compression**, técnica típica de estructuras de conjuntos disjuntos (Union-Find), pero adaptada **horizontalmente** para recorrer expresiones booleanas en forma de array (por ejemplo, postfijo)

Esto permite

- Reutilizar resultados de subexpresiones repetidas

- Obtener el valor lógico de cualquier subexpresión en tiempo amortizado **O(α(n))**, donde α(n) es la inversa de Ackermann

- Mejorar rendimiento cuando evaluamo múltiples árboles o consultas lógicas sobre la misma estructura

---

## Estructuras utilizadas

- `results[i]`: valor booleano (True/False) resultante del token en posición `i` si ya fue evaluado

- `jumps[i]`: índice al que salta el token `i` si ya pertenece a una subexpresión resuelta (compresión de camino horizontal)

- `find(i)`: función recursiva con compresión que retorna el índice raíz de la subexpresión que contiene a `i`

---

## 📉 Complejidad

| Técnica                         | Tiempo    | Espacio | Comentario                          |
|--------------------------------|-----------|---------|-------------------------------------|
| Evaluación clásica (stack)     | O(n)      | O(n)    | Evalúa todo sin reutilización       |
| Memoización con hash           | O(n)      | O(n)    | Evita repeticiones, sin compresión |
| 🧠 Path compression horizontal | O(n·α(n)) | O(n)    | Óptima para expresiones repetidas   |

---

### Posibles aplicaciones

- Motores de inferencia lógica y sistemas expertos

- Motores de evaluación de reglas (ej: motores de juego, árboles de decisión)

- Filtros booleanos complejos en bases de datos

- Compiladores o intérpretes para expresiones booleanas repetitivas

- Lógica proposicional, SAT solvers con memoización