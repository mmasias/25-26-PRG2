public class Fraccion implements Comparable<Fraccion>, Cloneable {

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

    public Fraccion(Fraccion otra) {
        this.numerador = otra.numerador;
        this.denominador = otra.denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    private void simplificar() {
        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;

        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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
        if (otra.numerador == 0) {
            throw new ArithmeticException("No se puede dividir por 0");
        }
        return new Fraccion(this.numerador * otra.denominador,
                            this.denominador * otra.numerador);
    }

    public Fraccion inversa() {
        if (numerador == 0) {
            throw new ArithmeticException("0 no tiene inversa");
        }
        return new Fraccion(denominador, numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-numerador, denominador);
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    @Override
    public int compareTo(Fraccion otra) {
        int izquierda = this.numerador * otra.denominador;
        int derecha = otra.numerador * this.denominador;
        return Integer.compare(izquierda, derecha);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraccion)) return false;
        Fraccion otra = (Fraccion) obj;
        return this.numerador == otra.numerador &&
               this.denominador == otra.denominador;
    }

    @Override
    public String toString() {
        if (denominador == 1) {
            return String.valueOf(numerador);
        }
        return numerador + "/" + denominador;
    }

    @Override
    public Fraccion clone() {
        return new Fraccion(this);
    }
}