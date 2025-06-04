# Expresiones regulares

Una expresión regular es una cadena de texto que define un patrón para buscar o manipular texto

## ¿Para qué sirve?

### Se usa para

- `Buscar` cadenas que coincidan con un patrón

- `Validar` formatos (como correos, números, fechas)

-  `Extraer` partes específicas de texto

- `Reemplazar` texto que cumple cierto patrón

---

## Cuantificadores

- `*` -> 0 o más repeticiones

- `+` -> 1 o más repeticiones

- `?` -> 0 o 1 repetición

- `{n}` -> exactamente n veces

- `{n,}` -> al menos n veces

- `{n,m}` -> entre n y m veces

## Clases de caracteres

- `[abc]` -> cualquiera de a, b, c

- `[^abc]` -> cualquiera excepto a, b, c

- `[a-z]` -> cualquier letra minúscula

- `[0-9]` -> cualquier digito

- `[A-Za-z]` -> cualquier letra

## Metacaracteres especiales

- `.` -> cualquier carácter, menos salto de línea

- `\d` -> digito, equivalente a [0-9]

- `\D` -> no digito

- `\w` -> letra, número o guion bajo

- `\W` ->  cualquier otro caracter

- `\s` -> espacio, tab, salto de linea

- `\S` -> cualquier carácter no blanco

## Anclas de posición

- `^` -> inicio de la linea

- `$` -> fin de la linea

- `\b` -> limite de palabras

- `\B` -> no limite de palabra

## Agrupaciones y alternativas

- `(...)` -> agrupar subexpresiones

- `(?:...)` -> agrupación sin captura

- `\` ->  escapeo (no pertenece a este grupo)

---

Creado por Favio Joel Zalazar
