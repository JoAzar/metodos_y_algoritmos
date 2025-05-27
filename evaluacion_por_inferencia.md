# Análisis: Evaluación lógica de un array de booleanos

Supongamos que tenemos un array de valores booleanos (True = luz verde, False = luz roja) y queremos saber el resultado lógico global de aplicar una operación sobre ellos (como AND o OR)

---

Enfoque tradicional: recorrido completo

Ejemplo: AND lógico

```python

def evaluar_and(array):
    for val in array:
        if not val:
            return False
    return True
```

### Complejidad

Peor caso: O(n), si todos son True (debe recorrerlos todos)

Mejor caso: O(1), si encuentra un False al principio

---

### Enfoque por inferencia lógica

¿Qué pasa si ya sabemos que todos los valores son True?

Podemos inferir el resultado sin recorrer

```python
def inferir_and(array, regla_conocida=False):
    if regla_conocida:
        return True  # sin recorrer el array
    return evaluar_and(array)
```


### Complejidad

Si regla_conocida = True:

O(1) (constante) — no importa el tamaño del array

Si no hay regla, cae al modo tradicional

O(n) en el peor caso


---

### Ventaja práctica

Cuando el array es enorme (millones de elementos), este cambio puede ahorrar muchísimo tiempo, especialmente si se aplica en entornos en tiempo real o sistemas críticos

---


```python

def evaluar_and(array):
    for val in array:
        if not val:
            return False
    return True

def evaluar_or(array):
    for val in array:
        if val:
            return True
    return False

def inferir_and(array, regla_conocida=False):
    if regla_conocida:
        # Sabemos que todos son True
        return True
    else:
        return evaluar_and(array)

def inferir_or(array, hay_al_menos_un_true=False):
    if hay_al_menos_un_true:
        return True
    else:
        return evaluar_or(array)

#Simulación
import random

#Creamos un array grande
array = [True] * 10_000_000

#array = [random.choice([True, False]) for _ in range(10_000_000)]  #Alternativo usando random

#Evaluación directa
print("AND tradicional:", evaluar_and(array))

#Evaluación por inferencia (sin recorrer el array)
print("AND inferido:", inferir_and(array, regla_conocida=True))

```
