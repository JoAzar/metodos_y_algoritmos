#Stream (Java)

La interfaz Stream de Java, introducida en Java 8, sirve para procesar secuencias de datos de forma funcional y declarativa

Permite operar sobre colecciones (como listas, conjuntos, etc.) de manera eficiente, expresiva y, en muchos casos, paralela

- Un stream proporciona acceso secuencial a los objetos que son obtenidos o computados por demanda. Un stream no almacena los objetos de la secuencia

- El origen de los datos del stream puede ser una colección, un arreglo, dispositivos de entrada/salida, o un cálculo iterativo

- La mayoría de las operaciones sobre streams retorna el mismo stream como resultado, y entonces se pueden concatenar operaciones

---

## Ejemplos

### Stream vacío

```java
Stream<String> StringVacío = Stream.empty();
```

### Stream a partir de una colection

```java
ArrayList<String> lista = new ArrayList<String>();
lista.add(...);
Stream<String> streamDeLista = lista.stream();
```

### Stream a partir de un array

```java
String[] array = new String []{'a','b','c'};
Stream<String> streamDeArray = Arrays.stream(array);
```

### Stream con valores calculados (hay que establecer un límite, en este caso es 20)

```java
Stream<Integer> streamIterated = Stream.iterate(40, n -> n+2).limit(20);
```

### Stream con valores númericos

```java
IntStream intStream = IntStream.range(1,3); //no incluye el 3
LongStream longStream = LongStream.rangeClosed(1,3); //incluye el 3
```

### Stream con todas las filas de un archivo

```java
Path ruta = Paths.get("C:\\file.txt");
Stream<String> streamOfString = File.lines(ruta);
```

---

## Operaciones intermedias sobre string

Se tienen operaciones intermedias sobre streams que operan con el stream y retornan una referencia al mismo stream para concatenar con otras operaciones

Se tienen además operaciones terminales, que no retornan una referencia al stream. Una vez aplicada una operación terminal, el stream no se puede volver a usar

```java
Stream<String> stream = Stream.of(”aa”, ”ab”, ”cb”).ﬁlter(e −> e.contains(”b”));
Optional<String> elemento = stream.ﬁndFirst();
Optional<String> elemento = stream.ﬁndFirst(); //Error, no se puede llamar dos veces
```

---

# Métodos de stream

```java
//.map() aplica un método a cada elemento del stream y retorna un nuevo stream con los resultados
IntStream.range(1, 10).map(x −> 2∗x);

//.filter() retorna un stream con los elementos que cumplen la condición especiﬁcada
IntStream.range(1, 10).ﬁlter(x −> x%2 == 0);

//.skip(n) saltea los n primeros elementos
IntStream.range(1, 10).skip(3);

//.limit(n) obtiene los n primeros elementos
IntStream.range(1, 10).skip(3).limit(4);

//.forEach() aplica un m´etodo a cada elemento del stream
IntStream.range(1, 10).limit(3).forEach(System.out::println);

//.count() retorna la cantidad de elementos del stream
long cant = IntStream.range(1, 10).ﬁlter(x −> x%2 == 0).count();

//.sum(), .min(), .max() y .average(), sobre streams numéricos
IntStream.range(1, 10).sum();
IntStream.range(1, 10).min();
IntStream.range(1, 10).max();
IntStream.range(1, 10).average();
```

## Convertir el stream a un stream numéric (mapToInt/mapToDouble)

```java
ArrayList<Empleado> empleados = new ArrayList<Empleado>();
//etc
double tot = empleados.stream().ﬁlter(e −> e.getAntiguedad() > 2);
mapToDouble(Empleado::getSueldo).sum();
```
---

## Cierre de stream

*El mecanismo habitual sobre streams es aplicar una operación terminal como última operación sobre el stream*

- Si no se hace esto, entonces es necesario cerrar el stream, por medio de la operación close()

- Si no se cierra un stream, entonces el stream queda abierto y ocupa memoria durante toda la ejecución del programa
