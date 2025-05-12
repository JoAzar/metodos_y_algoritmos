# Red Race Pathfinding (RRP)

**Red Race Pathfinding (RRP)** es un algoritmo de búsqueda de caminos en grafos, diseñado por Favio Joel Zalazar, que combina expansión no heurística, análisis bifocal y condiciones de carrera adaptativas. A diferencia de los algoritmos tradicionales como Dijkstra o A*, RRP permite que múltiples trayectorias compitan dinámicamente, ajustándose en tiempo real si una ruta mejor aparece.

---

## Características clave

- **Expansión máxima inicial:** comienza desde un nodo cualquiera buscando el nodo más lejano, sin considerar costos mínimos.
- **Exploración bifocal simultánea:** se inicia una expansión desde el nodo original y otra desde el nodo más lejano alcanzado.
- **Comparación de vecinos:** ambos extremos analizan vecinos y sus pesos para evaluar posibles rutas más eficientes.
- **Condición de carrera controlada:** si un nodo en proceso recibe una visita con mejor costo, la ruta se “pisa” y se adapta dinámicamente.
- **Construcción reactiva de rutas:** los caminos se ajustan en función de las decisiones tomadas durante la ejecución, no antes.

---

## Etapas del algoritmo

1. **Inicio aleatorio o definido:** seleccionar un nodo inicial arbitrario.
2. **Expansión profunda:** buscar el nodo más lejano sin importar los pesos (máxima distancia topológica).
3. **Lanzamiento bifocal:** iniciar dos exploraciones paralelas desde el nodo inicial y el más lejano.
4. **Lectura de vecinos:** ambos extremos leen sus vecinos y almacenan sus pesos.
5. **Comparación cruzada:** se comparan los pesos de los vecinos descubiertos para detectar rutas más económicas.
6. **Reconfiguración dinámica:** si se detectan rutas con mejor peso, se genera un nuevo camino que “pisa” la ruta actual.
7. **Propagación competitiva:** los caminos compiten por los nodos en tiempo real, actualizando los estados según la mejor opción.
8. **Finalización:** cuando no se pueden generar rutas más eficientes, se determina la mejor ruta trazada.

---

## Posibles aplicaciones

- Inteligencia artificial en videojuegos.
- Sistemas de rutas con condiciones cambiantes (tráfico, redes).
- Simulaciones multiagente con competencia adaptativa.
- Exploración de entornos impredecibles o dinámicos.

---

## Implementación básica en Python

```python
import networkx as nx
import heapq

def red_race_pathfinding(G, start_node):
    def get_farthest_node(start):
        visited = set()
        queue = [(0, start)]
        farthest = (0, start)
        while queue:
            dist, node = queue.pop(0)
            if dist > farthest[0]:
                farthest = (dist, node)
            visited.add(node)
            for neighbor in G.neighbors(node):
                if neighbor not in visited:
                    queue.append((dist + 1, neighbor))
        return farthest[1]

    def explore_neighbors(node, visited, cost_map, came_from, queue):
        for neighbor in G.neighbors(node):
            weight = G[node][neighbor].get('weight', 1)
            new_cost = cost_map[node] + weight
            if neighbor not in cost_map or new_cost < cost_map[neighbor]:
                # Condición de carrera: "pisar" si llega mejor camino
                cost_map[neighbor] = new_cost
                came_from[neighbor] = node
                heapq.heappush(queue, (new_cost, neighbor))

    # Paso 1: obtener nodo más lejano desde el nodo inicial
    far_node = get_farthest_node(start_node)

    # Paso 2: estructuras base
    visited = set()
    cost_map = {start_node: 0, far_node: 0}
    came_from = {}
    queue = []
    heapq.heappush(queue, (0, start_node))
    heapq.heappush(queue, (0, far_node))

    # Paso 3: recorrido bifocal con condiciones de carrera
    while queue:
        current_cost, current = heapq.heappop(queue)
        if current in visited:
            continue
        visited.add(current)
        explore_neighbors(current, visited, cost_map, came_from, queue)

    return came_from, cost_map


import networkx as nx
G = nx.Graph()
G.add_edge("A", "B", weight=4)
G.add_edge("A", "C", weight=2)
G.add_edge("B", "D", weight=5)
G.add_edge("C", "D", weight=1)
G.add_edge("D", "E", weight=3)

came_from, cost_map = red_race_pathfinding(G, "A")

# Mostrar el camino final desde A a E
def reconstruct_path(came_from, end):
    path = [end]
    while end in came_from:
        end = came_from[end]
        path.append(end)
    return path[::-1]

print("Camino a E:", reconstruct_path(came_from, "E"))
print("Costos:", cost_map)
```

---

## Complejidad y Comparación

### **Análisis de complejidad**

El algoritmo **Red Race Pathfinding (RRP)** tiene una complejidad aproximada de:

1. **Búsqueda del nodo más lejano (BFS sin peso):**
   - **Complejidad:** `O(V + E)`, donde `V` son los nodos y `E` las aristas.

2. **Expansión bifocal con condiciones de carrera:**
   - Al igual que **Dijkstra**, pero con dos focos de expansión y posibilidad de pisado.
   - **Complejidad aproximada:** `O((V + E) * log V)` usando una cola de prioridad (`heapq`).

### **Complejidad total:**

**`O(V + E) + O((V + E) * log V)`  ≈  `O((V + E) * log V)`**

---

### **Comparación con otros algoritmos**

| **Algoritmo**   | **Complejidad**               | **Observaciones**                          |
|-----------------|-------------------------------|--------------------------------------------|
| **Dijkstra**    | `O((V + E) * log V)`           | Búsqueda de ruta óptima desde un solo nodo |
| **A***          | `O((V + E) * log V)`           | Similar a Dijkstra, pero con heurística    |
| **Red Race (RRP)** | `O((V + E) * log V)`       | Bifocal y adaptativo, sin heurística, con pisadas dinámicas |

---

### **¿Y si hay muchas pisadas?**

En el peor caso (si hay múltiples pisadas), la complejidad podría acercarse a:

**`O(k * (V + E) * log V)`** donde `k` es el número de veces que se realizan pisadas o reconfiguraciones durante el proceso de búsqueda.

---

Este algoritmo tiene una complejidad similar a otros algoritmos de búsqueda de caminos en grafos, pero con la ventaja de adaptarse de manera reactiva a cambios, permitiendo exploración y optimización de rutas en paralelo desde múltiples puntos de origen.

---

## Licencia

> Este algoritmo fue ideado por Favio Joel Zalazar (Red). Si lo usás, mencioná la fuente o compartí tus mejoras con la comunidad.