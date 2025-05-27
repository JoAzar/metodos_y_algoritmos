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