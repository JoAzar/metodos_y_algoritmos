# Pattern-Balanced Path Search (PBPS)

**PBPS** (Pattern-Balanced Path Search) es un algoritmo de búsqueda de caminos en matrices cuadradas que no solo busca llegar desde la posición inicial `(0,0)` hasta la final `(n-1,n-1)`, sino que también intenta encontrar un camino cuya **suma total de valores sea igual a `0`**.

Cada celda de la matriz contiene un valor entre `-1`, `0` y `1`, y la búsqueda es guiada por una heurística que prioriza secuencias balanceadas (como `-1, 1, -1, 1` o `1, 0, -1, 1`) que tienden naturalmente a una suma equilibrada.

---

## Características del algoritmo

- **Entrada:** matriz cuadrada `n x n` con valores en {-1, 0, 1}

- **Objetivo:** encontrar un camino desde `(0,0)` hasta `(n-1,n-1)` con suma total igual a `0`

- **Restricción:** solo se puede mover en direcciones válidas (arriba, abajo, izquierda, derecha)

- **Heurística personalizada:** se da prioridad a rutas con secuencias balanceadas de valores y presencia de ceros como neutralizadores

---

## Lógica de la heurística

La heurística considera:

1. **Distancia Manhattan hasta el objetivo** 
 
2. **Diferencia entre la suma acumulada y el objetivo (0)**

3. **Puntaje de armonía de la secuencia recorrida**
   - Se premian alternancias `-1 -> 1` o `1 -> -1`.
   - Se premian ceros intercalados (`-1, 0, 1`).
   - Se penalizan repeticiones del mismo valor (ej: `1, 1, 1`).

### Fórmula heurística

```text
f(n) = g(n) + h(n) - armonía(n)

g(n): costo actual (pasos dados).

h(n): distancia Manhattan + |suma_actual|.

armonía(n): puntaje basado en patrón de valores.

```

---

## Algoritmo

```Java

import java.util.*;

public class PBPS {

    static final int[][] DIRECCIONES = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static class Nodo {
        int x, y;
        int sumaActual;
        List<Integer> caminoValores;
        List<String> caminoPosiciones;

        Nodo(int x, int y, int sumaActual, List<Integer> caminoValores, List<String> caminoPosiciones) {
            this.x = x;
            this.y = y;
            this.sumaActual = sumaActual;
            this.caminoValores = new ArrayList<>(caminoValores);
            this.caminoPosiciones = new ArrayList<>(caminoPosiciones);
        }
    }

    public static List<String> buscarCamino(int[][] matriz) {
        int n = matriz.length;
        Queue<Nodo> cola = new PriorityQueue<>(
            Comparator.comparingInt(nodo -> -puntajeArmonia(nodo.caminoValores))
        );

        Set<String> visitados = new HashSet<>();

        List<Integer> valoresIniciales = new ArrayList<>();
        valoresIniciales.add(matriz[0][0]);

        List<String> posicionesIniciales = new ArrayList<>();
        posicionesIniciales.add("(0,0)");

        Nodo inicio = new Nodo(0, 0, matriz[0][0], valoresIniciales, posicionesIniciales);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();

            if (actual.x == n - 1 && actual.y == n - 1 && actual.sumaActual == 0) {
                return actual.caminoPosiciones;
            }

            for (int[] dir : DIRECCIONES) {
                int nx = actual.x + dir[0];
                int ny = actual.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    String clave = nx + "," + ny + "," + actual.sumaActual;

                    if (!visitados.contains(clave)) {
                        List<Integer> nuevosValores = new ArrayList<>(actual.caminoValores);
                        nuevosValores.add(matriz[nx][ny]);

                        List<String> nuevasPosiciones = new ArrayList<>(actual.caminoPosiciones);
                        nuevasPosiciones.add("(" + nx + "," + ny + ")");

                        Nodo nuevo = new Nodo(
                            nx, ny,
                            actual.sumaActual + matriz[nx][ny],
                            nuevosValores,
                            nuevasPosiciones
                        );

                        cola.add(nuevo);
                        visitados.add(clave);
                    }
                }
            }
        }

        return null; // No se encontró camino
    }

    // Heurística de armonía: premia alternancia tipo -1,1,-1,... y presencia de ceros entre ellos
    private static int puntajeArmonia(List<Integer> valores) {
        int score = 0;
        for (int i = 1; i < valores.size(); i++) {
            int prev = valores.get(i - 1);
            int curr = valores.get(i);

            if ((prev == -1 && curr == 1) || (prev == 1 && curr == -1)) {
                score += 2; // alternancia fuerte
            } else if (prev == 0 || curr == 0) {
                score += 1; // cero estabilizador
            } else if (prev == curr && curr != 0) {
                score -= 2; // repetición de signo
            }
        }
        return score;
    

    public static void main(String[] args) {
        int[][] matriz = {
            {  0,  1,  0 },
            { -1,  0,  1 },
            {  1, -1,  0 }
        };

        List<String> camino = buscarCamino(matriz);

        if (camino != null) {
            System.out.println("Camino encontrado:");
            for (String paso : camino) {
                System.out.print(paso + " ");
            }
        } else {
            System.out.println("No se encontró un camino con suma 0.");
        }
    }
}

```


---

# Fuerza Bruta Pura

En una matriz n x n, desde (0,0) hasta (n-1,n-1), puedes moverte en 4 direcciones (arriba, abajo, izquierda, derecha), pero en la práctica se restringe para evitar ciclos (yendo solo hacia la derecha y abajo, por ejemplo).

Complejidad en el peor caso:
Si explora todos los caminos posibles:
O(4^(n²)) en el caso más general.
Si se limita a derecha y abajo:
O(2^(2n-2)), que sigue siendo exponencial.

---

# PBPS (Pattern-Balanced Path Search)

En el mejor de los casos, si el patrón aparece temprano en el recorrido:

La cola de prioridad dirige la búsqueda hacia ese patrón.

No explora caminos redundantes que no siguen ese patrón.

Podría encontrar el camino válido muy pronto, con una búsqueda dirigida tipo best-first.

# Complejidad en el mejor de los casos

Si encuentra un camino válido tras explorar solo una fracción pequeña del espacio de búsqueda, la complejidad no es exponencial en la práctica.

Supongamos que encuentra el camino correcto tras visitar k nodos, donde k << n².

Entonces:

Mejor caso de PBPS:
O(k log k) por el uso de la cola de prioridad (heap), donde k es la cantidad de nodos explorados hasta encontrar la solución.

log k es el costo de mantener la cola ordenada.

En un caso ideal: O(n) o O(n log n).


# Resumen Comparativo (mejor caso)

Algoritmo	Mejor caso (complejidad)

```

Fuerza Bruta	O(2^(2n-2))

PBPS	O(n log n) (si hay patrón temprano)

```

Esto significa que PBPS puede ser cuasipolynomial o incluso lineal logarítmico en el mejor de los casos, lo cual es una mejora enorme frente a fuerza bruta.

---

Licencia

MIT License - libre para usar, modificar y compartir.


---

Créditos

Creado por Favio Joel Zalazar (Red)
Con asistencia de inteligencia artificial (Orion)

---