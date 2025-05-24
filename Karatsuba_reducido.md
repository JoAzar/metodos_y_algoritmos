# Optimización de la Multiplicación con Karatsuba y Reducción por MCD

El algoritmo de Karatsuba es una técnica eficiente para multiplicar números grandes usando el paradigma "divide y vencerás". En esta propuesta, combinamos Karatsuba con una optimización adicional: la reducción previa de los operandos mediante su **máximo común divisor (MCD)**

Esta combinación puede reducir la complejidad de la multiplicación en algunos casos, especialmente cuando los números involucrados tienen factores comunes significativos

---

## Fundamento Teórico

### Karatsuba Clásico

Dados dos números grandes

```
x = x1 * B + x0
y = y1 * B + y0
```

Karatsuba calcula

```
z2 = x1 * y1
z0 = x0 * y0
z1 = (x1 + x0) * (y1 + y0) - z2 - z0
```

Resultado final

```
res = z2 * B^2 + z1 * B + z0
```

---

### Reducción por MCD

Dado que `gcd(x, y) = d`, entonces

```
x = d * x'
y = d * y'
=> x * y = d^2 * (x' * y')
```

### Combinación de Estrategias

1. Calcular `d = gcd(x, y)`
2. Si `d > 1`, reducir ambos operandos

   ```
   x' = x / d
   y' = y / d
   ```
3. Aplicar Karatsuba sobre `x'` y `y'`
4. Multiplicar el resultado por `d^2`

   ```
   resultado_final = d^2 * karatsuba(x', y')
   ```

---

## Ejemplo

Multiplicación de 48 y 36:

* `gcd(48, 36) = 12`
* `x' = 4`, `y' = 3`
* `karatsuba(4, 3) = 12`
* Resultado final: `12^2 * 12 = 144 * 12 = 1728`

Sin la reducción, estarías multiplicando 48 \* 36 directamente, lo cual es más costoso

---

## Ventajas

* **Menor profundidad recursiva** en Karatsuba
* **Reduce la magnitud de los operandos**, mejorando el rendimiento
* **Evita overflow** al trabajar con números más pequeños

## Consideraciones

* No aporta beneficio si `gcd(x, y) = 1`
* Requiere aplicar correctamente `d^2` al final
* Aporta más cuando hay factores comunes grandes

---

## Conclusión

La reducción previa por MCD es una técnica válida y complementaria al algoritmo de Karatsuba, que puede mejorar la eficiencia en ciertos escenarios. Esta estrategia se inspira en patrones comunes en algoritmos eficientes como el de Euclides y abre la puerta a exploraciones más amplias en el campo de la multiplicación optimizada

Creado por Favio Joel Zalazar
