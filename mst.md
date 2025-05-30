# ¿Qué es un árbol de expansión mínima (MST)?

## Dado un grafo no dirigido, conexo y ponderado un MST es un subconjunto de sus aristas que

- Conecta todos los vértices (es decir, forma un árbol, sin ciclos)

- Minimiza la suma total de los pesos de las aristas incluidas

- Tiene exactamente V − 1 aristas, si el grafo tiene V vértices

---

## ¿Por qué es útil un MST?

Se usa en muchos problemas donde queremos conectar varios puntos de la forma más barata posible (menor costo)

### Ejemplo

- Diseño de redes eléctricas, de carreteras, o de internet

- Agrupamiento de datos (clustering)

- Procesamiento de imágenes

### Ejemplo concreto

Supón que tienes 4 ciudades conectadas con caminos de diferentes costos
```
De A a B -> COSTO: 1
De A a D -> COSTO: 3
De A a C -> COSTO: -
De B a D -> COSTO: 1
De C a D -> COSTO: 4
```

Podríamos conectar todas las ciudades con caminos por un costo total mínimo. 

MST
```
A-B (1)
B-D (1)
A-C (3)
Total = 5
```

