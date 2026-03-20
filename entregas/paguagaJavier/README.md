# Reto 004

## Vista pública de clases y objetos, vista privada de clases

Diseñe e implemente la clase Fraccion. Esta debe permtitir las operaciones básicas, métodos de comparación, utilidades como inversa y opuesta... lo habitual de clases Java (toString, clone, conversión a decimal).

Es decir, todo lo que considere necesario para trabajar con fracciones de forma completa.

### Ayuda

Algoritmo de Euclides para el cálculo del máximo común divisor

```java
int calcularMCD(int a, int b) {
    while (b != 0) {
        int temporal = b;
        b = a % b;
        a = temporal;
    }
    return a;
}
```

### Pasos

1. Crear Cliente.java y Fraccion.java y añadir los metodos planeados

2. Escribir el codigo dentro de todos los metodos de Fraccion.java

3. Añadir el codigo de Cliente.java y no olvidar el conversion a decimal en Fraccion.java

4. Reescribir algunas lineas de forma correcta o más eficaz


