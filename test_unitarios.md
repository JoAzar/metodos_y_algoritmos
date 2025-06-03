# Test unitarios

Son actividades tendientes a testear automáticamente unidades individuales de código fuente para determinar si funcionan correctamente

## El testing unitario

- No puede garantizar que no haya errores pero proporciona cierto nivel de seguridad sobre el código

- Permite encontrar muchos errores antes de que el código se integre al resto del sistema

- Son creados por los programadores al momento de escribir el código de negocio

---

# JUnit

Existen varios paquetes de test unitarios para cada entorno de desarrollo. En java el más popular es JUnit

*Cada vez que se escribe una clase se agrega un test de la misma con el mismo nombre agregando la palabra "test", ej Class PersonaTest*

```java
Class PersonaTest {
	@Test
	Public void cumplirAniosTest() {
		Persona p = new Persona("Pepe", 18);
		p.cumplirAnios();
		assertEquals(19,p.obtenerEdad());
	}
}
```

En este caso de test verifica que una persona creada con 18 años debe tener 19 luego de llamar al método obtenerEdad()

---

# Assertions

Se utilizan assertions para testear condiciones que se deben cumplir durante la ejecución de los test unitarios

### Ej
 
```java
//verifica la igualdad entre dos variables
assertEquals(respuesta_esperada, ingreso_actual);

//verifica la igualdad entre dos arrays
aasertArrayEquals(respuesta_esperada, ingreso_actual);

//verifica que la condición sea verdadera
assertTrue(condición);

//verifica que la condición sea falsa
assertFalse(condición);

//verifica que la referencia sea null
assertNull(objeto);

//verifica que la referencia no sea null
assertNotNull(objeto);
```

---

# Annotations

*Se pueden aplicar las siguientes notaciones a los métodos de la clase test*

### @Test identifica a un método test

### @Before se ejecuta este método antes de cada test, habitualmente para inicializar los testo establecer una conexión con la base de datos

### @After se ejecutaeste método después de los test, habitualmente para cerrar conexiones restaurar valores originarios

### @Ignore no ejecuta el método test, se usa para ignorar/omitir el test

### @Test(expected=Exception.class) falla si no lanza la exception dicha

### @Test(timeout=100) falla si el método no se ejecuta dentro del limite de tiempo especificado (en milisegundos)

---

# Beneficios del test unitario

- Si se testea toda la funcionalidad relevante entonces es posible tener cierto grado de certeza de que la implementación es correcta

- Los test proporcionan un entorno aislado para testear cada parte distinta de la funcionalidad del sistema

- Es importante que cada test apunte a una parte distinta de la funcionalidad. Así es más fácil aislar un problema en función de los test que fallan

- Los test no tienen que ser repetitivos, para no tener que modificar demasiados test si cambia la interfaz o la funcionalidad

- Al diseñar el código para ser testeado la calidad del diseño mejora sustancialmente

- Una suite de test completa permite ganar confianza en el código permitiendo refactorizaciones frecuentes

---

# Limitaciones del testing unitario

*El testing unitario no garantiza la ausencia de errores*

*Requiere de revisión permanente para evitar que los test queden desactualizados o resulten ineficientes a medida que la funcionalidad del sistema aumente*

*Puede ser costoso/complicado definir test ortogonales y desacoplados entre si, de modo tal que cada caso de test apunte a una funcionalidad específica y distinta del resto*

*El testing unitario no permite encontrar errores derivados de la integración entre módulosm dado que cada módulo se testea por separado*

`ES IMPORTANTE TESTEAR CASOS BORDE`

---

# Técnicas de testing

- Testear las excepciones

- Testear el happy path

- Testear los casos borde

`NO SE DEBEN REPETIR LOS TEST`

---

# Tecnicas de testing

- Test first development (TFD): Escribir todos los casos de test antes de implementar los métodos. El objetivo es pensar qué se debe hacer antes de hacerlo

- Test driven development (TDD): Escribir los casos de test individual antes de su implementación y a continuación implementarlo

- Tres leyes de TDD: no se debe escribir código en producción sin tener antes un test, que falla para ese código,  no se debe escribir más que un test unitario que falla

---

# Consejos

- Visualizar el testing unitario como una disciplina asociada con las actividades de desarrollo de software

- Escribir un caso de test para cada elemento individual de funcionalidad

- Setear un entorno limpio de cada test. No es bueno que un test falle porque un test previo dejó datos inconsistentes

- Usar objetos falsos para no actuar sobre datos importantes

- Agregar nuevos test cuando se modifica la funcionalidad

- Escribir test antes de corregir un bug. Es una forma de asegurarse que el bug se corrigió y también permite detectar si el bug reaparece

---

# Ejercicios de testing unitarios

1- ¿Qué es un test unitario? ¿Qué ventajas tiene la escritura de test unitarios? ¿qué limitaciones tiene la tecnica de testing unitario?

- El test unitario es una prueba que se centraa en verificar el comportamiento de una unidad espefica de código

- Las ventajas son: ofrecer mejorar la calidad del código, facilitar el mantenimiento y agilizar el proceso de desarrollo. También se puede considerar una documentación automática

- Las limitaciones son que no prueba la integración del sistema, no verifica cómo interactuan entre si los métodos

- Dificultad para comprobar código dependiente de estados externos, ej bases de datos

- No detecta errores en la interacción del usuario

- No garantiza la cobertura total del código

- No detectan problemas de seguridad


2- ¿Qué son los casos borde? ¿Por qué es importante tener que cubrir los casos borde?

Los casos borde son situaciones extremas que podrían recurrir durante la ejecución de un programa pero que deben ser consideradas para garantizar la robustez y confiabilidad dek software

El proposito del mismo es probar/asegurar que el sistema se comporte correctamente incluso bajo condiciones extremas como entradas inusuales o límitadas de rangos y que no cause errores o fallos inesperados

### Tipos comunes de casos borde

*Valores extremos*

*Entradas vacías o nulas*

*Valores negativos*

*Valores máximos o mínimos*

*Valores fuera del rango esperado*

*Condiciones especiales no comunes*

3- ¿Qué annotation conoce para test unitarios?

*@Test*

*@Before*

*@After*

*@Ignore*

*@Test(Expected=Exception.class)*

*@Test(Timeout=100)*

4- ¿En qué contexto pueden ser útiles los métodos anotados con @Before y @After?

Before se puede utilizar para realizar configuraciones que sean comunes para cada uno de los métodos de prueba, ej inicializar objetos, crear un entorno predecible antes de cada test

After se utiliza para limpiar o liberar recursos después de cada prueba, se puede usar para asegurarse que no haya efectos secundarios entre test. Garantiza un entorno de pruebas limpio

---

Creado por Favio Joel Zalazar

