# Algoritmo Genético Causal (Versión Experimental)


## Idea en pseudocodigo
```python

[semilla inicial] → genera → [frase A] → fitness(frase A) = 0.8

→ [modificación de frase A] → genera semilla nueva → [frase B]

→ [path compression]: raíz ← B ← A

→ si B supera a A, se actualiza y comprime camino

→ Recursivamente evoluciona sobre frases causales
      
```

---

## Algoritmo Genético Causal (codigo)

```python

import random import hashlib

Vocabulario base (puede ser ampliado o parametrizable)

vocabulario = [ "agua", "fuego", "aire", "tierra", "luz", "sombra", "mente", "cuerpo", "espíritu", "alma", "tiempo", "espacio" ]

#Genera una frase desde una semilla (fenotipo)
def generar_frase(seed, largo=5): random.seed(seed) return [random.choice(vocabulario) for _ in range(largo)]

#Convierte una frase en un hash determinista (genotipo resumido)

def frase_a_hash(frase): return hashlib.sha256(" ".join(frase).encode()).hexdigest()

Fitness simple: más "armonía" si hay palabras complementarias

complementos = [ ("agua", "fuego"), ("aire", "tierra"), ("luz", "sombra"), ("mente", "cuerpo"), ("espíritu", "alma"), ("tiempo", "espacio") ]

def evaluar_fitness(frase): score = 0 for a, b in complementos: if a in frase and b in frase: score += 1 return score / len(complementos)

#Path compression para herencia causal
class Nodo: def init(self, seed, frase): self.seed = seed self.frase = frase self.fitness = evaluar_fitness(frase) self.padre = self  # path compression

def obtener_raiz(self):
    if self.padre != self:
        self.padre = self.padre.obtener_raiz()
    return self.padre

def unir(self, otro):
    raiz1 = self.obtener_raiz()
    raiz2 = otro.obtener_raiz()
    if raiz1 != raiz2:
        if raiz1.fitness >= raiz2.fitness:
            raiz2.padre = raiz1
        else:
            raiz1.padre = raiz2

#Generador evolutivo causal
def evolucionar_generacion(poblacion, generaciones): historial = [] for gen in range(generaciones): nueva_gen = [] for nodo in poblacion: nueva_seed = frase_a_hash(nodo.frase)[:8] + str(random.randint(0, 1000)) nueva_frase = generar_frase(nueva_seed) hijo = Nodo(nueva_seed, nueva_frase) hijo.unir(nodo) nueva_gen.append(hijo) poblacion = nueva_gen historial.append(poblacion) return historial

#Inicialización
def main(): semillas_iniciales = ["origen1", "origen2", "origen3"] poblacion = [Nodo(seed, generar_frase(seed)) for seed in semillas_iniciales]

generaciones = evolucionar_generacion(poblacion, 5)

#Mostrar evolución
for i, gen in enumerate(generaciones):
    print(f"\nGeneración {i+1}:")
    for nodo in gen:
        origen = nodo.obtener_raiz()
        print(f"Frase: {' '.join(nodo.frase)} | Fitness: {nodo.fitness:.2f} | Origen: {origen.seed}")

if name == "main": main()
```

---

# 🧠 Algoritmo Genético Causal — Explicación

Este experimento simula un sistema evolutivo con trazabilidad causal, donde las generaciones se desarrollan a partir de semillas iniciales. A diferencia de los algoritmos genéticos clásicos, este mantiene una relación de herencia explícita y reversible entre cada nodo e individuo

## Componentes Clave

Semilla (seed): cadena de texto que actúa como fuente de aleatoriedad. Representa el "ADN" inicial de un nodo

Frase (frase): secuencia generada desde la semilla usando un vocabulario predeterminado. Equivale al fenotipo

Fitness: se calcula en base a la presencia de pares de palabras complementarias. Cuanto más armónica la frase, mayor el fitness

Nodo: objeto que encapsula una semilla, su frase, su fitness y un puntero causal (padre)

Path Compression: técnica inspirada en algoritmos de conjuntos disjuntos. Optimiza la búsqueda del ancestro común de un nodo, permitiendo que cada frase evolutiva rastree su origen

---

## Flujo Evolutivo

1. Se crean nodos iniciales con semillas base


2. Cada generación muta frases anteriores creando nuevas semillas derivadas del hash de la frase


3. Se evalúa el fitness de cada nueva frase


4. Se establece una conexión causal con su nodo padre


5. Se repite por N generaciones, manteniendo un historial completo

---

Creado por Favio Joel Zalazar
