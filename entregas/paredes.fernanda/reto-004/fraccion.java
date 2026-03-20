package vistas.fraccion;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0;
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    public Fraccion(int numero) {
        this(numero, 1);
    }

    public Fraccion(Fraccion fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion clonar() {
        return new Fraccion(this);
    }

    public void sumar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        this.simplificar();
    }

    public void restar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        this.simplificar();
    }

    public void multiplicar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.numerador;
        this.denominador = this.denominador * fraccion.denominador;
        this.simplificar();
    }

    public void dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0;
        this.numerador = this.numerador * fraccion.denominador;
        this.denominador = this.denominador * fraccion.numerador;
        this.simplificar();
    }

    public boolean esMayor(Fraccion fraccion) {
        return (double) this.numerador / this.denominador > (double) fraccion.numerador / fraccion.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return (double) this.numerador / this.denominador < (double) fraccion.numerador / fraccion.denominador;
    }

    public boolean equals(Fraccion fraccion) {
        return this.numerador == fraccion.numerador && 
               this.denominador == fraccion.denominador;
    }

    @Override
    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        }
        return numerador + "/" + denominador;
    }

    public void invertir() {
        assert numerador != 0;
        int temporal = numerador;
        numerador = denominador;
        denominador = temporal;
        this.simplificar();
    }

    public void oponer() {
        numerador = -numerador;
    }

    private int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private void simplificar() {
        int mcd = this.calcularMCD(numerador, denominador);
        numerador = numerador / mcd;
        denominador = denominador / mcd;
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }
}