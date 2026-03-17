public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private void simplificar() {
        int mcd = calcularMCD(numerador, denominador);
        numerador = numerador / mcd;
        denominador = denominador / mcd;

        // Asegurar que el denominador sea positivo
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }
}