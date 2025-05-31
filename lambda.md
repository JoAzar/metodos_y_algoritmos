# ¿Qué es Lambda?

Es una forma de escribir métodos/funciones de manera anónima muy compacta y sin nombre

Se suele útilizar para funciones/métodos cortas que sólo se van a usar una vez, ejemplo: map(), sorted(), filter()

---

## Ejemplo

`lambda argumentos: expresión`

---

## Comparación entre función normal vs lambda

```python
#FUNCION COMUN
def sumar(x, y):
    return x + y

#LAMBDA
sumar = lambda x, y: x + y
print(sumar(2, 3))
```
---

Creado por Favio Joel Zalazar


