# Fragmented Prime Graph Cipher (FPGC)

**Autor:** Favio Joel Zalazar (Red)  
**Versión:** 1.0  
**Fecha:** 2025-05-12  

---

## Introducción

*Fragmented Prime Graph Cipher (FPGC)* es un algoritmo experimental de cifrado basado en grafos, donde cada nodo contiene valores primos y fragmentos cifrados de una clave. El algoritmo utiliza la aleatoriedad de los primos, la fragmentación de caracteres y una estructura de grafo dirigida para ocultar la información, garantizando que solo quien conoce el camino y los métodos de reconstrucción pueda recuperar la clave original.

---

## Fundamentos

El algoritmo combina tres pilares:

1. **Fragmentación**: los caracteres de la clave se dividen en múltiples partes.
2. **Distribución**: estas partes se asignan a nodos del grafo de forma aleatoria.
3. **Primos como portadores**: cada nodo contiene un número primo y actúa como una unidad de cifrado.
4. **Camino de reconstrucción**: el grafo define un camino secuencial que permite rearmar la clave en orden.

---

## Estructura del Grafo

- Cada **nodo** contiene:
  - Un número primo aleatorio `P`.
  - Un fragmento cifrado del carácter original.
  - Un identificador único.

- Los **edges** (aristas) conectan los nodos en un orden determinado, el cual actúa como clave secreta para la reconstrucción.

---

## Algoritmo General

### 1. Inicialización

- Generar una lista de `N` nodos.
- Asignar a cada nodo un número primo único tomado de una lista de primos predefinidos (por ejemplo, los primeros 100 primos).

### 2. Fragmentación de la Clave

Para cada carácter `C` en la clave original:
- Obtener su valor ASCII: `V`.
- Generar una **máscara aleatoria** `M` (por ejemplo, otro primo).
- Calcular fragmentos, por ejemplo:
  ```text
  F1 = V XOR M
  F2 = M

---

## Construcción del Grafo

Conectar los nodos con un patrón (puede ser aleatorio, circular, en estrella o por prioridad).

Registrar el camino correcto de reconstrucción.


## Encriptación

El grafo completo actúa como el bloque cifrado. Cada nodo oculta una parte del mensaje dentro de un primo.

## Desencriptación

Para reconstruir la clave:

Seguir el camino predefinido del grafo.

En cada nodo:

Extraer los fragmentos.

Revertir la operación (por ejemplo, F1 XOR F2).


Unir los caracteres reconstruidos.



---

# Ejemplo Simplificado

Clave: R
ASCII de R: 82
Máscara aleatoria M: 7
Fragmentos:

F1 = 82 XOR 7 = 85  
F2 = 7

Asignación:

Nodo A: Primo = 13, Valor = 85

Nodo B: Primo = 17, Valor = 7


Reconstrucción:

85 XOR 7 = 82 → 'R'


---

## Seguridad y Ventajas

Ofuscación distribuida: un atacante necesita el grafo entero y conocer el método de fragmentación para reconstruir.

Primos aleatorios: agregan entropía y no repiten patrón.

Grafo como llave secreta: incluso con todos los datos, sin el camino correcto no se puede reconstruir la clave.

Modularidad: se pueden implementar versiones más fuertes con más capas de fragmentación.



---
