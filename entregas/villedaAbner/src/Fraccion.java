public class Fraccion {

    private int numerador;
    private int denominador;

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public Fraccion(int numerador, int denominador) {
        int mcd = this.calcularMCD(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
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

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoNumerador = (this.numerador * fraccion.denominador) + (this.denominador * fraccion.numerador);
        int nuevoDenominador = this.denominador * fraccion.denominador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);

    }

    public Fraccion restar(Fraccion fraccion) {
        int nuevoNumerador = (this.numerador * fraccion.denominador) - (this.denominador * fraccion.numerador);
        int nuevoDenominador = this.denominador * fraccion.denominador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);

    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador;
        int nuevoDenominador = this.denominador * fraccion.numerador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public boolean esMayor(Fraccion fraccion) {
        int miValorCruzado = this.numerador * fraccion.denominador;
        int otroValorCruzado = this.denominador * fraccion.numerador;

        return miValorCruzado > otroValorCruzado;
    }

    public boolean esMenor(Fraccion fraccion) {
        int miValorCruzado = this.numerador * fraccion.denominador;
        int otroValorCruzado = this.denominador * fraccion.numerador;

        return miValorCruzado > otroValorCruzado;
    }

    public boolean equals(Fraccion fraccion) {
        return this.numerador == fraccion.numerador && this.denominador == fraccion.denominador;
    }

    public double decimal() {
        double dividendo = this.numerador;
        double divisor = this.denominador;

        return dividendo / divisor;
    }

    public void mostrar() {
        System.out.println(numerador + "/" + denominador);
    }

    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public Fraccion invertir() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion oponer() {
        return new Fraccion(this.numerador * -1, this.denominador);
    }

}
