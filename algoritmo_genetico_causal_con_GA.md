# Algoritmo genetico causal con GA

### ¿Qué parte del algoritmo original unimos con el GA?

La idea original es usar una semilla que genera una frase, y luego ser capaz de recuperar la semilla desde la frase

### A eso le agregamos la idea de

Hacer que las frases evolucionen con el tiempo

Utilizar algoritmos genéticos para optimizar esas frases hacia una frase objetivo

Es decir, en vez de usar bits usar semilla pero utilizando este método/percepción atemporal

---

## Código

```python
import random
import time

#Palabras base y frase objetivo para fitness
palabras = ["luz", "oscura", "claridad", "noche", "día", "alma", "mente", "fuerza", "gravedad", "código", "llave", "tiempo"]
frase_objetivo = ["luz", "del", "alma", "gravedad", "mente"]

#Configuración GA
poblacion_inicial = 100
longitud_frase = len(frase_objetivo)
generaciones = 20
tasa_mutacion = 0.1
hijos_por_generacion = 100

#Función de fitness
def calcular_fitness(frase):
    score = 0
    for i, palabra in enumerate(frase):
        if i < len(frase_objetivo) and palabra == frase_objetivo[i]:
            score += 1
    return score

#Generar una frase aleatoria
def generar_frase():
    return [random.choice(palabras) for _ in range(longitud_frase)]

#Mutar una frase
def mutar(frase):
    return [
        random.choice(palabras) if random.random() < tasa_mutacion else palabra
        for palabra in frase
    ]

#Cruzar dos frases
def cruzar(padre, madre):
    punto = random.randint(1, longitud_frase - 1)
    hijo = padre[:punto] + madre[punto:]
    return mutar(hijo)

#Inicializar población
poblacion = [generar_frase() for _ in range(poblacion_inicial)]

#Evolución GA
mejor_fitness = 0
mejor_frase = []
fitness_promedio = []

inicio = time.time()
for generacion in range(generaciones):
    poblacion = sorted(poblacion, key=lambda x: calcular_fitness(x), reverse=True)
    mejores = poblacion[:10]  # Seleccionamos top 10

    nueva_generacion = []
    while len(nueva_generacion) < hijos_por_generacion:
        padre, madre = random.sample(mejores, 2)
        hijo = cruzar(padre, madre)
        nueva_generacion.append(hijo)

    poblacion = nueva_generacion

    mejor_fitness = calcular_fitness(poblacion[0])
    mejor_frase = poblacion[0]
    promedio = sum(calcular_fitness(f) for f in poblacion) / len(poblacion)
    fitness_promedio.append(promedio)

fin = time.time()

(mejor_frase, mejor_fitness, fitness_promedio, fin - inicio)
```
---

Creado por Favio Joel Zalazar