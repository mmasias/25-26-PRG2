# Proyecto: Implementación de la Clase Fraccion en Java

Biblioteca para poder hacer de fracciones matemáticas, los principios de encapsulamiento dados en clase  La clase permite realizar operaciones esta siempre que los resultados estén simplificados.

---

## Estructura y Diseño de la Clase

La arquitectura se divide en dos capas 

### 1. Vista Privada (Estado y Lógica Interna)
* Atributos: Se definen como private y final quito el main por qu evi que fue inecesaario . Esto asegura que la fracción sea inmutable.
* MCD : Método private encargado de la lógica de simplificación. que usted nos dio apoya 

### 2. Vista Pública (Interfaz de Programación)
* Constructores:
    * Permiten  de fracciones estándar o null (0/1).
    * Validación: El constructor impide la creación de denominadores iguales a cero.
    * Normalización: El signo negativo se mantiene siempre en el numerador y la fracción se simplifica automáticamente.
* Operaciones Aritméticas: Gracias que usamos lo smetodos  para sumar, restar, multiplicar y dividir,nos ayuda ya qu ecada operacion nos devuel e una fraccion
* Utilidad: Con los metodos nos ayuda para  métodos para obtener la inversa, la opuesta y l esta nos ayuda a que a conversión a decimal (toDouble).

---

## Ejemplo

```java
Fraccion f1 = new Fraccion(1, 2);
Fraccion f2 = new Fraccion(1, 4);
Fraccion resultado = f1.sumar(f2);
