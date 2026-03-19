package entregas;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
    if (denominador == 0) {
        throw new IllegalArgumentException("El denominador no puede ser 0");
    }
    this.numerador = numerador;
    this.denominador = denominador;
    }
    
    public String toString() {
    return numerador + "/" + denominador;
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
    int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
    numerador /= mcd;
    denominador /= mcd;
    }

}
