## 🧠 Algoritmo de Karatsuba: Explicación Teórica

El **algoritmo de Karatsuba** es un método de multiplicación rápida que reduce la complejidad de multiplicar dos números grandes, en comparación con el método clásico de la escuela (también conocido como "multiplicación por columnas")
  
### 📉 Complejidad

- Multiplicación tradicional: \( O(n^2) \)
- **Karatsuba**: \( O(n^{\log_2 3}) aprox O(n^{1.585}) \)

Esto lo hace especialmente útil en sistemas que operan con grandes números enteros, como en criptografía o aritmética de precisión arbitraria.

---

### 🧩 Idea Central

Dado dos números grandes \( x \) y \( y \), los descomponemos en mitades:

\[
x = x_1 \cdot 10^m + x_0  
\]
\[
y = y_1 \cdot 10^m + y_0
\]

Donde:
- \( x_1 \) y \( y_1 \) son las mitades superiores
- \( x_0 \) y \( y_0 \) son las mitades inferiores
- \( m \) es la mitad del número de dígitos de los números originales

---

### 🔍 Multiplicación tradicional

Normalmente, para multiplicar \( x \cdot y \), haríamos:

\[
xy = x_1 y_1 \cdot 10^{2m} + (x_1 y_0 + x_0 y_1) \cdot 10^m + x_0 y_0
\]

Esto requiere **4 multiplicaciones** grandes.

---

### ⚡ Optimización de Karatsuba

Karatsuba reduce las multiplicaciones a **solo 3** utilizando la siguiente observación:

1. \( z_0 = x_0 \cdot y_0 \)
2. \( z_2 = x_1 \cdot y_1 \)
3. \( z_1 = (x_0 + x_1)(y_0 + y_1) - z_0 - z_2 \)

Entonces:

\[
xy = z_2 \cdot 10^{2m} + z_1 \cdot 10^m + z_0
\]

Esto funciona porque el tercer término contiene toda la información cruzada entre los productos sin necesidad de calcular cada uno por separado.

---

### 🔁 Recursividad

Este proceso se aplica de forma **recursiva**, dividiendo los números hasta que sean lo suficientemente pequeños como para multiplicarse directamente.

---

### 📌 Aplicaciones

- Algoritmos de multiplicación en sistemas simbólicos como SymPy, Mathematica, etc.
- Algoritmos criptográficos (RSA, curvas elípticas)
- Multiplicación de enteros grandes (big integers)

---

### 🧠 Conclusión

Karatsuba es uno de los primeros algoritmos divide y vencerás que revolucionó el cálculo de multiplicaciones grandes. Si bien no siempre es más rápido para números pequeños, **se vuelve notablemente más eficiente a medida que el tamaño crece**.

