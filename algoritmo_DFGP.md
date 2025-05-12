# Dynamic Function Graph Pathfinding (DFGP) por Favio Joel Zalazar

## ¿Qué es?

**DFGP** es un modelo de grafo donde cada arista no contiene un peso estático, sino una **función matemática**. Cuando se recorre una arista, el valor del nodo se transforma mediante dicha función, generando un **nuevo estado** que se propaga a lo largo del recorrido.

Este modelo permite predecir y encontrar **caminos óptimos** donde la prioridad no es la distancia ni el costo estático, sino el **resultado transformado final**, permitiendo usos avanzados como simulaciones, IA adaptativa, modelos de evolución y más.

---

## Estructura del modelo

- Cada **nodo** tiene un valor inicial.
- Cada **arista** contiene una función `f(x)` que transforma el valor del nodo actual.
- El objetivo es encontrar la **ruta que optimiza** (minimiza o maximiza) el valor final tras todas las transformaciones.

---

## Ejemplo en Python

```python
# Dynamic Function Graph Pathfinding (DFGP)
from collections import defaultdict
import math

class Graph:
    def __init__(self):
        self.edges = defaultdict(list)  # {from_node: [(to_node, function)]}
        self.nodes = {}  # {node: initial_value}

    def add_node(self, node, value):
        self.nodes[node] = value

    def add_edge(self, from_node, to_node, func):
        self.edges[from_node].append((to_node, func))

    def dfs(self, current, value, path, visited, results):
        visited.add(current)
        path = path + [current]

        if not self.edges[current]:
            results.append((value, path))
            return

        for neighbor, func in self.edges[current]:
            if neighbor not in visited:
                new_value = func(value)
                self.dfs(neighbor, new_value, path, visited.copy(), results)

    def find_best_path(self, mode="min"):
        results = []
        for start in self.nodes:
            self.dfs(start, self.nodes[start], [], set(), results)

        if mode == "min":
            return min(results, key=lambda x: x[0])
        else:
            return max(results, key=lambda x: x[0])

# --- Ejemplo de uso ---
g = Graph()
g.add_node('A', 2)
g.add_node('B', 0)
g.add_node('C', 0)
g.add_node('D', 0)

# A → B (x²), B → C (x + 3), C → D (log(x + 1))
g.add_edge('A', 'B', lambda x: x**2)
g.add_edge('B', 'C', lambda x: x + 3)
g.add_edge('C', 'D', lambda x: math.log(x + 1))

# Buscar camino con valor final mínimo
result_value, result_path = g.find_best_path(mode="min")

print("Mejor ruta (mínima):", result_path)
print("Valor final:", result_value)

```

---

## Posibles aplicaciones

Predicción de rutas estratégicas.

Modelos de decisiones evolutivas.

IA basada en progresión de estado.

Simulaciones sociales, biológicas o económicas.

Juegos y sistemas de progreso personalizado.



---