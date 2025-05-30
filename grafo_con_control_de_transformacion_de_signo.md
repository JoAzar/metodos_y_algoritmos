# Sistema de Grafos con Control de Transformación de Signo (`trans`)

Es un sistema de representación de grafos en el cual cada **vértice** incluye un atributo llamado `trans` que indica si ha sido afectado por un **cambio de signo** en alguna de sus aristas

Esto resulta útil en algoritmos que transforman problemas de **caminos máximos a mínimos**, y permite hacer seguimiento de las transformaciones realizadas


---

## Estructuras de Datos

### 🔹 Clase `Vertice`

```python
class Vertice:
    def __init__(self, id):
        self.id = id
        self.trans = False  #Indica si el vértice participó en una transformación de signo
```

### 🔸 Clase `Arista`

```python
class Arista:
    def __init__(self, origen, destino, peso):
        self.origen = origen  #Objeto Vertice
        self.destino = destino  #Objeto Vertice
        self.peso = peso  #Peso original de la arista

    def invertir_signo(self):
        self.peso *= -1
        self.origen.trans = True
        self.destino.trans = True
```

---

# 🔄 Lógica de Transformación

### Para convertir un problema de camino máximo en uno de camino mínimo, se invierte el signo de todas las aristas del grafo

```python
for arista in grafo.aristas:
    arista.invertir_signo()
```

Esto asegura que los algoritmos clásicos como Dijkstra o Bellman-Ford puedan operar bajo la lógica invertida

**El atributo trans se activa en cada vértice involucrado**

---

## Atributo trans

### Función

**El atributo trans es un flag (booleano) que permite**

- Saber qué vértices fueron afectados por una transformación

- Aplicar reglas especiales a esos vértices

- Analizar los efectos de las transformaciones en el grafo

## Variante avanzada

**Podés convertir trans en un contador para registrar cuántas veces fue transformado**

```
self.trans = 0
...
self.trans += 1
```

Ej
```python
#Creamos vertices
a = Vertice("A")
b = Vertice("B")

#Creamos aristas
ar = Arista(a, b, 10)

#Invertimos signo
ar.invertir_signo()

#Verificamos estado
print(a.trans)  # True
print(ar.peso)  # -10
```

---

## Casos de uso

- Análisis de caminos máximos convertidos en mínimos

- Visualización de transformaciones en grafos

- Aplicación de reglas contextuales según si un nodo fue afectado

- Debugging de algoritmos que modifican pesos dinámicamente

---

## Notas técnicas

- Este enfoque no cambia la topología del grafo, solo los valores.

- Funciona bien en DAGs o grafos sin ciclos positivos.

- Puede integrarse con estructuras de prioridad (heapq) para algoritmos de rutas

---

Creado por Favio Joel Zalazar
