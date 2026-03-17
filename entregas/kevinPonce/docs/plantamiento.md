# Clase `Fraccion`

## Vista pública

### Constructores

* `Fraccion()`
  Constructor por defecto (inicializa a 0/1)

* `Fraccion(int numerador, int denominador)`
  Constructor con numerador y denominador

* `Fraccion(int numerador)`
  Constructor que asume denominador = 1

* `Fraccion(Fraccion otra)`
  Constructor copia

---

### Métodos clave

* `String toString()`
  Devuelve la representación en texto de la fracción

* `double toDecimal()`
  Convierte la fracción a número decimal

* `int calcularMCD(int a, int b)`
  Calcula el máximo común divisor

* `Fraccion clonar()`
  Devuelve una copia de la fracción

* `boolean esIgual(Fraccion fraccion)`
  Compara si dos fracciones son equivalentes

---

### Operaciones aritméticas

* `Fraccion sumar(Fraccion fraccion)`
  Suma dos fracciones

* `Fraccion restar(Fraccion fraccion)`
  Resta dos fracciones

* `Fraccion multiplicar(Fraccion fraccion)`
  Multiplica dos fracciones

* `Fraccion dividir(Fraccion fraccion)`
  Divide dos fracciones

---

### Métodos especiales

* `double inversa()`
  Devuelve el valor decimal de la fracción inversa

* `Fraccion opuesta()`
  Devuelve la fracción opuesta (cambia el signo)

* `boolean esPropia()`
  Indica si la fracción es propia (numerador < denominador)

## Vista privada

### Atributos

* `int numerador`
  Representa el numerador de la fracción

* `int denominador`
  Representa el denominador de la fracción (no puede ser 0)

---

### Métodos auxiliares (privados)

* `void validarDenominador(int denominador)`
  Verifica que el denominador no sea cero

* `void normalizarSigno()`
  Asegura que el signo quede siempre en el numerador

* `int calcularMCD(int a, int b)`
  Calcula el máximo común divisor (algoritmo de Euclides)

* `int calcularMCM(int a, int b)`
  Calcula el mínimo común múltiplo

* `void simplificar()`
  Reduce la fracción a su forma irreducible

* `Fraccion crearSimplificada(int numerador, int denominador)`
  Crea una nueva fracción ya simplificada

* `boolean esDenominadorValido(int denominador)`
  Devuelve si el denominador es válido

---

### Notas de diseño

* La clase siempre debe mantener las fracciones **simplificadas internamente**
* El denominador debe ser siempre **positivo**
* Las operaciones aritméticas deben devolver **nuevas instancias** (inmutabilidad)
* se debe usar el asert para verificar entradas y no if
* se debe asumir validaciones compeljas al son para el cliente
* se debe usar el constructor primario this(params) en los constuctores segundarios
---