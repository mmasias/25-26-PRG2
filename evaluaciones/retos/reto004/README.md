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

## 


<div align=center>

||||
|-|-|-|
|¡Revise la teoría!|22|>50%
|Mal construido|22|>50%
|Ruta o nombre de archivo incorrecto |16|40%
|Proceso de creación inexistente     |14|34%
|👍!                                 |2|5%
|🤔?                                 |1|2%

</div>
