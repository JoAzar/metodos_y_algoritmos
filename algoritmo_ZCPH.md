# ZeroCostPathHint: Preprocesamiento Heurístico de Rutas con "Teletransportación Virtual"

## Descripción General

**ZeroCostPathHint (ZCPH)** es un enfoque heurístico para analizar grafos antes de ejecutar algoritmos clásicos de búsqueda como Dijkstra o A*. Se basa en la detección temprana de rutas de costo mínimo o cercanas a cero, que simulan una "teletransportación lógica" entre nodos sin reconstrucción detallada del camino.

Este método puede utilizarse para optimizar búsquedas en grafos dinámicos, entornos de tiempo real, o donde el costo computacional debe mantenerse bajo.

---

## Motivación

En muchos sistemas de inteligencia artificial, videojuegos, IoT o análisis de redes, no siempre se necesita conocer el camino exacto entre dos nodos, sino saber si un destino es:

- Alcanzable desde cierto punto.
- Accesible con un costo extremadamente bajo.
- Estratégicamente cercano a nivel estructural (conectividad alta).

---

## Principio de Funcionamiento

ZCPH ejecuta una variante modificada de BFS/DFS donde:

1. El nodo más alejado desde un origen es detectado (máxima expansión).
2. Se generan rutas tentativas desde el origen y desde el nodo distante.
3. Se guardan rutas sin necesariamente construir el recorrido paso a paso (si el nodo fue alcanzado con menor costo, se considera válido).
4. Si se encuentra un nodo destino con costo 0 o cercano a 0, se asume que hay una "conexión directa", aunque no se explicite la ruta.

---

## Aplicaciones Potenciales

- **IA en videojuegos o robótica:** para decidir movimientos rápidos sin sobrecargar el procesador.
- **Redes sociales o sistemas de recomendación:** para saber si dos usuarios están “cerca” sin calcular toda la ruta.
- **Preprocesamiento en mapas logísticos:** evitando rutas redundantes si ya hay un camino evidente.
- **Sistemas cognitivos artificiales:** simulando saltos de pensamiento o asociaciones creativas.
- **Edge computing e IoT:** donde los dispositivos no pueden permitirse búsquedas pesadas.

---

## Comparación vs. Algoritmos Clásicos

| Característica          | ZeroCostPathHint      | Dijkstra / A*          |
|-------------------------|------------------------|-------------------------|
| Complejidad general     | Baja (lineal aprox.)   | Alta (logarítmica o más) |
| Retorno de camino       | Opcional / parcial     | Completo                |
| Reacción a cambios      | Muy rápida             | Requiere re-ejecución   |
| Ideal para              | Escaneo, filtrado, IA rápida | Caminos óptimos detallados |
| Representación mental   | Salto / Teleportación  | Recorrido paso a paso   |

---

## Futuras Extensiones

- Integración con Dijkstra como etapa previa para acelerar búsquedas.
- Adaptación para entornos 3D, laberintos, grafos ponderados dinámicos.
- Inclusión de pesos negativos o heurísticas personalizadas.
- Representación visual de "zonas teleportables".

---

## Código Base de Referencia

```python
def rqp_fixed(graph, start, goal):
    visited_nodes = set()

    def bfs_max_distance(start):
        queue = deque([(start, 0)])
        max_node, max_dist = start, 0
        visited = set()
        while queue:
            node, dist = queue.popleft()
            visited.add(node)
            if dist > max_dist:
                max_dist = dist
                max_node = node
            for neighbor, weight in graph[node]:
                if neighbor not in visited:
                    queue.append((neighbor, dist + weight))
        return max_node

    distant_node = bfs_max_distance(start)

    def get_paths(start_node):
        queue = deque([(0, [], start_node)])
        paths = {}
        while queue:
            cost, path, node = queue.popleft()
            path = path + [node]
            visited_nodes.add(node)
            if node not in paths or cost < paths[node][0]:
                paths[node] = (cost, path)
            for neighbor, weight in graph[node]:
                if neighbor not in path:
                    queue.append((cost + weight, path, neighbor))
        return paths

    paths_from_start = get_paths(start)
    paths_from_distant = get_paths(distant_node)

    if goal in paths_from_start and goal in paths_from_distant:
        return min(paths_from_start[goal], paths_from_distant[goal], key=lambda x: x[0]) + (visited_nodes,)
    elif goal in paths_from_start:
        return paths_from_start[goal] + (visited_nodes,)
    elif goal in paths_from_distant:
        return paths_from_distant[goal] + (visited_nodes,)
    return float('inf'), [], visited_nodes


---

Conclusión

ZeroCostPathHint no intenta reemplazar a los algoritmos clásicos, sino que los complementa con una herramienta de análisis rápido, inspirada en una visión distinta: detectar nodos estratégicos y conexiones potenciales sin el costo de un recorrido detallado. Esta visión puede acelerar decisiones en entornos computacionales exigentes o inspirar nuevos métodos de pensamiento computacional.


---

Creado por Favio Joel Zalazar