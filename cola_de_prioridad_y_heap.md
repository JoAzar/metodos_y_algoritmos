# ¿Qué es una cola de prioridad?

Una cola de prioridad es una estructura de datos similar a una cola, pero con una diferencia clave

- En una cola normal (como en una fila del colectivo), los elementos salen en el orden en que entraron (FIFO: First In, First Out)

- En una cola de prioridad, cada elemento tiene una prioridad asociada, y el que tiene mayor prioridad sale primero, sin importar cuándo llegó

*Un ejemplo podría ser las personas con discapacidad y/o jubilados que ingresan a un banco, ellos tienen prioridad incluso entrando luego que otras personas*

---

# ¿Qué es un heap?

*No, no es un hipster*

Un heap (loma/montículo/elevación) es una estructura de datos en forma de árbol que se usa para implementar eficientemente una cola de prioridad

`Hay dos tipos principales`

- Min-heap: el elemento con menor valor está en la raíz

- Max-heap: el elemento con mayor valor está en la raíz

---

Fuentes a consultar: [https://www.geeksforgeeks.org/whats-the-relationship-between-a-heap-and-the-heap/]

---

# Acá viene lo bueno

## ¿Cómo funciona una cola de prioridad con heap?

Al usar un heap como implementación interna de una cola de prioridad

- Agregar un elemento toma O(log n) tiempo

- Sacar el de mayor prioridad (el mínimo en un min-heap) toma O(log n)

- Consultar el mínimo es O(1)

---

## ¿Por qué es útil?

Se usa en algoritmos como

- Dijkstra (camino más corto)

- Prim (árbol de expansión mínima)

- A* (búsqueda heurística)

- Simulaciones donde eventos ocurren en orden de prioridad

---

# Implementación en Python de Min-heap (prioridad en el más pequeño)

```python
import heapq

#Crear una cola de prioridad vacía
cola = []

#Insertar elementos (prioridad, valor)
heapq.heappush(cola, (2, 'B'))
heapq.heappush(cola, (1, 'A'))
heapq.heappush(cola, (3, 'C'))

#Sacar el de mayor prioridad (el menor en este caso)
print(heapq.heappop(cola))
```

*Dato de color, en Python no existe un Max-heap por lo que hay que usar un truco*

Multiplicar las prioridades por -1 al insertarlas. Así, lo más grande se convierte en lo más pequeño desde la perspectiva del min-heap

De esta manera se entiende que si busco el menor -5 es el más grande (por así decirlo) de los pequeños, pero como max_heap busca el valor más grande de los grandes (como Messi) entonces ese enfoque nos permite jugar con esa ventaja de encontrar el -5 y luego volverlo positivo `-1 * -5 = 5`

Ej
```python
import heapq

max_heap = []
heapq.heappush(max_heap, -5)
heapq.heappush(max_heap, -1)
heapq.heappush(max_heap, -3)

# Para obtener el valor real, hay que multiplicar por -1
print(-heapq.heappop(max_heap))
```
