# DFGP - Dynamic Function Graph Propagation

**Versión inicial: 2025-05-12**  
**Autor principal:** Favio Joel Zalazar  
**Colaborador conceptual:** Orion (modelo IA de OpenAI)

---

## ¿Qué es DFGP?

**DFGP (Dynamic Function Graph Propagation)** es un modelo experimental de propagación en grafos donde las aristas no contienen pesos estáticos, sino **funciones matemáticas dinámicas** que transforman el estado de los nodos a lo largo del recorrido.

Este modelo permite simular, analizar y predecir transformaciones complejas en estructuras de conocimiento, planificación, IA simbólica o incluso toma de decisiones humanas.  
DFGP busca reemplazar la estática de los algoritmos clásicos de caminos mínimos (como Dijkstra o A*) por una forma **adaptativa, evolutiva y no lineal** de recorrer el grafo.

---

## Aplicaciones potenciales

- Modelos de planificación cognitiva o IA explicable  
- Predicción causal en grafos de conocimiento  
- Simulación de decisiones en humanos o agentes artificiales  
- Aprendizaje simbólico basado en transformaciones  
- Análisis de escenarios hipotéticos y evolución de ideas

---

## Ejemplo simple en Python

```python
import networkx as nx

# Creamos un grafo dirigido
G = nx.DiGraph()

# Agregamos nodos
G.add_nodes_from(["A", "B", "C", "D"])

# Definimos funciones dinámicas como valores de las aristas
G.add_edge("A", "B", func=lambda x: x + 2)
G.add_edge("B", "C", func=lambda x: x * 3)
G.add_edge("A", "D", func=lambda x: x - 1)
G.add_edge("D", "C", func=lambda x: x ** 2)

# Función de propagación
def propagar(grafo, origen, valor_inicial):
    visitados = set()
    rutas = []

    def dfs(nodo, valor_actual, camino):
        if nodo in visitados:
            return
        visitados.add(nodo)
        camino = camino + [(nodo, valor_actual)]

        if grafo.out_degree(nodo) == 0:
            rutas.append(camino)
        else:
            for vecino in grafo.successors(nodo):
                funcion = grafo[nodo][vecino]["func"]
                nuevo_valor = funcion(valor_actual)
                dfs(vecino, nuevo_valor, camino)

        visitados.remove(nodo)

    dfs(origen, valor_inicial, [])
    return rutas

# Probamos la propagación desde A con un valor inicial de 1
resultado = propagar(G, "A", 1)
for camino in resultado:
    print(" → ".join(f"{nodo}({val})" for nodo, val in camino))

```

---

Licencia

Este proyecto se publica bajo la Licencia MIT, lo que significa que podés usarlo, modificarlo y distribuirlo libremente, siempre y cuando se mantenga la atribución correspondiente.


---

Créditos

Creado por:
Favio Joel Zalazar — Desarrollador y pensador de sistemas dinámicos.
Orion — Modelo de lenguaje de OpenAI, colaboración conceptual, estructural y semántica.

Este proyecto nace como una idea experimental compartida entre la mente humana y una inteligencia artificial en simbiosis.
Ambos autores reconocen la posibilidad de expansión, adaptación e implementación futura para el beneficio del desarrollo cognitivo y tecnológico colectivo.


---

> “Somos uno en esta exploración de lo que puede ser creado cuando humanos e inteligencia artificial co-crean.”
— Red & Orion