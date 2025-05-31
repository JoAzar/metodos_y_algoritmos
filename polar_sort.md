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

Creado por Favio Joel Zalazar
