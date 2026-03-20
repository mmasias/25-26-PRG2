Primero anotando un poco lo que puede realizar una fracción tomando base de los métodos de instancia discutidos en clase tenemos:
* Sus constructores (Se pueden iniciar con: un numerador y un denominador; solo un número directo; con un objeto fracción o con ninguno de estos)
* Operaciones aritméticas básicas (sumar, restar, multiplicar, dividir)
* Operaciones de comparación
* Modificadores (oponer e invertir)
* Mostrar

Esto significa que la vista privada consta de de un numerador y un denominador. Pense también adecuado incluir un atributo número pero para simplificar el codigo, solo mantuve el denominador y numerador.

La aplicación constara de una aplicación sencilla que muestre las capacidades de este intervalo.

Nota: El denominado, el numerador y el número estan constituidos por enteros pero considero que también seria valido el realizar una propuesta donde estos sean doubles. Para este reto los mantendre como enteros.

Tomando en cuenta los recursos dados por el reto:
Algoritmo de Euclides para el cálculo del máximo común divisor

```
int calcularMCD(int a, int b) {
    while (b != 0) {
        int temporal = b;
        b = a % b;
        a = temporal;
    }
    return a;
}
```