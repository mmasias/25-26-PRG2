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
        numerador /= mcd;
        denominador /= mcd;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    public Fraccion sumar(Fraccion otra) {
        int num = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int den = this.denominador * otra.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion restar(Fraccion otra) {
        int num = this.numerador * otra.denominador - otra.numerador * this.denominador;
        int den = this.denominador * otra.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion multiplicar(Fraccion otra) {
        return new Fraccion(this.numerador * otra.numerador,
                            this.denominador * otra.denominador);
    }

    public Fraccion dividir(Fraccion otra) {
        return new Fraccion(this.numerador * otra.denominador,
                            this.denominador * otra.numerador);
    }

    public Fraccion inversa() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-numerador, denominador);
    }

    public boolean equals(Fraccion otra) {
        return this.numerador == otra.numerador &&
               this.denominador == otra.denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }
}