# Árboles de Expresiones Booleanas con Path Compression

## Idea Principal

Combinar técnicas de **path compression** (de estructuras tipo union-find) con **evaluación lógica** de árboles de expresiones booleanas (compuestos por `AND`, `OR`, `V`, `F`) para optimizar la evaluación del árbol completo y futuras consultas.

---

## Componentes del Árbol

Cada nodo puede contener:

- Un operador: `AND`, `OR`
- Dos hijos (otros nodos o literales)
- Un valor cacheado: `V`, `F` o `null` si no fue evaluado
- Un puntero a su “nodo representante evaluado” (como en union-find)

---

## Algoritmo de Evaluación con Path Compression

### Evaluación estándar con short-circuit
- `AND(V, X)` → depende de `X`
- `AND(F, X)` → resultado directo: `F`
- `OR(V, X)` → resultado directo: `V`
- `OR(F, X)` → depende de `X`

### Guardar el resultado
- Una vez evaluado, se **cachea** el valor (`V` o `F`) en el nodo.

### Path compression
- Se hace que el nodo apunte a su resultado o subárbol ya evaluado.
- Las futuras consultas simplemente siguen el puntero, logrando tiempos cercanos a **O(1)** amortizado.

---

## Ejemplo Visual

```text
         AND
        /    \
      OR      F
     /  \
    V    F
```

OR(V, F) → V (memoizado, path compressed)

AND(V, F) → F (memoizado, path compressed)

Futuras consultas al nodo raíz → se devuelven instantáneamente


---

### Posibles Implementaciones Prácticas

- Motores de reglas lógicas o validadores condicionales

- Interpretadores de lenguajes lógicos

- Sistemas expertos o árboles de decisión

- Evaluadores de lógica simbólica en compiladores

- Optimización de filtros y condiciones en bases de datos

- Simulación de circuitos lógicos

- Sistemas de IA simbólica donde el razonamiento se puede representar como árboles lógicos

---

### Nota Final

Esta estructura se vuelve especialmente poderosa en escenarios con múltiples consultas o cambios dinámicos sobre el árbol, donde evaluar desde cero sería costoso


```python

# Árbol:
#         AND
#        /    \
#      OR      F
#     /  \
#    V    F

v = Nodo('VAL', valor='V')
f = Nodo('VAL', valor='F')
or_node = Nodo('OR', v, f)
raiz = Nodo('AND', or_node, f)

print("Resultado:", raiz.evaluar())  # Resultado: F
print("Path Compression aplicado:", raiz.padre.valor)  # Debería decir F

```