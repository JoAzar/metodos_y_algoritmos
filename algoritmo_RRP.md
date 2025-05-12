# Red Race Pathfinding (RRP)

**Red Race Pathfinding (RRP)** es un algoritmo de búsqueda de caminos en grafos, diseñado por Favio Joel Zalazar, que combina expansión no heurística, análisis bifocal y condiciones de carrera adaptativas. A diferencia de los algoritmos tradicionales como Dijkstra o A*, RRP permite que múltiples trayectorias compitan dinámicamente, ajustándose en tiempo real si una ruta mejor aparece.

---

## Características clave

- **Expansión máxima inicial:** comienza desde un nodo cualquiera buscando el nodo más lejano, sin considerar costos mínimos.
- **Exploración bifocal simultánea:** se inicia una expansión desde el nodo original y otra desde el nodo más lejano alcanzado.
- **Comparación de vecinos:** ambos extremos analizan vecinos y sus pesos para evaluar posibles rutas más eficientes.
- **Condición de carrera controlada:** si un nodo en proceso recibe una visita con mejor costo, la ruta se “pisa” y se adapta dinámicamente.
- **Construcción reactiva de rutas:** los caminos se ajustan en función de las decisiones tomadas durante la ejecución, no antes.

---

## Etapas del algoritmo

1. **Inicio aleatorio o definido:** seleccionar un nodo inicial arbitrario.
2. **Expansión profunda:** buscar el nodo más lejano sin importar los pesos (máxima distancia topológica).
3. **Lanzamiento bifocal:** iniciar dos exploraciones paralelas desde el nodo inicial y el más lejano.
4. **Lectura de vecinos:** ambos extremos leen sus vecinos y almacenan sus pesos.
5. **Comparación cruzada:** se comparan los pesos de los vecinos descubiertos para detectar rutas más económicas.
6. **Reconfiguración dinámica:** si se detectan rutas con mejor peso, se genera un nuevo camino que “pisa” la ruta actual.
7. **Propagación competitiva:** los caminos compiten por los nodos en tiempo real, actualizando los estados según la mejor opción.
8. **Finalización:** cuando no se pueden generar rutas más eficientes, se determina la mejor ruta trazada.

---

## Posibles aplicaciones

- Inteligencia artificial en videojuegos.
- Sistemas de rutas con condiciones cambiantes (tráfico, redes).
- Simulaciones multiagente con competencia adaptativa.
- Exploración de entornos impredecibles o dinámicos.

---

## Estado del proyecto

> Actualmente en fase de diseño conceptual. Próximamente se implementará una versión en Python usando NetworkX u otra librería para visualización y pruebas.

---

## Licencia

> Este algoritmo fue ideado por Favio Joel Zalazar (Red). Si lo usás, mencioná la fuente o compartí tus mejoras con la comunidad.