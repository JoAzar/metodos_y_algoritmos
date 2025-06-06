# Path Compression

## ¿Qué es Path Compression?

**Path Compression** es una técnica utilizada para optimizar estructuras de datos que representan conjuntos o árboles, especialmente cuando hay que buscar repetidamente el representante o raíz de un nodo dentro de una estructura jerárquica

La idea principal es **aplanar el camino** desde un nodo hasta su representante o raíz, de modo que futuras consultas sean más rápidas

---

## ¿Para qué sirve?

Path Compression se emplea para mejorar la eficiencia de operaciones que requieren encontrar el representante de un conjunto, como en

- Estructuras de conjuntos disjuntos (Union-Find)
  
- Algoritmos que manipulan árboles o grafos
  
- Sistemas jerárquicos donde se busca un ancestro común

La compresión de camino ayuda a reducir la profundidad de los árboles internos, acelerando las búsquedas futuras al disminuir la cantidad de pasos necesarios

---

## ¿Cómo se implementa?

El mecanismo básico consiste en, durante la operación de búsqueda de un nodo hacia su raíz, hacer que todos los nodos visitados apunten directamente a la raíz. 

Esto se puede implementar típicamente de forma recursiva o iterativa

### Implementación recursiva (pseudocódigo):

```pseudo
  function find(x):
      if parent[x] != x:
          parent[x] = find(parent[x])  // Actualiza parent[x] al representante raíz
      return parent[x]
```

```pseudo
  function find(x):
      root = x
      while parent[root] != root:
          root = parent[root]
      // ahora root es la raíz
  
      // compresión de camino: hacer que todos los nodos apunten a root
      while x != root:
          next = parent[x]
          parent[x] = root
          x = next
  
      return root
```

---

## Beneficios

- Reduce la altura máxima de los árboles internos

- Mejora el tiempo promedio de operaciones de búsqueda

- Permite que las estructuras jerárquicas se mantengan eficientes incluso después de muchas modificaciones

En algoritmos como Kruskal sumado a Union Find el pack compression amortizada cada operación union o find y se acerca a O(α(n)), donde α(n) es la inversa de la función de Ackermann, que crece tan lento que para todos los propósitos prácticos es casi constante

`Esto hace que Kruskal sea muy eficiente incluso en grafos grandes`

---

## Resumiendo

Imaginemos un árbol, porque es más práctico, bajo dos niveles |abuelo|padre|nieto e hijo| desde el nieto hasta el abuelo tengo un camino, ahora imaginense bajar al nieto del nieto del nieto, re largo

¿Entonces qué hacemos? Apuntamos al abuelo (suena re mal) y entonces estamos re cerquita


---


### Resumiento con explicación Chatgepetera (yo no lo entiendo así pero por ahí les sirve)

- Cuando haces find(nieto), subes hasta la raíz (el abuelo)

- En el camino de vuelta, haces que cada nodo intermedio (padre, hijo) apunte directamente al abuelo

- Esto "aplana" el árbol, acortando el camino para futuras búsquedas



```python
  print("Creado por Favio Joel Zalazar")
```
