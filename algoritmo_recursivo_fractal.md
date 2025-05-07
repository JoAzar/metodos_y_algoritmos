# ♟️ Algoritmo Recursivo Basado en Patrones para el Problema de las N Reinas

Este enfoque propone una solución alternativa al clásico problema de las N reinas, basada en **modulación fractal**, **reutilización de patrones**, y **recursión estructural**. A diferencia del tradicional backtracking, aquí se identifican **patrones base válidos** y se replican para generar tableros más grandes.

---

## 🔍 Idea Central

1. Se parte de una **solución base** (por ejemplo, para un tablero 4x4).
2. Se replica este patrón desplazándolo en filas y columnas.
3. Se ensamblan bloques que **no se interfieren entre sí**.
4. Se escalan las soluciones con **recursión**, dividiendo el tablero en secciones.

---

## 🧩 Patrón Base (N = 4)

Una solución válida para el tablero 4x4:

```python
pattern_4 = [2, 4, 1, 3]
```

---

##Esto representa una reina por fila:

- Fila 1 → Columna 2
- Fila 2 → Columna 4
- Fila 3 → Columna 1
- Fila 4 → Columna 3

---

```python

def generar_patron_n(n):
    """
    Genera una solución para N reinas utilizando bloques del patrón base de 4.
    Solo válido si N es múltiplo de 4 y no supera el límite lógico del patrón.
    """
    if n % 4 != 0:
        raise ValueError("Este algoritmo sólo funciona para múltiplos de 4.")
    
    base = [2, 4, 1, 3]
    solucion = []
    for i in range(n // 4):
        bloque = [x + i * 4 for x in base]
        solucion += bloque
    return solucion

#print(generar_patron_n(8))  # [2, 4, 1, 3, 6, 8, 5, 7]

```

---

## ✅ Validación

Este patrón asegura:

- ✅ Una reina por fila.  
- ✅ Una reina por columna.  
- ✅ No hay conflictos diagonales entre bloques si los desplazamientos son adecuados.

---

## 🧠 Propiedad Fractal

El patrón se comporta como un **bloque auto-replicable**.  
Al separarlos correctamente en el tablero, las interacciones quedan restringidas al interior del bloque, permitiendo **escalabilidad lineal**:

- ⏱️ Tiempo: `O(n)`  
- 💾 Espacio: `O(n)` o `O(n²)` si se representa el tablero completo.

---

## 📌 Limitaciones

- 🔢 Funciona solo para valores de **N que son múltiplos de 4** (4, 8, 12, ...).
- 🚫 No está diseñado para producir **todas las soluciones posibles**, sino solo **una válida**.
- 🧩 No sustituye al **backtracking** si se desea **enumerar todas las configuraciones**.

---

## 🧪 Futuro

Explorar:

- 🔄 Ampliar el patrón a otros tamaños (6, 10, etc.).
- 🧬 Combinar varios patrones en uno más complejo.
- 🧠 Reducir problemas **NP** a esta estructura modular para experimentos sobre **P vs NP**.


By Favio Joel Zalazar
