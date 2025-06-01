# Test de algoritmos causales con semillas

```python
causal_seed.py

import random import hashlib

class NodoCausal: def init(self, semilla, padre=None): self.semilla = semilla self.frase = self.generar_frase(semilla) self.padre = padre

def generar_frase(self, semilla):
    random.seed(semilla)
    palabras = [
        "origen", "futuro", "conexión", "nodo", "decisión", "código", "eco",
        "verificación", "causa", "efecto", "rastro", "memoria", "tiempo",
        "gravedad", "semilla", "universo", "realidad", "ciclo", "clave", "despertar"
    ]
    return [random.choice(palabras) for _ in range(5)]

def reconstruir_semilla(self):
    #Fuerza bruta busca una semilla que genere esta misma frase
    palabras = [
        "origen", "futuro", "conexión", "nodo", "decisión", "código", "eco",
        "verificación", "causa", "efecto", "rastro", "memoria", "tiempo",
        "gravedad", "semilla", "universo", "realidad", "ciclo", "clave", "despertar"
    ]
    for semilla_posible in range(1000000):
        random.seed(semilla_posible)
        if [random.choice(palabras) for _ in range(5)] == self.frase:
            return semilla_posible
    return None

def obtener_raiz(self):
    if not self.padre:
        return self
    self.padre = self.padre.obtener_raiz()  # Path compression
    return self.padre

def serializar(self):
    return {
        "semilla": self.semilla,
        "frase": self.frase,
        "padre": self.padre.serializar() if self.padre else None
    }


if name == "main": abuelo = NodoCausal(999999) padre = NodoCausal(abuelo.reconstruir_semilla(), padre=abuelo) hijo = NodoCausal(padre.reconstruir_semilla(), padre=padre)

print("Frase del hijo:", hijo.frase)
print("Raíz reconstruida:", hijo.obtener_raiz().frase)

print("Árbol serializado:")
import json
print(json.dumps(hijo.serializar(), indent=2))
```

---

Creado por Favio Joel Zalazar
