# PolarSort

---

### PolarSort es un algoritmo de ordenamiento inspirado en la noción de polos o núcleos de atracción. Los polos se eligen automáticamente en función de la distribución de los datos, y cada elemento se inserta de manera ordenada en el bucket más cercano

### A diferencia de algoritmos clásicos como MergeSort o QuickSort, PolarSort no busca dividir recursivamente, sino agrupar inteligentemente elementos basándose en similitud numérica respecto a puntos centrales

---

## ¿Cómo funciona?

- Se calculan automáticamente los polos usando percentiles de los datos


- Cada elemento se asigna al bucket cuyo polo esté más cercano


- Cada bucket mantiene sus elementos en orden al momento de insertarlos


- Los buckets se concatenan en orden de menor a mayor polo

---

## Complejidad

Mejor caso: O(n) si los polos están perfectamente distribuidos y los buckets balanceados

Promedio/Peor caso: O(n log k) + O(n)
Donde k es el número de polos (buckets)

---

## Uso recomendado

Para conjuntos de datos que tienen agrupaciones naturales

Cuando se quiera experimentar con estrategias alternativas de ordenamiento

Como base para algoritmos más complejos que combinen clustering + ordenamiento

---

## Algoritmo

```python
import bisect
import numpy as np

def polar_sort_mejorado(lista, k=3):
    percentiles = np.linspace(0, 100, k + 2)[1:-1]
    polos = np.percentile(lista, percentiles).tolist()
    buckets = {polo: [] for polo in polos}
    for x in lista:
        polo_mas_cercano = min(polos, key=lambda p: abs(x - p))
        bisect.insort(buckets[polo_mas_cercano], x)
    resultado = []
    for polo in sorted(polos):
        resultado.extend(buckets[polo])
    return resultado
```

---

## Algoritmo PolarSort paso a paso

Dada una lista de números desordenados

```python
lista = [10, 23, 5, 16, 42, 37, 8]
```

Supongamos que ya calculamos 3 polos equiespaciados (percentiles intermedios)

polos = [10, 25, 40]


## Paso 1: Inicialización de buckets

Creamos un bucket vacío para cada polo

```python
buckets = {
    10: [],
    25: [],
    40: []
}
```

---

## Paso 2: Asignar cada número a su polo más cercano

### distancia al polo más cercano

valor | dist. 10 | dist. 25 | dist. 40 | group
---
10       	0	         15	         30	       10
---
23	       13	         2	        17	      25
---
5	         5	        20	        35        10
---
16        	6	        9	          24       10
---
42       	32	        17         	2        40
---
37	       27	        12         	3        40
---
8	         2	        17         	32       10

(perdón si se ve feo)

Cada número se inserta en su bucket correspondiente manteniendo orden interno, usando bisect.insort

---

## Paso 3: Resultado de los buckets ordenados

```python
buckets = {
    10: [5, 8, 10, 16],
    25: [23],
    40: [37, 42]
}
```

---

## Paso 4: Unir los buckets

```python
resultado_final = [5, 8, 10, 16] + [23] + [37, 42]
# → [5, 8, 10, 16, 23, 37, 42]
```

---

## ✅ Conclusión

El algoritmo PolarSort agrupa los elementos por cercanía a polos distribuidos inteligentemente (percentiles) y ordena cada grupo con inserciones binarias. Esto permite formar una lista final ordenada de manera eficiente en ciertos contextos

---

Creado por Favio Joel Zalazar
