# Algoritmo de Prim

Antes que nada quiero mencionar que para comprender el algoritmo de Prim primero tenemos que comprender qué es un árbol de expansión mínima MST (buscarlo en la lista de archivos en este mismo repo)
Por ende también entender qué es un grafo, obviamente

---

`Prim parte de un vértice arbitrario y va creciendo el MST añadiendo en cada paso la arista más barata que conecta un vértice del árbol con uno fuera de él`

### Pasos básicos

1) Escoge un vértice inicial (cualquiera sirve, no importa cuál)
2) Marca ese vértice como visitado
3) Desde los vértices visitados, elige la arista más barata que conecta con un vértice no visitado
4) Añade esa arista y el nuevo vértice al árbol
5) Repite los pasos 3 y 4 hasta incluir todos los vértices

---

## Veamos un ejemplo

*Dibujito nerd aparece*

     A
   / | \
  B--C--D

### Con los pesos

  | A-B: 1 |
  | A-C: 3 |
  | B-C: 1 |
  | C-D: 4 |

### Aplicando Prim desde A

  Empezamos en A
  Las aristas posibles: A-B (1), A-C (3). Tomamos A-B (menor peso)
  Ahora tenemos A y B. Miramos las nuevas aristas: B-C (1), A-C (ya considerada), C-D (no todavía). Tomamos B-C (1)
  Ahora tenemos A, B, C. Las nuevas aristas: C-D (4). Tomamos C-D
  Todos los vértices están incluidos, termina el algoritmo

### Árbol generado
  | A-B (1) |
  | B-C (1) |
  | C-D (4) |
  
  *Peso total: 6*

---

## Complejidad

### Depende de la implementación

Con listas de adyacencia y cola de prioridad (heap): O(E log V)
Con matriz de adyacencia (sin heap): O(V²)

*Dejo un archivo en este mismo repo con la explicación de lo que es cola de prioridad y heap*

---

Creado por Favio Joel Zalazar
