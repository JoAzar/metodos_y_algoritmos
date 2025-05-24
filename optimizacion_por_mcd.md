# Multiplicación y División Optimizada por MCD

En muchas operaciones matemáticas con enteros, especialmente multiplicación y división, es posible aplicar una optimización previa usando el **Máximo Común Divisor (MCD)**. Esta técnica busca reducir los operandos antes de realizar la operación, disminuyendo el uso de recursos y mejorando la claridad algorítmica

## Objetivo

Implementar una estrategia de simplificación previa a la multiplicación y división, basada en la factorización por el MCD de los operandos

Esta estrategia puede usarse para:

* Reducir el tamaño de los operandos
* Prevenir overflows en multiplicaciones
* Encontrar fracciones irreducibles
* Optimizar cálculos en sistemas embebidos o con bajo rendimiento

## Fundamento Teórico

Dado dos números enteros positivos $a$ y $b$, si $\gcd(a, b) = d$, entonces:
\[a = d \cdot a', \quad b = d \cdot b'\]

### Multiplicación

$a \cdot b = (d \cdot a') \cdot (d \cdot b') = d^2 \cdot (a' \cdot b')$

### División

$\frac{a}{b} = \frac{d \cdot a'}{d \cdot b'} = \frac{a'}{b'}$

## Ejemplo de uso

```python
from math import gcd

def multiplicacion_simplificada(a, b):
    mcd = gcd(a, b)
    if mcd > 1:
        a_s = a //mcd
        b_s = b //mcd
        return (mcd ** 2) * (a_s * b_s)
    return a * b

def division_simplificada(a, b):
    mcd = gcd(a, b)
    if mcd > 1:
        a_s = a //mcd
        b_s = b //mcd
        return a_s / b_s
    return a / b
```

## Casos de prueba

| A   | B   | MCD | Multiplicación optimizada | División optimizada |
| --- | --- | --- | ------------------------- | ------------------- |
| 500 | 200 | 100 | 100000                    | 2.5                 |
| 503 | 207 | 1   | 104121                    | \~2.43              |
| 36  | 48  | 12  | 1728                      | 0.75                |
| 121 | 11  | 11  | 1331                      | 11.0                |
| 17  | 19  | 1   | 323                       | \~0.89              |

## Conclusión

Este enfoque demuestra que aplicar el MCD como paso previo puede tener beneficios prácticos, especialmente en ambientes de cómputo restringido o donde se necesita una forma canónica de las operaciones. Aún cuando no siempre brinda una ventaja directa, el algoritmo es seguro, reversible y puede integrarse en rutinas matemáticas generales

---

**Autor:** Favio Joel Zalazar
