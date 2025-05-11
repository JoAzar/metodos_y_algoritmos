**Informe: Resolución del Problema SAT usando Hipercubo Booleano vs Algoritmo Convencional de 3-SAT**

---

### Introducción

El problema de satisfacibilidad booleana (SAT) es fundamental en informática teórica. En particular, el caso 3-SAT, donde cada cláusula tiene exactamente tres literales, es conocido por ser NP-completo. Tradicionalmente, se resuelve mediante algoritmos de fuerza bruta, backtracking (DPLL), o algoritmos más sofisticados como CDCL.

En este informe presentamos un enfoque alternativo inspirado en una estructura geométrica: el **hipercubo booleano**. Este modelo permite visualizar el espacio de búsqueda como un grafo de adyacencia entre combinaciones booleanas, facilitando una búsqueda recursiva más natural y podando caminos innecesarios.

---

### Enfoque Propuesto: Hipercubo Booleano

#### Modelo

* Cada nodo representa una asignación de valores booleanos a las variables.
* Las aristas conectan nodos que difieren en exactamente un bit (distancia de Hamming = 1).
* Esto forma un grafo conocido como un hipercubo de `n` dimensiones para `n` variables.

#### Ventajas

* Permite exploración espacial del espacio de soluciones.
* Facilita el uso de búsqueda recursiva con poda natural.
* Compatible con estrategias heurísticas.

---

### Código en Python

```python
from itertools import product

# Define la fórmula CNF
formula = [
    ['~x', 'y', '~z'],
    ['x', '~y', 'z'],
    ['x', 'y', 'z'],
    ['~x', '~y']
]

variables = ['x', 'y', 'z']

def evaluate_literal(lit, assignment):
    if lit.startswith('~'):
        return not assignment[lit[1:]]
    else:
        return assignment[lit]

def satisfies(assign):
    return all(any(evaluate_literal(lit, assign) for lit in clause) for clause in formula)

def build_hypercube(n):
    return list(product([0, 1], repeat=n))

def get_neighbors(node):
    neighbors = []
    for i in range(len(node)):
        flipped = list(node)
        flipped[i] ^= 1
        neighbors.append(tuple(flipped))
    return neighbors

def SAT_by_cube(variables):
    visited = set()

    def dfs(node):
        if node in visited:
            return False, {}
        visited.add(node)

        assignment = dict(zip(variables, [bool(v) for v in node]))
        if satisfies(assignment):
            return True, assignment

        for neighbor in get_neighbors(node):
            result, solution = dfs(neighbor)
            if result:
                return True, solution

        return False, {}

    return dfs((0,) * len(variables))

# Ejecutar el algoritmo
SAT_by_cube(variables)
```

#### Resultado:

```python
(True, {'x': True, 'y': False, 'z': False})
```

---

### Enfoque con Heurística Geométrica

En esta variante, exploramos primero las combinaciones con más ceros (menos verdaderos), lo cual en la estructura del hipercubo equivale a comenzar desde un vértice más "cercano" al origen y expandir desde allí.

```python
from itertools import product

# Define fórmula en CNF
formula = [
    ['~x', 'y', '~z'],
    ['x', '~y', 'z'],
    ['x', 'y', 'z'],
    ['~x', '~y']
]

variables = ['x', 'y', 'z']

def evaluate_literal(lit, assignment):
    if lit.startswith('~'):
        return not assignment[lit[1:]]
    else:
        return assignment[lit]

def satisfies(assign):
    return all(any(evaluate_literal(lit, assign) for lit in clause) for clause in formula)

def score(node):
    return node.count(0)

nodes = sorted(list(product([0, 1], repeat=len(variables))), key=score, reverse=True)

solution = None
for node in nodes:
    assignment = dict(zip(variables, [bool(v) for v in node]))
    if satisfies(assignment):
        solution = assignment
        break

solution
```

#### Resultado:

```python
{'x': False, 'y': False, 'z': True}
```

Este enfoque demuestra que se puede priorizar regiones del espacio de búsqueda más prometedoras, lo cual reduce el tiempo para encontrar soluciones en muchos casos, sin recorrer todas las combinaciones posibles.

---

### Comparación con Algoritmo Convencional 3-SAT

| Criterio                 | Algoritmo Convencional (DPLL/CDCL) | Enfoque Hipercubo Booleano           |
| ------------------------ | ---------------------------------- | ------------------------------------ |
| Modelo de búsqueda       | Recursivo basado en cláusulas      | Navegación en grafo de combinaciones |
| Estrategia               | Divide y conquista, backtracking   | Exploración espacial con vecinos     |
| Complejidad (peor caso)  | Exponencial                        | Exponencial                          |
| Escalabilidad heurística | Alta con CDCL y aprendizaje        | Alta con heurísticas de movimiento   |
| Visualización            | Lógica pura                        | Intuición geométrica                 |

---

### Conclusión

El modelo del hipercubo booleano permite reinterpretar el problema SAT como una búsqueda en el espacio topológico de asignaciones. Aunque ambos enfoques tienen complejidad exponencial en el peor caso, este modelo ofrece una representación intuitiva que podría facilitar nuevas formas de poda, paralelización o aprendizaje automático.

El uso de heurísticas geométricas o numéricas sobre esta estructura, como la priorización por cercanía al origen en el grafo del hipercubo, permite optimizar el recorrido del espacio de búsqueda sin necesidad de recorrer exhaustivamente todas las combinaciones.

Este tipo de representación abre la puerta a una línea de investigación alternativa para resolver problemas de satisfacibilidad con una mirada más algorítmica-geométrica.

By Favio Joel Zalazar
