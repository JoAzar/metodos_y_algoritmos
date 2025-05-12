## RQP - Red Quantum Pathfinder

> Tipo: Algoritmo de búsqueda adaptativa en grafos
Inspirado en: Recursividad tipo Fibonacci, reducción estructural tipo Gauss y condiciones de carrera dinámicas.

---

# Objetivo

Encontrar caminos eficientes en grafos complejos sin necesidad de recorrer todos los nodos, priorizando zonas de alta velocidad efectiva y colapsando regiones con patrones estructurales similares.

---

# Fundamento

Velocidad efectiva: Se calcula usando una fórmula basada en tiempo, distancia o peso.

Condición de carrera: Si una ruta más rápida aparece durante la ejecución, el algoritmo cambia de camino dinámicamente.

Reducción estructural: Agrupa regiones del grafo con patrones similares para tratarlos como bloques únicos (al estilo Gauss).

Recursividad optimizada: Se cachean (memoizan) los resultados parciales para evitar cálculos redundantes.

---

# Comparación con otros algoritmos

| Algoritmo                | Tipo de búsqueda     | Heurística | Ponderación | Condición de carrera | Exploración parcial | Complejidad esperada |
|--------------------------|----------------------|------------|-------------|-----------------------|----------------------|-----------------------|
| Dijkstra                 | Camino más corto     | No         | Sí          | No                    | No                   | O(V²) o O(E + V log V)|
| A*                       | Camino más corto     | Sí         | Sí          | No                    | Sí (gracias a H)     | O(E) o mejor          |
| BFS                      | Nivel por nivel      | No         | No          | No                    | No                   | O(V + E)              |
| DFS                      | Profundidad          | No         | No          | No                    | No                   | O(V + E)              |
| **RQP** (Red Quantum Pathfinder) | Más lejano + corrección | No         | Sí          | **Sí**                | **Sí**               | O(V + E) estimado     |


---

# Complejidad (estimada)

Mejor caso: O(log V) si el grafo tiene alta agrupación y velocidad predominante.

Peor caso: O(V + E) si no hay zonas colapsables ni caminos mejores.

Promedio: O(V log V) si hay cierta estructura aprovechable.



---

# Código base (prototipo simplificado)

def rqp(graph, start, memo={}):
    if start in memo:
        return memo[start]

    if es_zona_reducible(graph, start):
        resultado = resolver_zona_reducida(graph, start)
    else:
        vecinos = graph[start]
        resultados = []
        for v, peso in vecinos:
            sub_resultado = rqp(graph, v, memo)
            resultados.append(peso + sub_resultado)

        resultado = min(resultados)

    memo[start] = resultado
    return resultado


---

> Nota: este pseudocódigo debe ser adaptado a grafos dirigidos/no dirigidos y estructuras de pesos.
