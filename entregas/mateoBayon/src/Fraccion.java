public class Fraccion implements Cloneable, Comparable<Fraccion> {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public int getNumerador() { return numerador; }
    public int getDenominador() { return denominador; }

    private int mcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void simplificar() {
        int mcd = mcd(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;

        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }
    }

        public Fraccion sumar(Fraccion f) {
        return new Fraccion(
            this.numerador * f.denominador + f.numerador * this.denominador,
            this.denominador * f.denominador
        );
    }

    public Fraccion restar(Fraccion f) {
        return new Fraccion(
            this.numerador * f.denominador - f.numerador * this.denominador,
            this.denominador * f.denominador
        );
    }

    public Fraccion multiplicar(Fraccion f) {
        return new Fraccion(
            this.numerador * f.numerador,
            this.denominador * f.denominador
        );
    }

    public Fraccion dividir(Fraccion f) {
        if (f.numerador == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return new Fraccion(
            this.numerador * f.denominador,
            this.denominador * f.numerador
        );
    }

    public Fraccion inversa() {
        if (numerador == 0) {
            throw new ArithmeticException("La fracción 0 no tiene inversa.");
        }
        return new Fraccion(denominador, numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-numerador, denominador);
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }
}